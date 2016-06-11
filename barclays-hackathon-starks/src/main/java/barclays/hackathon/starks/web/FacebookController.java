package barclays.hackathon.starks.web;

import barclays.hackathon.starks.model.ProductRecommended;
import barclays.hackathon.starks.model.UserData;
import barclays.hackathon.starks.model.UserTransformer;
import barclays.hackathon.starks.service.ProductRecommendService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.social.connect.ConnectionRepository;
import org.springframework.social.facebook.api.Facebook;
import org.springframework.social.facebook.api.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

import static org.springframework.http.HttpStatus.OK;
import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8_VALUE;

/**
 * Created by Ashish Sanodia on 11-Jun-16.
 */

@Controller
@RequestMapping("/recommend")
public class FacebookController {

    private Facebook facebook;
    private ConnectionRepository repository;
    private UserTransformer userTransformer;
    private ProductRecommendService service;

    @Autowired
    public FacebookController(Facebook facebook, ConnectionRepository repository, UserTransformer userTransformer, ProductRecommendService service) {
        this.facebook = facebook;
        this.repository = repository;
        this.userTransformer = userTransformer;
        this.service = service;
    }

    @RequestMapping(method = RequestMethod.GET)
    public String helloFacebook(Model model) throws JsonProcessingException {
        if (repository.findPrimaryConnection(Facebook.class) == null) {
            return "redirect:/connect/facebook";
        }
        User user = facebook.userOperations().getUserProfile();

        model.addAttribute("facebookProfile", user);

        System.out.println(new ObjectMapper().writeValueAsString(user));

        List<ProductRecommended> recommendations = getProductRecommendations(user);

        model.addAttribute("recommendations", recommendations);

        return "recommendedProducts";
    }

    @RequestMapping(method = RequestMethod.POST, produces = APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<List<ProductRecommended>> helloFacebook(@RequestBody User user) throws JsonProcessingException {

        List<ProductRecommended> recommendation = getProductRecommendations(user);

        return new ResponseEntity<List<ProductRecommended>>(recommendation, OK);
    }

    private List<ProductRecommended> getProductRecommendations(User user) {
        UserData transformedUserData = userTransformer.transform(user);

        return service.getRecommendation(transformedUserData);
    }
}
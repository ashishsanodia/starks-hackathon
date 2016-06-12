package barclays.hackathon.starks.web;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.social.connect.ConnectionRepository;
import org.springframework.social.facebook.api.Facebook;
import org.springframework.social.facebook.api.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by Ashish Sanodia on 11-Jun-16.
 */

@Controller
@RequestMapping("/recommend")
public class FacebookController {

    private static Logger LOG = Logger.getLogger(FacebookController.class);
    private Facebook facebook;
    private ConnectionRepository repository;

    @Autowired
    public FacebookController(Facebook facebook, ConnectionRepository repository) {
        this.facebook = facebook;
        this.repository = repository;
    }

    @RequestMapping(method = RequestMethod.GET)
    public String helloFacebook(Model model) throws JsonProcessingException {
        if (repository.findPrimaryConnection(Facebook.class) == null) {
            return "redirect:/connect/facebook";
        }
        User user = facebook.userOperations().getUserProfile();

        model.addAttribute("facebookProfile", user);

        LOG.info(new ObjectMapper().writeValueAsString(user));

        return "recommendedProducts";
    }

}
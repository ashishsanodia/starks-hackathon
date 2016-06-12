package barclays.hackathon.starks.web;

import barclays.hackathon.starks.core.weka.engine.RecommendationEngine;
import barclays.hackathon.starks.core.weka.vo.Recommendation;
import barclays.hackathon.starks.model.User;
import barclays.hackathon.starks.service.EmailService;
import barclays.hackathon.starks.service.MockDataService;
import barclays.hackathon.starks.web.vo.UserOffer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Bajrang on 6/11/2016.
 */
@RestController
public class RecommendationController {

    private RecommendationEngine recommendationEngine;
    private MockDataService mockDataService;
    private EmailService emailService;

    @Autowired
    public RecommendationController(RecommendationEngine recommendationEngine, MockDataService mockDataService, EmailService emailService) {
        this.recommendationEngine = recommendationEngine;
        this.mockDataService = mockDataService;
        this.emailService = emailService;
    }

    @RequestMapping(value = "/recommend/{email}")
    public ResponseEntity<UserOffer> getRecommendation(@PathVariable String email) throws Exception {
        User mockUserData = mockDataService.getMockUser(email);
        Recommendation recommendation = recommendationEngine.recommendation(mockUserData);
        UserOffer userOffer = UserOffer.from(mockUserData.getName(), recommendation.getRecommendation(),mockUserData.getLifemoment().name());
        if(mockUserData.isExistingCustomer()){
            emailService.sendMailTo(mockUserData, userOffer);
        }
        return ResponseEntity.accepted().body(userOffer);
    }

    @RequestMapping("/version")
    public ResponseEntity<String> version() {
        return ResponseEntity.ok().body("MLR 1.0");
    }}

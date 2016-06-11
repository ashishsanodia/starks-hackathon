package barclays.hackathon.starks.web;

import barclays.hackathon.starks.core.weka.engine.RecommendationEngine;
import barclays.hackathon.starks.core.weka.vo.Recommendation;
import barclays.hackathon.starks.model.User;
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

    @Autowired
    public RecommendationController(RecommendationEngine recommendationEngine, MockDataService mockDataService) {
        this.recommendationEngine = recommendationEngine;
        this.mockDataService = mockDataService;
    }

    @RequestMapping(value = "/recommend/{email}")
    public ResponseEntity<UserOffer> getRecommendation(@PathVariable String email) throws Exception {
        User mockUserData = mockDataService.getMockUser(email);
        Recommendation recommendation = recommendationEngine.recommendation(mockUserData);
        return ResponseEntity.accepted().body(UserOffer.from(mockUserData.getName(), recommendation.getRecommendation()));
    }

    @RequestMapping("/version")
    public ResponseEntity<String> version() {
        return ResponseEntity.ok().body("MLR 1.0");
    }
}

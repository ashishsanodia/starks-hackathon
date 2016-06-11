package barclays.hackathon.starks.web;

import barclays.hackathon.starks.core.weka.RecommendationEngine;
import barclays.hackathon.starks.core.weka.vo.Recommendation;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Bajrang on 6/11/2016.
 */
@RestController
public class RecommendationController {

    private RecommendationEngine recommendationEngine;

    public RecommendationController(RecommendationEngine recommendationEngine) {
        this.recommendationEngine = recommendationEngine;
    }


    public Recommendation getRecommendation(String email){
        return null;
    }
}

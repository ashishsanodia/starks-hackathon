package barclays.hackathon.starks.core.weka;

import barclays.hackathon.starks.core.weka.classifiers.ProductClassifier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by Bajrang on 6/11/2016.
 */
@Component
public class RecommendationEngine {
    private OfferClassifier offerClassifier;
    private ProductClassifier productClassifier;

    @Autowired
    public RecommendationEngine(OfferClassifier offerClassifier, ProductClassifier productClassifier) {
        this.offerClassifier = offerClassifier;
        this.productClassifier = productClassifier;
    }

}

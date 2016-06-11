package barclays.hackathon.starks.core.weka;

import barclays.hackathon.starks.core.weka.classifiers.Classifier;
import org.springframework.stereotype.Component;
import weka.core.Instance;

/**
 * Created by Bajrang on 6/11/2016.
 */
@Component
public class OfferClassifier implements Classifier {

    @Override
    public Recommendation classify(Instance instanceToClassify) {
        return null;
    }
}

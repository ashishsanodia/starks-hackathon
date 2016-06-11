package barclays.hackathon.starks.core.weka.classifiers;

import barclays.hackathon.starks.core.weka.vo.Recommendation;
import org.springframework.stereotype.Component;
import weka.core.Instance;

/**
 * Created by Bajrang on 6/11/2016.
 */
@Component
public class ProductClassifier implements Classifier {
    @Override
    public Recommendation classify(Instance instanceToClassify) {
        return null;
    }
}

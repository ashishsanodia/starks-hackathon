package barclays.hackathon.starks.core.weka.classifiers;

import barclays.hackathon.starks.core.weka.vo.Recommendation;
import weka.core.Instance;

/**
 * Created by Bajrang on 6/11/2016.
 */
public interface Classifier {
    Recommendation classify(Instance instanceToClassify);
}

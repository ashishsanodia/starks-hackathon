package barclays.hackathon.starks.core.weka;

import barclays.hackathon.starks.core.weka.classifiers.Classifier;
import barclays.hackathon.starks.core.weka.classifiers.ClassifierFactory;
import barclays.hackathon.starks.core.weka.vo.Individual;
import barclays.hackathon.starks.core.weka.vo.Recommendation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by Bajrang on 6/11/2016.
 */
@Component
public class RecommendationEngine {
    private ClassifierFactory classifierFactory;

    @Autowired
    public RecommendationEngine(ClassifierFactory classifierFactory) {
        this.classifierFactory = classifierFactory;
    }

    public Recommendation recommendation(Individual individual) throws Exception {
        Classifier classifier = classifierFactory.getClassifier(individual.isExistingCustomer());
        return classifier.classify(individual);
    }
}

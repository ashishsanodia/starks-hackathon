package barclays.hackathon.starks.core.weka.classifiers;

import barclays.hackathon.starks.core.weka.vo.Recommendation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import weka.classifiers.bayes.NaiveBayesUpdateable;
import weka.core.Instance;

/**
 * Created by Bajrang on 6/11/2016.
 */
@Component
public class OfferClassifier implements Classifier {
    private OfferClassifierTrainer trainer;
    private NaiveBayesUpdateable naiveBayesUpdateable;

    @Autowired
    public OfferClassifier(OfferClassifierTrainer trainer, NaiveBayesUpdateable naiveBayesUpdateable) {
        this.trainer = trainer;
        this.naiveBayesUpdateable = naiveBayesUpdateable;
    }

    @Override
    public Recommendation classify(Instance instanceToClassify) throws Exception {
        NaiveBayesUpdateable trainedNaiveBayesAlgorithm = trainer.trainClassifierAlgorithm(naiveBayesUpdateable);
        double classifyInstance = trainedNaiveBayesAlgorithm.classifyInstance(instanceToClassify);
        return null;
    }
}

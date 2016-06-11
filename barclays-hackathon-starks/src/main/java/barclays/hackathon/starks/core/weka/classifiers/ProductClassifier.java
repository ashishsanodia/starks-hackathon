package barclays.hackathon.starks.core.weka.classifiers;

import barclays.hackathon.starks.core.weka.vo.Individual;
import barclays.hackathon.starks.core.weka.vo.InstanceBuilder;
import barclays.hackathon.starks.core.weka.vo.Recommendation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import weka.classifiers.bayes.NaiveBayesUpdateable;

/**
 * Created by Bajrang on 6/11/2016.
 */
@Component
public class ProductClassifier implements Classifier {
    private ProductClassifierTrainer trainer;
    private NaiveBayesUpdateable naiveBayesUpdateable;

    @Autowired
    public ProductClassifier(ProductClassifierTrainer trainer, NaiveBayesUpdateable naiveBayesUpdateable) {
        this.trainer = trainer;
        this.naiveBayesUpdateable = naiveBayesUpdateable;
    }

    @Override
    public Recommendation classify(Individual individual) throws Exception {
        NaiveBayesUpdateable trainedNaiveBayesAlgorithm = trainer.trainClassifierAlgorithm(naiveBayesUpdateable);
        InstanceBuilder.from(trainer.getDataSchema(), individual);
        double classifyInstance = trainedNaiveBayesAlgorithm.classifyInstance(InstanceBuilder.from(trainer.getDataSchema(), individual));
        //map to offer
        return null;
    }
}

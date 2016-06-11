package barclays.hackathon.starks.core.weka.classifiers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.ResourceUtils;
import weka.classifiers.bayes.NaiveBayesUpdateable;
import weka.core.Instance;
import weka.core.Instances;
import weka.core.converters.ArffLoader;

import java.io.IOException;

/**
 * Created by Bajrang on 6/11/2016.
 */
@Component
public class OfferClassifierLearner {
    private NaiveBayesUpdateable naiveBayesUpdateable;
    private ArffLoader arffLoader;

    @Autowired
    public OfferClassifierLearner(NaiveBayesUpdateable naiveBayesUpdateable, ArffLoader arffLoader) {
        this.naiveBayesUpdateable = naiveBayesUpdateable;
        this.arffLoader = arffLoader;
    }

    public void learnFromTrainingData() {
        try {
            arffLoader.setFile(ResourceUtils.getFile("existing-user.txt"));
            Instances instances = arffLoader.getStructure();
            instances.setClassIndex(instances.numAttributes() - 1);
            naiveBayesUpdateable.buildClassifier(instances);
            Instance current;
            while ((current = arffLoader.getNextInstance(instances)) != null) {
                naiveBayesUpdateable.updateClassifier(current);
            }
        } catch (IOException e) {
            System.err.println("training data not found");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

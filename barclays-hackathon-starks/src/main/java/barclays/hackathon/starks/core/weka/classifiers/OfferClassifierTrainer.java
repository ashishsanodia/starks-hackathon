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
public class OfferClassifierTrainer {
    private ArffLoader arffLoader;

    @Autowired
    public OfferClassifierTrainer(ArffLoader arffLoader) {
        this.arffLoader = arffLoader;
    }

    public NaiveBayesUpdateable trainClassifierAlgorithm(NaiveBayesUpdateable classificationAlgorithm) {
        try {
            arffLoader.setFile(ResourceUtils.getFile("existing-user.txt"));
            Instances instances = arffLoader.getStructure();
            instances.setClassIndex(instances.numAttributes() - 1);
            classificationAlgorithm.buildClassifier(instances);
            updateClassifier(classificationAlgorithm, instances);
        } catch (IOException e) {
            System.err.println("training data not found");
        } catch (Exception e) {
            System.err.println("classification engine failed to learn training data");
        }
        return classificationAlgorithm;
    }

    private void updateClassifier(NaiveBayesUpdateable classificationAlgorithm, Instances instances) throws Exception {
        Instance current;
        while ((current = arffLoader.getNextInstance(instances)) != null) {
            classificationAlgorithm.updateClassifier(current);
        }
    }
}

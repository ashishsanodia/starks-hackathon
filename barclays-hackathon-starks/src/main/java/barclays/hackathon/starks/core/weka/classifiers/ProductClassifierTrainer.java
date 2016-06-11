package barclays.hackathon.starks.core.weka.classifiers;

import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;
import org.springframework.util.ResourceUtils;
import weka.classifiers.bayes.NaiveBayesUpdateable;
import weka.core.Instance;
import weka.core.Instances;
import weka.core.converters.ArffLoader;

import java.io.IOException;
import java.nio.file.Paths;

/**
 * Created by Bajrang on 6/11/2016.
 */
@Component
public class ProductClassifierTrainer {
    private ArffLoader arffLoader;

    public ProductClassifierTrainer() {
        this.arffLoader = new ArffLoader();
    }
    public NaiveBayesUpdateable trainClassifierAlgorithm(NaiveBayesUpdateable classificationAlgorithm) {
        try {
            arffLoader.setFile(new ClassPathResource("new-user.txt").getFile());
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

    public Instances getDataSchema() throws IOException {
        arffLoader.setFile(new ClassPathResource("new-user.txt").getFile());
        Instances instances = arffLoader.getStructure();
        instances.setClassIndex(instances.numAttributes() - 1);
        return instances.stringFreeStructure();
    }
}

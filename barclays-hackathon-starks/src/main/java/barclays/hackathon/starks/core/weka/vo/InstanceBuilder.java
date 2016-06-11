package barclays.hackathon.starks.core.weka.vo;

import weka.core.Attribute;
import weka.core.Instance;
import weka.core.Instances;

/**
 * Created by Bajrang on 6/11/2016.
 */
public class InstanceBuilder {
    public static Instance from(Instances dataSchema, Individual individual) {

        //map different attribute to data schema
        Instances testInstance = dataSchema.stringFreeStructure();
        Instance instance = new Instance(5);

        Attribute currentCard = testInstance.attribute(0);
        instance.setValue(currentCard, 1.0);

        Attribute ageGroup = testInstance.attribute(1);
        instance.setValue(ageGroup, 1.0);

        Attribute location = testInstance.attribute(2);
        instance.setValue(location, 1.0);

        Attribute offer = testInstance.attribute(3);
        instance.setValue(offer, 1.0);

        instance.setDataset(testInstance);

        return instance;
    }
}

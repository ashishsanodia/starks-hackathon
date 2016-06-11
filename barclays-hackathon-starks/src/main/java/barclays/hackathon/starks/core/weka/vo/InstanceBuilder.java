package barclays.hackathon.starks.core.weka.vo;

import barclays.hackathon.starks.model.Card;
import barclays.hackathon.starks.model.LifeMoment;
import weka.core.Attribute;
import weka.core.Instance;
import weka.core.Instances;

/**
 * Created by Bajrang on 6/11/2016.
 */
public class InstanceBuilder {
	public static Instance forExistingUser(Instances dataSchema, User user) {

		// map different attribute to data schema
		Instances testInstance = dataSchema.stringFreeStructure();
		Instance instance = new Instance(5);
		
		Attribute currentCard = testInstance.attribute(0);
		instance.setValue(currentCard, user.getCard().getIndex());

		Attribute ageGroup = testInstance.attribute(1);
		instance.setValue(ageGroup, user.getLifemoment().getIndex());

		Attribute location = testInstance.attribute(2);
		instance.setValue(location, user.getLocation().getIndex());

		Attribute offer = testInstance.attribute(3);
		instance.setValue(offer, individual.);

		instance.setDataset(testInstance);

		return instance;
	}
	
	public static Instance forNewUser(Instances dataSchema, User user) {

		// map different attribute to data schema
		Instances testInstance = dataSchema.stringFreeStructure();
		Instance instance = new Instance(5);
		
		Attribute currentCard = testInstance.attribute(0);
		instance.setValue(currentCard, user.getCard().getIndex());

		Attribute ageGroup = testInstance.attribute(1);
		instance.setValue(ageGroup, user.getLifemoment().getIndex());

		Attribute location = testInstance.attribute(2);
		instance.setValue(location, user.getLocation().getIndex());

		Attribute offer = testInstance.attribute(3);
		instance.setValue(offer, individual.);

		instance.setDataset(testInstance);

		return instance;
	}
}

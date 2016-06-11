package barclays.hackathon.starks.core.weka.classifiers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import barclays.hackathon.starks.core.Offer;
import barclays.hackathon.starks.core.weka.vo.Individual;
import barclays.hackathon.starks.core.weka.vo.InstanceBuilder;
import barclays.hackathon.starks.core.weka.vo.Recommendation;
import weka.classifiers.bayes.NaiveBayesUpdateable;

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
	public Recommendation classify(Individual individual) throws Exception {
		NaiveBayesUpdateable trainedNaiveBayesAlgorithm = trainer.trainClassifierAlgorithm(naiveBayesUpdateable);
		InstanceBuilder.from(trainer.getDataSchema(), individual);
		double offer = trainedNaiveBayesAlgorithm
				.classifyInstance(InstanceBuilder.from(trainer.getDataSchema(), individual));
		return Recommendation.forOffer(Offer.fromOffer(offer).name());
	}
}

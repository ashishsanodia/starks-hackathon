package barclays.hackathon.starks.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import weka.classifiers.bayes.NaiveBayesUpdateable;

/**
 * Created by Bajrang on 6/11/2016.
 */
@Configuration
public class WekaConfiguration {
    @Bean
    public NaiveBayesUpdateable naiveBayesUpdateable() {
        return new NaiveBayesUpdateable();
    }

}

package barclays.hackathon.starks.repository;

import barclays.hackathon.starks.core.weka.vo.Individual;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by Kaniska on 11-Jun-16.
 */
public interface IndividualRepository  extends CrudRepository<Individual, Long> {
    Individual findByEmail(String email);
}

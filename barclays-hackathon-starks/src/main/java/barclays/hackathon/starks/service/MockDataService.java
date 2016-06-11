package barclays.hackathon.starks.service;

import barclays.hackathon.starks.core.weka.vo.User;
import org.joda.time.LocalDate;
import org.springframework.stereotype.Component;

import static barclays.hackathon.starks.core.weka.vo.AgeGroup.AGE_RANGE_25_35;
import static barclays.hackathon.starks.core.weka.vo.UserLocation.METRO;
import static barclays.hackathon.starks.model.Card.Arrival;
import static barclays.hackathon.starks.model.LifeMoment.MARRIAGE;

/**
 * Created by Bajrang on 6/12/2016.
 */
@Component
public class MockDataService {

    public User getMockUser(String email) {
        if (email.contains("existing_user@mail")) {
            return getMockDataForExistingUser();
        }
        return getMockDataForNewUser();
    }

    private User getMockDataForExistingUser() {
        return new User("id-1", "Existing User", "existing_user@mail", METRO, new LocalDate(1988, 8, 29), "Travel", MARRIAGE, AGE_RANGE_25_35, Arrival);
    }

    private User getMockDataForNewUser() {
        return new User("id-1", "New User", "new_user@gmail.com", METRO, new LocalDate(1988, 8, 29), "Travel", MARRIAGE, AGE_RANGE_25_35, null);
    }
}

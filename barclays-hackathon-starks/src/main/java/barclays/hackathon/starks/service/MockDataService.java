package barclays.hackathon.starks.service;

import barclays.hackathon.starks.model.User;
import org.joda.time.LocalDate;
import org.springframework.stereotype.Component;

import static barclays.hackathon.starks.model.AgeRange.AGE_RANGE_25_35;
import static barclays.hackathon.starks.model.Card.Arrival;
import static barclays.hackathon.starks.model.LifeMoment.BIRTHDAY;
import static barclays.hackathon.starks.model.LifeMoment.MARRIAGE;
import static barclays.hackathon.starks.model.UserLocation.METRO;

/**
 * Created by Bajrang on 6/12/2016.
 */
@Component
public class MockDataService {

    public User getMockUser(String email) {
        if (email.equalsIgnoreCase("birthday@mail")) {
            return getMockDataForUserHavingBirthdayLifeMoment(email);
        }
        if (email.contains("existing_user@mail")) {
            return getMockDataForExistingUser();
        }
        return getMockDataForNewUser(email);
    }

    private User getMockDataForExistingUser() {
        User existingUser = new User("id-1", "David", "existing_user@mail", METRO, new LocalDate(1988, 8, 29),
                "Travel", MARRIAGE, AGE_RANGE_25_35, Arrival);
        existingUser.setExistingCustomer(true);

        return existingUser;
    }

    private User getMockDataForNewUser(String email) {
        return new User("id-1", "David", email, METRO, new LocalDate(1988, 8, 29), "Travel", MARRIAGE,
                AGE_RANGE_25_35, null);
    }

    private User getMockDataForUserHavingBirthdayLifeMoment(String email) {
        return new User("id-1", "David", email, METRO, new LocalDate(1988, 8, 29), "Travel", BIRTHDAY,
                AGE_RANGE_25_35, Arrival);
    }
}

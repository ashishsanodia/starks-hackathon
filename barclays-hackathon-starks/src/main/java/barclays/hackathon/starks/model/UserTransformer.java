package barclays.hackathon.starks.model;

import barclays.hackathon.starks.core.weka.vo.Individual;
import org.springframework.social.facebook.api.User;
import org.springframework.stereotype.Component;

/**
 * Created by Ashish Sanodia on 11-Jun-16.
 */
@Component
public class UserTransformer {
    public Individual transform(User user) {
        return new Individual(user.getFirstName(), user.getEmail(),
                user.getLocation() == null ? "user-location" : user.getName(),
                user.getBirthday(), user.getInterestedIn(), getLifeMoment(user));
    }

    private LifeMoment getLifeMoment(User user) {
        if (hasBirthDayInNextFewDays(user)) {
            return LifeMoment.BIRTHDAY;
        }
        if (hasMarriageAniversaryInNextFewDays(user)) {
            return LifeMoment.ANNIVERSARY;
        }
        if (hasMarriageInNextFewDays(user)) {
            return LifeMoment.ANNIVERSARY;
        }
        return LifeMoment.NONE;
    }

    private boolean hasMarriageAniversaryInNextFewDays(User user) {
        //check if user;s marriage anivers is coming
        return true;
    }

    private boolean hasMarriageInNextFewDays(User user) {
        //check if user;s marriage is coming
        return true;
    }

    private boolean hasBirthDayInNextFewDays(User user) {
        //check if user;s birthday is coming
        return true;
    }
}

package barclays.hackathon.starks.model;

import barclays.hackathon.starks.core.weka.vo.AgeGroup;
import barclays.hackathon.starks.core.weka.vo.Individual;
import barclays.hackathon.starks.core.weka.vo.IndividualLocation;
import org.joda.time.LocalDate;
import org.joda.time.Years;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.springframework.social.facebook.api.User;
import org.springframework.stereotype.Component;

import static barclays.hackathon.starks.core.weka.vo.AgeGroup.*;

/**
 * Created by Ashish Sanodia on 11-Jun-16.
 */
@Component
public class UserTransformer {
    final DateTimeFormatter formatter = DateTimeFormat.forPattern("yyyy-MMM-dd");

    public Individual transform(User user) {
        IndividualLocation location = computeCity(user);
        AgeGroup ageGroup = computeAgeGroup(user);
        LocalDate birthday = formatter.parseLocalDate(user.getBirthday());

        Individual individual = new Individual(
                user.getFirstName(),
                user.getEmail(),
                location,
                birthday,
                user.getInterestedIn().toString(),
                getLifeMoment(user),
                ageGroup);
        return individual;
    }

    private IndividualLocation computeCity(User user) {
        return IndividualLocation.fromCity(user.getLocation().getName());
    }

    private AgeGroup computeAgeGroup(User user) {
        LocalDate birthdate = formatter.parseLocalDate(user.getBirthday());
        LocalDate now = new LocalDate();
        int age = Years.yearsBetween(birthdate, now).getYears();

        if (age >= 17 && age <= 25) {
            return AGE_RANGE_17_25;
        } else if (age >= 25 && age <= 35) {
            return AGE_RANGE_25_35;
        } else if (age >= 35) {
            return AGE_RANGE_35_PLUS;
        }
        return AgeGroup.UNKNOWN;
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

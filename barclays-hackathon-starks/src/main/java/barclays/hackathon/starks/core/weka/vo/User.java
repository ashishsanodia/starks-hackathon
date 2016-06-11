package barclays.hackathon.starks.core.weka.vo;


import barclays.hackathon.starks.model.Card;
import barclays.hackathon.starks.model.LifeMoment;
import org.joda.time.LocalDate;

/**
 * Created by Ashish Sanodia on 11-Jun-16.
 */
public class User {
    private String id;
    private String name;
    private String email;
    private UserLocation location;
    private LocalDate dob;
    private String interestedIn;
    private LifeMoment lifemoment;
    private AgeGroup ageGroup;
    private Card card;

    public User(String id,
                String name,
                String email,
                UserLocation location,
                LocalDate dob,
                String interestedIn,
                LifeMoment lifemoment,
                AgeGroup ageGroup,
                Card card) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.location = location;
        this.dob = dob;
        this.interestedIn = interestedIn;
        this.lifemoment = lifemoment;
        this.ageGroup = ageGroup;
        this.card = card;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public UserLocation getLocation() {
        return location;
    }

    public LocalDate getDob() {
        return dob;
    }

    public String getInterestedIn() {
        return interestedIn;
    }

    public LifeMoment getLifemoment() {
        return lifemoment;
    }

    public AgeGroup getAgeGroup() {
        return ageGroup;
    }

    public Card getCard() {
        return card;
    }
}

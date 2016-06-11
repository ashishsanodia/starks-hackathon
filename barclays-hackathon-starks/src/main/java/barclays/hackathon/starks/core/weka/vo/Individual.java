package barclays.hackathon.starks.core.weka.vo;

import barclays.hackathon.starks.model.LifeMoment;

import java.util.List;

/**
 * Created by Ashish Sanodia on 11-Jun-16.
 */
public class Individual {
    private String name;
    private String email;
    private String location;
    private String dob;
    private List<String> interestedIn;
    private LifeMoment lifemoment;
    // private AgeGroup ageGroup;
    //isCustomer
    //customerCurrentCard enum

    public Individual(String name, String email, String location, String dob, List<String> interestedIn, LifeMoment lifemoment) {
        this.name = name;
        this.email = email;
        this.location = location;
        this.dob = dob;
        this.interestedIn = interestedIn;
        this.lifemoment = lifemoment;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getLocation() {
        return location;
    }

    public String getDob() {
        return dob;
    }

    public List<String> getInterestedIn() {
        return interestedIn;
    }

    public LifeMoment getLifemoment() {
        return lifemoment;
    }

    public boolean isExistingCustomer() {
        return false;
    }
}

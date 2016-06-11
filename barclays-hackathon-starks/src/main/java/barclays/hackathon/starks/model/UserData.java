package barclays.hackathon.starks.model;

import java.util.List;

/**
 * Created by Ashish Sanodia on 11-Jun-16.
 */
public class UserData {
    private String name;
    private String email;
    private String location;
    private String dob;
    private List<String> interestedIn;
    private LifeMoment lifemoment;

    public UserData(String name, String email, String location, String dob, List<String> interestedIn, LifeMoment lifemoment) {
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
}

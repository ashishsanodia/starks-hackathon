package barclays.hackathon.starks.core.weka.vo;

import barclays.hackathon.starks.model.LifeMoment;
import org.joda.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Created by Ashish Sanodia on 11-Jun-16.
 */
@Entity
public class Individual {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String name;
    private String email;
    private IndividualLocation location;
    private LocalDate dob;
    private String interestedIn;
    private LifeMoment lifemoment;
    private AgeGroup ageGroup;

    public Individual() {
    }

    public Individual(String name, String email, IndividualLocation location, LocalDate dob, String interestedIn, LifeMoment lifemoment, AgeGroup ageGroup) {
        this.name = name;
        this.email = email;
        this.location = location;
        this.dob = dob;
        this.interestedIn = interestedIn;
        this.lifemoment = lifemoment;
        this.ageGroup = ageGroup;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public IndividualLocation getLocation() {
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

    @Override
    public String toString() {
        return "Individual{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", location=" + location +
                ", dob=" + dob +
                ", interestedIn=" + interestedIn +
                ", lifemoment=" + lifemoment +
                ", ageGroup=" + ageGroup +
                '}';
    }
}

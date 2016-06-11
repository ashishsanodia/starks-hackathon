package barclays.hackathon.starks.core.weka.vo;

import org.joda.time.LocalDate;

import barclays.hackathon.starks.model.Card;
import barclays.hackathon.starks.model.LifeMoment;

/**
 * Created by Ashish Sanodia on 11-Jun-16.
 */
public class User {
	private long id;
	private String name;
	private String email;
	private UserLocation location;
	private LocalDate dob;
	private String interestedIn;
	private LifeMoment lifemoment;
	private AgeGroup ageGroup;
	private Card card;

	public User() {
	}

	public User(String name, String email, UserLocation location, LocalDate dob, String interestedIn,
			LifeMoment lifemoment, AgeGroup ageGroup) {
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

	@Override
	public String toString() {
		return "Individual{" + "id=" + id + ", name='" + name + '\'' + ", email='" + email + '\'' + ", location="
				+ location + ", dob=" + dob + ", interestedIn=" + interestedIn + ", lifemoment=" + lifemoment
				+ ", ageGroup=" + ageGroup + '}';
	}

	public boolean isExistingCustomer() {
		return false;
	}

	public Card getCard() {
		return card;
	}

	public void setCard(Card card) {
		this.card = card;
	}

}

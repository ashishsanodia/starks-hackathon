package barclays.hackathon.starks.web.vo;

/**
 * Created by Bajrang on 6/12/2016.
 */
public class UserOffer {
    private String userName;
    private String offer;

    @SuppressWarnings("unused")
    private UserOffer() {

    }

    private UserOffer(String userName, String offer) {
        this.userName = userName;
        this.offer = offer;
    }

    public static UserOffer from(String userName, String recommendation) {
        return new UserOffer(userName, recommendation);
    }
}

package barclays.hackathon.starks.model;

/**
 * Created by Kaniska on 11-Jun-16.
 */
public class ProductRecommended {
    private String name;
    private String description;
    private String picture;

    public ProductRecommended(String name, String description, String picture) {
        this.name = name;
        this.description = description;
        this.picture = picture;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getPicture() {
        return picture;
    }
}

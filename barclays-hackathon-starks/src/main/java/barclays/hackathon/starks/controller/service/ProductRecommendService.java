package barclays.hackathon.starks.controller.service;

import barclays.hackathon.starks.controller.model.ProductRecommended;
import barclays.hackathon.starks.controller.model.UserData;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Kaniska on 11-Jun-16.
 */
@Service
public class ProductRecommendService {

    public List<ProductRecommended> getRecommendation(UserData userData) {
        List<ProductRecommended> recommendedProducts = new ArrayList<ProductRecommended>();
        recommendedProducts.add(new ProductRecommended("product-id-1", "product-id-1-description", "product-id-1-image-url"));
        recommendedProducts.add(new ProductRecommended("product-id-2", "product-id-2-description", "product-id-2-image-url"));
        recommendedProducts.add(new ProductRecommended("product-id-3", "product-id-3-description", "product-id-3-image-url"));
        return recommendedProducts;
    }
}

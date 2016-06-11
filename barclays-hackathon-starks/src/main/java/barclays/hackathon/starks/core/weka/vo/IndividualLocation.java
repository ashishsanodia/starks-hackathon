package barclays.hackathon.starks.core.weka.vo;

import com.google.common.collect.Maps;

import java.util.Map;

/**
 * Created by Kaniska on 11-Jun-16.
 */
public enum IndividualLocation {
    METRO,
    NON_METRO;

    private static Map<String, String> cities = Maps.newHashMap();

    static {
        cities.put("kolkata", null);
        cities.put("mumbai", null);
        cities.put("delhi", null);
        cities.put("hyderabad", null);
        cities.put("bangalore", null);
    }

    public static IndividualLocation fromCity(String city) {
        if (cities.containsKey(city.toLowerCase())) {
            return METRO;
        }
        return NON_METRO;
    }
}

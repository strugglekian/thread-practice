package four;

import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 摘录Page.59
 * @author kian
 * @date 2019/12/8
 */
public class PublishingVehicleTracker {

    private final Map<String, SafePoint> locations;
    private final Map<String, SafePoint> unmodifiableMap;


    /**
     * unmodifiableMap相当于拷贝了一个locationss的map对象，并且是只读的，保证了线程的安全性
     *
     * @param locations
     */
    public PublishingVehicleTracker(Map<String, SafePoint> locations) {
        this.locations = new ConcurrentHashMap<String, SafePoint>(locations);
        this.unmodifiableMap = Collections.unmodifiableMap(this.locations);
    }

    public Map<String, SafePoint> getLocations() {
        return unmodifiableMap;
    }

    public SafePoint getLocation(String id) {
        return locations.get(id);
    }

    public void setLocation(String id, int x, int y) {
        if (!locations.containsKey(id)) {
            throw new IllegalArgumentException("invalid vehicle name:+id");
        }
        locations.get(id).set(x, y);
    }


}

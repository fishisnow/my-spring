package beans.io;

import java.net.URL;

/**
 * Created by huangyusong on 18-1-8.
 */
public class ResourceLoader {
    public Resource getResource(String location) {
        URL resource = location.getClass().getClassLoader().getResource(location);
        return new URLResource(resource);
    }
}

package beans.io;

import java.io.InputStream;

/**
 * Created by huangyusong on 18-1-8.
 */
public interface Resource {
    InputStream getInputStream() throws Exception;
}

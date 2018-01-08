package beans.io;

import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

/**
 * Created by huangyusong on 18-1-8.
 */
public class URLResource implements Resource{
    private URL url;

    @Override
    public InputStream getInputStream() throws Exception {
        URLConnection urlConnection = url.openConnection();
        urlConnection.connect();
        return urlConnection.getInputStream();
    }

    public URLResource(URL url) {
        this.url = url;
    }
}

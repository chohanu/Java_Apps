package ca.jrvs.apps.twitter.dao.helper.helpers;
import java.net.URI;
import org.apache.http.HttpResponse;

public interface HttpHelper {

    HttpResponse httpPost(URI uri) throws Exception;
    HttpResponse httpGet(URI uri) throws Exception;
}

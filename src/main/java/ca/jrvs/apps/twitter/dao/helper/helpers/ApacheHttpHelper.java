package ca.jrvs.apps.twitter.dao.helper.helpers;

import oauth.signpost.OAuthConsumer;
import oauth.signpost.commonshttp.CommonsHttpOAuthConsumer;
import org.apache.http.client.HttpClient;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.springframework.stereotype.Component;
import java.net.URI;

@Component
public class ApacheHttpHelper implements HttpHelper {
    private HttpClient httpClient;
    private HttpResponse response;
    String CONSUMER_KEY;
    String CONSUMER_SECRET;
    String ACCESS_TOKEN;
    String TOKEN_SECRET;
    OAuthConsumer consumer;

    public ApacheHttpHelper() {
        this.CONSUMER_KEY = System.getenv("CONSUMER_KEY");
        this.CONSUMER_SECRET = System.getenv("CONSUMER_SECRET");
        this.ACCESS_TOKEN = System.getenv("ACCESS_TOKEN");
        this.TOKEN_SECRET = System.getenv("TOKEN_SECRET");
        this.consumer = new CommonsHttpOAuthConsumer(CONSUMER_KEY, CONSUMER_SECRET);
        consumer.setTokenWithSecret(ACCESS_TOKEN, TOKEN_SECRET);
        this.httpClient = new DefaultHttpClient();
    }


    @Override
    public HttpResponse httpPost(URI uri) throws Exception {

        try {
            HttpPost post = new HttpPost(uri);
            consumer.sign(post);
            response = httpClient.execute(post);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return response;

    }

    @Override
    public HttpResponse httpGet(URI uri) throws Exception {

        try {
            HttpGet get = new HttpGet(uri);
            consumer.sign(get);
            response = httpClient.execute(get);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return response;
    }
}












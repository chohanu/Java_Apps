package ca.jrvs.apps.twitter;

import java.util.Arrays;
import oauth.signpost.OAuthConsumer;
import oauth.signpost.commonshttp.CommonsHttpOAuthConsumer;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

public class TwitterApiTest {
    private static String CONSUMER_KEY = "JeFhmD93plrlxuwnCk06T95NT";
    private static String CONSUMER_SECRET = "wHjEtOrAPY5UY1kC4yWKafLBGmuNRoN46KzzLnImxvC7iNzrVM";
    private static String ACCESS_TOKEN = "1060279575215693824-k1McwWeDIAZAWRnekLWVjmiZR5wPMt";
    private static String TOKEN_SECRET = "ZtoMrhNfZEVBiAAjbN0K8txOGyKkdki5JGmDFu9g1iuwr";


    public static void main(String[] args) throws Exception {

        //setup oauth
        OAuthConsumer consumer = new CommonsHttpOAuthConsumer(CONSUMER_KEY, CONSUMER_SECRET);
        consumer.setTokenWithSecret(ACCESS_TOKEN, TOKEN_SECRET);

// create an HTTP GET request
        HttpGet request = new HttpGet("https://api.twitter.com/1.1/users/search.json?q=realDonaldTrump");

// sign the request (add headers)
        consumer.sign(request);
        System.out.println("Http Request Headers:");
        Arrays.stream(request.getAllHeaders()).forEach(System.out::println);

// send/execute the request
        HttpClient httpClient = new DefaultHttpClient();
        HttpResponse response = httpClient.execute(request);
        System.out.println(EntityUtils.toString(response.getEntity()));

    } // end of main
}  // end of class





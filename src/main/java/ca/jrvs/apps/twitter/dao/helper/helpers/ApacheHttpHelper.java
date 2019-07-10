package ca.jrvs.apps.twitter.dao.helper.helpers;

import oauth.signpost.OAuthConsumer;
import oauth.signpost.commonshttp.CommonsHttpOAuthConsumer;
import org.apache.http.client.HttpClient;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;

import java.net.URI;

public class ApacheHttpHelper implements HttpHelper
{
    private HttpClient httpClient;
    private HttpResponse response;

    public ApacheHttpHelper() {

        String CONSUMER_KEY = System.getenv("CONSUMER_KEY");
        String CONSUMER_SECRET = System.getenv("CONSUMER_SECRET");
        String ACCESS_TOKEN = System.getenv("ACCESS_TOKEN");
        String TOKEN_SECRET=System.getenv("TOKEN_SECRET");

        OAuthConsumer consumer = new CommonsHttpOAuthConsumer(CONSUMER_KEY,CONSUMER_SECRET);
        consumer.setTokenWithSecret(ACCESS_TOKEN,TOKEN_SECRET);

        httpClient= new DefaultHttpClient();
    } // end of constructor

    @Override
    public HttpResponse httpPost (URI uri) throws Exception{

        String CONSUMER_KEY = System.getenv("CONSUMER_KEY");
        String CONSUMER_SECRET = System.getenv("CONSUMER_SECRET");
        String ACCESS_TOKEN = System.getenv("ACCESS_TOKEN");
        String TOKEN_SECRET=System.getenv("TOKEN_SECRET");

        OAuthConsumer consumer = new CommonsHttpOAuthConsumer(CONSUMER_KEY,CONSUMER_SECRET);
        consumer.setTokenWithSecret(ACCESS_TOKEN,TOKEN_SECRET);

        try {
            HttpPost post = new HttpPost(uri);
            consumer.sign(post);
            response= httpClient.execute(post);
        }


        finally{}

        return response;

    }

    @Override
    public HttpResponse httpGet (URI uri) throws Exception{

        String CONSUMER_KEY = System.getenv("CONSUMER_KEY");
        String CONSUMER_SECRET = System.getenv("CONSUMER_SECRET");
        String ACCESS_TOKEN = System.getenv("ACCESS_TOKEN");
        String TOKEN_SECRET=System.getenv("TOKEN_SECRET");

        OAuthConsumer consumer = new CommonsHttpOAuthConsumer(CONSUMER_KEY,CONSUMER_SECRET);
        consumer.setTokenWithSecret(ACCESS_TOKEN,TOKEN_SECRET);


        try {

            HttpGet get = new HttpGet(uri);
            consumer.sign(get);

            response = httpClient.execute(get);

        }

        finally{

        }

        return response;

    }



} // end of class












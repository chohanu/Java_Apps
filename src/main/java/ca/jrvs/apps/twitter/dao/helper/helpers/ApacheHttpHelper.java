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

        String CONSUMER_KEY = "cHoLrEwsd1y64IfpDQJmXsTD7";
        String CONSUMER_SECRET = "iA9VWkTipQfPaMlZey1qxJedULnvC3zG1ov3uW1NqSL3EkBxpw";
        String ACCESS_TOKEN = "1060279575215693824-0LyYlhkFErfKJrG2tYD18Z1Hd5IcgN";
        String TOKEN_SECRET = "2jw5VKvFApPSqrr2ik7YRwi6PAK7FLf6jq1FxYWucJqQb";

        OAuthConsumer consumer = new CommonsHttpOAuthConsumer(CONSUMER_KEY,CONSUMER_SECRET);
        consumer.setTokenWithSecret(ACCESS_TOKEN,TOKEN_SECRET);

        httpClient= new DefaultHttpClient();
    } // end of constructor

    @Override
    public HttpResponse httpPost (URI uri) throws Exception{

        String CONSUMER_KEY = "cHoLrEwsd1y64IfpDQJmXsTD7";
        String CONSUMER_SECRET = "iA9VWkTipQfPaMlZey1qxJedULnvC3zG1ov3uW1NqSL3EkBxpw";
        String ACCESS_TOKEN = "1060279575215693824-0LyYlhkFErfKJrG2tYD18Z1Hd5IcgN";
        String TOKEN_SECRET = "2jw5VKvFApPSqrr2ik7YRwi6PAK7FLf6jq1FxYWucJqQb";

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
        String CONSUMER_KEY = "cHoLrEwsd1y64IfpDQJmXsTD7";
        String CONSUMER_SECRET = "iA9VWkTipQfPaMlZey1qxJedULnvC3zG1ov3uW1NqSL3EkBxpw";
        String ACCESS_TOKEN = "1060279575215693824-0LyYlhkFErfKJrG2tYD18Z1Hd5IcgN";
        String TOKEN_SECRET = "2jw5VKvFApPSqrr2ik7YRwi6PAK7FLf6jq1FxYWucJqQb";

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












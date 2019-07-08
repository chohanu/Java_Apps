package ca.jrvs.apps.twitter.dao.helper;

import ca.jrvs.apps.twitter.dto.Tweet;
import com.sun.xml.internal.ws.model.RuntimeModelerException;
import org.apache.http.HttpResponse;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;


public class TwitterRestDao implements CrdRepository<Tweet,String> {

    //URI constants
    private static final String API_BASE_URI ="https://api.twitter.com";
    private static final String POST_PATH ="/1.1/statuses/update.json";
    private static final String SHOW_PATH="/1.1/statuses/show.json";
    private static final String DELETE_PATH ="/1.1/statuses/destroy";

    //URI symbols

    private static final String QUERY_SYM = "?";
    private static final String AMPERSAND = "&";
    private static final String EQUAL = "=";

    //Response code
    private static final int HTTP_OK=200;

    private HttpHelper httphelper;

    public TwitterRestDao(HttpHelper httphelper) {
        this.httphelper = httphelper;
    }

    @Override
    public Tweet create(Tweet tweet) {
        //Construct URI
        URI uri;
        try {
            uri = getPostUri(tweet);

        } catch (URISyntaxException || UnsupportedEncodingException e)
        {
            throw new IllegalArgumentException("Invalid tweet Input");
        }
        //execute HTTP Request
        HttpResponse response = httphelper.httpPost(uri);

        //Validate response
        return parseResponseBody(response, HTTP_OK);

    }

        @Override
                public Tweet findById(String id){
            // Constant URI
        URI uri;

        try{
            uri =getShowUri(id);

        }
        catch(URISyntaxException e)
        {
            throw new IllegalArgumentException("Unable to construct URI",e);
        }

        //execute HTTP Request
        HttpResponse response = httphelper.httpPost(uri);

        //Validate response
        return parseResponseBody(response,HTTP_OK);

    }

    @Override
    public Tweet deleteById(String id)
    {
        URI uri;

        try
        {
            uri=getDeleteUri(id);
        }
        catch(URISyntaxException e){
            throw new IllegalArgumentException("Unable to construct URI",e);

        }
        return parseResponseBody(response, HTTP_OK);
    }



    protected  Tweet parseResponseBody(HttpResponse response,Integer okStatus)
    {
        Tweet tweet = null;
        // check response status
        int status = response.getStatusLine().getStatusCode();
        if(status!= okStatus)
        {
            throw new RuntimeException("Unexpected HTTP STATUS"+ status);

        }

        if(response.getEntity()== null){
            throw new RuntimeException("Empty response Body");
        }
        //Convert Response entity to str
        String jsonStr;
        try{
            jsonStr = EntityUtils.toString(response.getEntity());
        }
        catch(IOException e)
        {
            throw new RuntimeException("failed to convert entity to String",e);
        }

        try{
            return (Tweet) JsonUtil.toObjectFromJson(jsonStr,Tweet.class);
        }
        catch (IOException e)
        {
            throw new RuntimeException("unable to convert json str to object",e);
        }

        return tweet;
    }

protected URI getPostUri(Tweet tweet) throws URISyntaxException,UnsupportedEncodingException {
    String text = tweet.getText();
    Double longitude = tweet.getCoordinates().getCoordinates().get(0);
    Double latitude = tweet.getCoordinates().getCoordinates().get(1);

    StringBuilder sb = new StringBuilder();
    sb.append(API_BASE_URI)
            .append(POST_PATH)
            .append(QUERY_SYM);
    // what does this statement do?

    appendQueryParam(sb, "status", URLEncoder.encode(text, StandardCharsets.UTF_8.name()), true);
    appendQueryParam(sb, "long", longitude.toString(), false);
    appendQueryParam(sb, "lat", latitude.toString(), false);


   return new URI(sb.toString());



}



    protected URI getShowUri(String id) throws URISyntaxException {
        StringBuilder sb = new StringBuilder();
        sb.append(API_BASE_URI)
                .append(SHOW_PATH)
                .append(QUERY_SYM);
        appendQueryParam(sb, "id", id, true);
        return new URI(sb.toString());
    }



    protected URI getDeleteUri(String id) throws URISyntaxException {
        StringBuilder sb = new StringBuilder();
        sb.append(API_BASE_URI)
                .append(DELETE_PATH)
                .append("/")
                .append(id)
                .append(".json");

        return new URI(sb.toString());
    }

    public void appendQueryParam(StringBuilder sb,String key,String value,boolean firstParam)
    {
        if(!firstParam)
        {
            sb.append(AMPERSAND);
        }
        sb.append(key)
                .append(EQUAL)
                .append(value);

}



    } // end of class


package ca.jrvs.apps.twitter.service;

import ca.jrvs.apps.twitter.dao.helper.CrdRepository;
import ca.jrvs.apps.twitter.dto.Coordinates;
import ca.jrvs.apps.twitter.dto.Tweet;
import com.fasterxml.jackson.core.JsonProcessingException;
import java.util.Arrays;
import static ca.jrvs.apps.twitter.example.JsonParser.toJson;

public class TwitterServiceImp implements TwitterService
{

    private static final int MAX_LEN_TWEET =200;
    private CrdRepository dao;

    public TwitterServiceImp(CrdRepository dao)
    {
        this.dao = dao;
    }

    @Override
    public void postTweet(String text,Double latitude,Double longitude)
    {
        Tweet postTweet = joinTweet(text,latitude,longitude);

        try{
            Tweet resp = (Tweet) dao.create(postTweet);
            }
        catch (IllegalArgumentException e)
            {
                System.out.println(e.getMessage());
            }
    }

    public Tweet joinTweet(String text,Double lat,Double longitude) {
        if (text.length() > MAX_LEN_TWEET || lat > 90.0 || lat < -90 || longitude >180  || longitude <-180 )
        {
            throw new IllegalArgumentException();
        }

        Tweet tweet = new Tweet();
        tweet.setText(text);
        Coordinates cord = new Coordinates();
        cord.setCoordinates(Arrays.asList(lat,longitude));
        tweet.setCoordinates(cord);

        try{
            System.out.println(toJson(tweet));
        }
        catch(JsonProcessingException e)
        {
            e.printStackTrace();
        }
        return tweet;
    }

    @Override
    public void deleteTweets(String[] id) {
        for(String i: id)
        {
            try{
                Tweet resp =(Tweet) dao.deleteById(i);
                System.out.println(toJson(resp));
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
        }
    }


    @Override
    public void showTweet(String id, String[] fields)
    {
        try{
            Tweet resp = (Tweet) dao.findById(id);
            System.out.println(toJson(resp));
        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }
} // end of class

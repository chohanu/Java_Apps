package ca.jrvs.apps.twitter;

import ca.jrvs.apps.twitter.dao.helper.CrdRepository;
import ca.jrvs.apps.twitter.service.TwitterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class TwitterCLIRunner {

    public static CrdRepository dao;
    private TwitterService service;

    public TwitterCLIRunner(CrdRepository dao){
        this.dao=dao;
    }

    @Autowired
   public TwitterCLIRunner(TwitterService service) {
        this.service = service;
    }





    public void run(String[] args)
    {

        if(args[0].compareTo("post") == 0)
        {
            parseTweet(args);
        }

        else if (args[0].compareTo("delete")== 0)
        {
            deleteTweet(args);
        }

        else if (args[0].compareTo("show")== 0)
        {
            showTheTweet(args);
        }

        else{
            System.out.println("first argument should be post,show or delete");
             }

    }


    protected void parseTweet(String[] args) {

        if (args.length != 3)
        {
            throw new RuntimeException("usage post |text|lat:lon");
        }
        String text = args[1];
        String[] coordinates = args[2].split(":");
        double lat = Double.parseDouble(coordinates[0]);
        double longitude = Double.parseDouble(coordinates[1]);
        try{
            service.postTweet(text, lat, longitude);
             }
        catch (IllegalArgumentException e)
        {
            throw new IllegalArgumentException();
        }
    }


    protected void showTheTweet(String[] args)
    {
        String id =args[1];
        if (args.length < 2)
        {
            throw new RuntimeException("usage show|id");
        }
        service.showTweet(id,null);
    }

    protected void deleteTweet(String[]args)
    {
        String[] strbreak=args[1].split(",");
        if(args.length < 2)
        {
            throw new RuntimeException("usage delete|id");
        }
        service.deleteTweets(strbreak);
    }
}


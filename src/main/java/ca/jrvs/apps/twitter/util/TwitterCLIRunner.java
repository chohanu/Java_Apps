package ca.jrvs.apps.twitter.util;

import ca.jrvs.apps.twitter.dao.helper.CrdRepository;
import ca.jrvs.apps.twitter.service.TwitterService;

public class TwitterCLIRunner {

    public static CrdRepository dao;
    private TwitterService service;

    public TwitterCLIRunner(TwitterService service) {
        this.service = service;
    }

    public TwitterCLIRunner(CrdRepository dao){
        this.dao=dao;
    }


   public void run(String[] args)
   {

       if(args[0].compareTo("post") == 0)
       {
           parseandpostTweet(args);
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
           System.out.println("first arugment should be post,show or delete");
       }

   }


   protected void parseandpostTweet(String[] args)
   {

       if(args.length !=3)
       {
           throw new RuntimeException("usage post |text|lat:lon");
       }

       String text = args[1];
       String[] coord = args[2].split(":");

       double lat = Double.parseDouble(coord[0]);
       double longitude =Double.parseDouble(coord[1]);

       try{
           service.postTweet(text,lat,longitude);
       }
       catch(Exception e)
       {
           System.out.println("cannot post the tweet");
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





}// end of main

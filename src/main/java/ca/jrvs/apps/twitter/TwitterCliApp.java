package ca.jrvs.apps.twitter;

import ca.jrvs.apps.twitter.dao.helper.CrdRepository;
import ca.jrvs.apps.twitter.dao.helper.TwitterRestDao;
import ca.jrvs.apps.twitter.dao.helper.helpers.ApacheHttpHelper;
import ca.jrvs.apps.twitter.dao.helper.helpers.HttpHelper;
import ca.jrvs.apps.twitter.service.TwitterService;
import ca.jrvs.apps.twitter.service.TwitterServiceImp;


    public class TwitterCliApp {

        public static void main(String[] args)
        {

            HttpHelper httpHelper = new ApacheHttpHelper();
            CrdRepository dao = new TwitterRestDao(httpHelper);
            TwitterService service = new TwitterServiceImp(dao);
            TwitterCLIRunner runner = new TwitterCLIRunner(service);
            runner.run(args);
        }
    }



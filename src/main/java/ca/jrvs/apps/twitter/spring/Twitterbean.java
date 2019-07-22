package ca.jrvs.apps.twitter.spring;


import ca.jrvs.apps.twitter.service.TwitterService;
import ca.jrvs.apps.twitter.service.TwitterServiceImp;
import ca.jrvs.apps.twitter.util.TwitterCLIRunner;
import ca.jrvs.apps.twitter.dao.helper.CrdRepository;
import ca.jrvs.apps.twitter.dao.helper.TwitterRestDao;
import ca.jrvs.apps.twitter.dao.helper.helpers.ApacheHttpHelper;
import ca.jrvs.apps.twitter.dao.helper.helpers.HttpHelper;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

public class Twitterbean {








        public static void main(String[] args) {
            ApplicationContext context = new AnnotationConfigApplicationContext(Twitterbean.class);
            TwitterCLIRunner runner = context.getBean(TwitterCLIRunner.class);
            runner.run(args);
        }

        @Bean
        public TwitterCLIRunner twitterCLIRunner(TwitterService service) {
            return new TwitterCLIRunner(service);
        }

        @Bean
        public TwitterService twitterService(CrdRepository dao) {
            return new TwitterServiceImp(dao);
        }

        @Bean
        public CrdRepository twitterDao(HttpHelper httpHelper) {
            return new TwitterRestDao(httpHelper);
        }

        @Bean
        HttpHelper helper() {
            return new ApacheHttpHelper();
        }


}

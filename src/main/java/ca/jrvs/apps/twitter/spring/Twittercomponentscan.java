package ca.jrvs.apps.twitter.spring;


import ca.jrvs.apps.twitter.util.TwitterCLIRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

    @Configuration
    @ComponentScan(value = "ca.jrvs.apps.twitter")
    public class Twittercomponentscan {

        public static void main(String[] args) {
            ApplicationContext context = new AnnotationConfigApplicationContext(Twittercomponentscan.class);
            TwitterCLIRunner run = context.getBean(TwitterCLIRunner.class);
            run.run(args);
        }

    }




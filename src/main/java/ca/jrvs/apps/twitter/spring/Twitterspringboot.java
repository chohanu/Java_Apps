package ca.jrvs.apps.twitter.spring;

import ca.jrvs.apps.twitter.util.TwitterCLIRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;



@SpringBootApplication(scanBasePackages = "ca.jrvs.apps.twitter")
public class TwitterCLISpringBoot implements CommandLineRunner {

    private TwitterCLIRunner runner;

    @Autowired
    public TwitterCLISpringBoot(TwitterCLIRunner runner) {
        this.runner = runner;
    }

    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(TwitterCLISpringBoot.class);

        //Turn off web
        app.setWebApplicationType(WebApplicationType.NONE);
        app.run(args);
    }

    @Override
    public void run(String... args) throws Exception {
        runner.run(args);
    }

}

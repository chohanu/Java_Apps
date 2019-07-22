package ca.jrvs.apps.twitter.spring;
import ca.jrvs.apps.twitter.util.TwitterCLIRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;





    @SpringBootApplication(scanBasePackages = "ca.jrvs.apps.twitter")
    public class Twitterspringboot implements CommandLineRunner {

        private TwitterCLIRunner runner;

        @Autowired
        public Twitterspringboot(TwitterCLIRunner runner) {
            this.runner = runner;
        }

        public static void main(String[] args) {
            SpringApplication app = new SpringApplication(Twitterspringboot.class);

            //Turn off web
            app.setWebApplicationType(WebApplicationType.NONE);
            app.run(args);
        }

        @Override
        public void run(String... args) throws Exception {
            runner.run(args);
        }

    }

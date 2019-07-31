package ca.jrvs.apps.twitter.dao.helper;

import static org.junit.Assert.*;
import ca.jrvs.apps.twitter.dao.helper.helpers.ApacheHttpHelper;
import ca.jrvs.apps.twitter.dao.helper.helpers.HttpHelper;
import ca.jrvs.apps.twitter.dto.Coordinates;
import ca.jrvs.apps.twitter.dto.Tweet;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.Arrays;
import static ca.jrvs.apps.twitter.example.JsonParser.toJson;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class TwitterRestDaoTest {

        private CrdRepository dao;
        private Tweet actualTweet = new Tweet();
        private Tweet showTweet = new Tweet();
        private Tweet expectedTweet;
        private String id;

        @Before
        public void settingUpTweet() {

            String tweet = "Test tweet" + System.currentTimeMillis();
            actualTweet = new Tweet();
            actualTweet.setText(tweet);
            Coordinates coordinates = new Coordinates();
            coordinates.setCoordinates(Arrays.asList(15.0, 25.0));
            actualTweet.setCoordinates(coordinates);
            HttpHelper httpHelper = new ApacheHttpHelper();
            this.dao = new TwitterRestDao(httpHelper);

        }

        @After
        public void cleaningUp() {
            System.out.println("Delete" + this.id);

            dao.deleteById(this.id);
        }

        @Test
        public void createAndshow() {

            this.expectedTweet = (Tweet) dao.create(actualTweet);
            try {
                System.out.println(toJson(actualTweet));
            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }

            Assert(actualTweet, expectedTweet);
            this.id = expectedTweet.getIdStr();
            this.showTweet = (Tweet) dao.findById(this.id);
            Assert(actualTweet, showTweet);

        }

        public void Assert(Tweet actualtweet, Tweet expectedtweet) {
            assertEquals(actualtweet.getText(), expectedtweet.getText());
            assertEquals(actualtweet.getCoordinates(), expectedtweet.getCoordinates());
            assertNotNull(expectedtweet);

        }

    }


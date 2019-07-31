package ca.jrvs.apps.twitter.service;

import static org.junit.Assert.*;
import ca.jrvs.apps.twitter.dao.helper.CrdRepository;
import ca.jrvs.apps.twitter.dto.Tweet;
import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.fail;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

public class TwitterServiceImpTest_1
{
        @Test
        public void postTweet() {
            CrdRepository mockdao = Mockito.mock(CrdRepository.class);
            TwitterService service = new TwitterServiceImp(mockdao);
            Tweet mocktweet = new Tweet();
            mocktweet.setText("Mock Tweet");
            when(mockdao.create(any())).thenReturn(mocktweet);
            service.postTweet("just a tweet", 0.0, 0.0);

            try {
                service.postTweet("another tweet", 50.0, 230.0);
                fail();
            } catch (IllegalArgumentException e) {
                e.printStackTrace();
            }
            }
            } // end of class
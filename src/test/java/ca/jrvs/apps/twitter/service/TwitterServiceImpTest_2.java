package ca.jrvs.apps.twitter.service;
import ca.jrvs.apps.twitter.dao.helper.CrdRepository;
import ca.jrvs.apps.twitter.dto.Tweet;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import static org.junit.Assert.fail;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;


@RunWith(MockitoJUnitRunner.class)
public class TwitterServiceImpTest_2 {

        @Mock
        private CrdRepository mockdao;
        @InjectMocks
        private TwitterServiceImp service;
        @Test
        public void postTweet()
        {
            Tweet mocktweet = new Tweet();
            mocktweet.setText("Mock Tweet");
            when(mockdao.create(any())).thenReturn(mocktweet);
            service.postTweet("a Tweet", 0.0, 0.0);

            try {
                service.postTweet("another Tweet", 50.0, 230.0);
                fail();
            } catch (IllegalArgumentException e) {
                e.printStackTrace();
            }
            }
            } // end of class


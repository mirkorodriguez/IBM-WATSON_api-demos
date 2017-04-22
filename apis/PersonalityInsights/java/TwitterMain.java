/**
 *   Demonstration of how to retrieve more than 100 tweets using the Twitter API.
 *
 *   It is based upon the Application Authentication example, and therefore uses application
 *   authentication.  It does not matter that much which type of authentication you use, although
 *   it will effect your rate limits.
 *
 *   You will note that this code has only the bare minimum of error handling.  A real production application
 *   would have a lot more code in it to catch, diagnose, and recover from errors at all points of interaction
 *   with Twitter.
 *
 *   @author  Charles McGuinness
 */

import twitter4j.*;
import twitter4j.auth.OAuth2Token;
import twitter4j.conf.ConfigurationBuilder;

import java.util.*;

public class TwitterMain {

  //  Set this to your actual CONSUMER KEY and SECRET for your application as given to you by dev.twitter.com
  private static final String CONSUMER_KEY  = "0caDuYhS4qCuFrj2nHlJhObDB";
  private static final String CONSUMER_SECRET = "sBwB1Cao575cpSjA68IA5sHfBw9f9nM68HJ68AwFjxBC0s86DZ";
  private static final String ACCESS_TOKEN  = "801184453540331520-ypyvOBU5S0qNotktmbKJsc0OFBem1VP";
  private static final String ACCESS_TOKEN_SECRET = "J9IrvQPM7cCgbdTBja52ZMZ5eDBJKxvyUxyiWnV0OKjAA";

  //  How many tweets to retrieve
  private static final int TWEETS_TO_RETRIEVE = 50;

  public static void main(String[] args) {

      String userTwitterAccount = args[0];
      // String userTwitterAccount = "@BillGates";
      System.out.println("User to analyze: " + userTwitterAccount);

      ConfigurationBuilder cb = new ConfigurationBuilder();

      cb.setDebugEnabled(true)
        .setOAuthConsumerKey(CONSUMER_KEY)
        .setOAuthConsumerSecret(CONSUMER_SECRET)
        .setOAuthAccessToken(ACCESS_TOKEN)
        .setOAuthAccessTokenSecret(ACCESS_TOKEN_SECRET);

      TwitterFactory tf = new TwitterFactory(cb.build());
      Twitter twitter = tf.getInstance();

      List<Status> statusList = null;

     try {
          Paging paging = new Paging(1, TWEETS_TO_RETRIEVE);
          statusList = twitter.getUserTimeline(userTwitterAccount,paging);
          // statusList = twitter.getUserTimeline("@BillGates");
      } catch (TwitterException e) {
          // TODO Auto-generated catch block
          e.printStackTrace();
      }

      for (Status status : statusList) {
          // System.out.println(status.toString());
          System.out.println(status.getText().toString());
      }
  }

}

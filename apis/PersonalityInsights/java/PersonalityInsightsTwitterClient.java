import com.ibm.watson.developer_cloud.personality_insights.v3.PersonalityInsights;
import com.ibm.watson.developer_cloud.personality_insights.v3.model.Profile;
import com.ibm.watson.developer_cloud.personality_insights.v3.model.Language;
import com.ibm.watson.developer_cloud.personality_insights.v3.model.AcceptLanguage;
import com.ibm.watson.developer_cloud.personality_insights.v3.model.ProfileOptions;

import twitter4j.*;
import twitter4j.auth.OAuth2Token;
import twitter4j.conf.ConfigurationBuilder;

import java.io.*;
import java.util.*;

public class PersonalityInsightsTwitterClient {

  public static void main(String[] args) {

    String userTwitterAccount=args[0];
    System.out.println("User to analyze: " + userTwitterAccount);

    //API cedentials
    String userName="842a005c-8baa-4e4e-a2f2-a915e89fd185";
    String passWord="zLSpcxCsfAqk";
    PersonalityInsights service = new PersonalityInsights("2016-10-20");
    service.setUsernameAndPassword(userName, passWord);

    //Get text to analyze from twitter
    String text="";
    PersonalityInsightsTwitterClient clazz = new PersonalityInsightsTwitterClient();
    // text = clazz.getTwittsByAccount("@BillGates");
    text = clazz.getTwittsByAccount(userTwitterAccount);
    System.out.println("After reading file");
    System.out.println(text);

    ProfileOptions options = new ProfileOptions.Builder()
                                 .language(Language.ENGLISH) //Input text language
                                 .text(text)
                                 .acceptLanguage(AcceptLanguage.SPANISH) //Output text language
                                 .build();

    Profile profile = service.getProfile(options).execute();

    //final results
    System.out.println(profile);
  }


  private String getTwittsByAccount(String userTwitterAccount){

    //Twitter credentials
    String CONSUMER_KEY  = "0caDuYhS4qCuFrj2nHlJhObDB";
    String CONSUMER_SECRET = "sBwB1Cao575cpSjA68IA5sHfBw9f9nM68HJ68AwFjxBC0s86DZ";
    String ACCESS_TOKEN  = "801184453540331520-ypyvOBU5S0qNotktmbKJsc0OFBem1VP";
    String ACCESS_TOKEN_SECRET = "J9IrvQPM7cCgbdTBja52ZMZ5eDBJKxvyUxyiWnV0OKjAA";
    //  How many tweets to retrieve
    int TWEETS_TO_RETRIEVE = 100;

    ConfigurationBuilder cb = new ConfigurationBuilder();

    cb.setDebugEnabled(true)
      .setOAuthConsumerKey(CONSUMER_KEY)
      .setOAuthConsumerSecret(CONSUMER_SECRET)
      .setOAuthAccessToken(ACCESS_TOKEN)
      .setOAuthAccessTokenSecret(ACCESS_TOKEN_SECRET);

    TwitterFactory tf = new TwitterFactory(cb.build());
    Twitter twitter = tf.getInstance();

    List<Status> statusList = null;
    String str = "";

    try {
          Paging paging = new Paging(1, TWEETS_TO_RETRIEVE);
          statusList = twitter.getUserTimeline(userTwitterAccount,paging);
    } catch (TwitterException e) {
          // TODO Auto-generated catch block
          e.printStackTrace();
    }

    for (Status status : statusList) {
          // System.out.println(status.toString());
          // System.out.println(status.getText().toString());
          str += status.getText().toString();
    }
      return str;
    }

}

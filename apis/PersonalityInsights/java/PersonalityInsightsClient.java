import com.ibm.watson.developer_cloud.personality_insights.v3.PersonalityInsights;
import com.ibm.watson.developer_cloud.personality_insights.v3.model.Profile;
import com.ibm.watson.developer_cloud.personality_insights.v3.model.Language;
import com.ibm.watson.developer_cloud.personality_insights.v3.model.AcceptLanguage;
import com.ibm.watson.developer_cloud.personality_insights.v3.model.ProfileOptions;

import java.io.*;

public class PersonalityInsightsClient {

  public static void main(String[] args) {

    //API cedentials
    String userName="842a005c-8baa-4e4e-a2f2-a915e89fd185";
    String passWord="zLSpcxCsfAqk";
    PersonalityInsights service = new PersonalityInsights("2016-10-20");
    service.setUsernameAndPassword(userName, passWord);

    //Get text to analyze from a file
    String text="";
    try {
      File file = new File("../resources/sample.en.txt");
      PersonalityInsightsClient clazz = new PersonalityInsightsClient();
      text = clazz.readFile(file);
      System.out.println("After reading file");
      System.out.println(text);
    } catch (IOException e) {
      e.printStackTrace();
    }

    ProfileOptions options = new ProfileOptions.Builder()
                                 .language(Language.ENGLISH) //Input text language
                                 .text(text)
                                 .acceptLanguage(AcceptLanguage.SPANISH) //Output text language
                                 .build();

    Profile profile = service.getProfile(options).execute();

    //final results
    System.out.println(profile);
  }


  private String readFile(File file) throws IOException {

    FileInputStream fis = null;
    String str = "";

    try {
        fis = new FileInputStream(file);
        int content;
        while ((content = fis.read()) != -1) {
            // convert to char and display it
            str += (char) content;
        }
    } catch (IOException e) {
        e.printStackTrace();
    } finally {
        try {
            if (fis != null)
                fis.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    return str;
  }

}

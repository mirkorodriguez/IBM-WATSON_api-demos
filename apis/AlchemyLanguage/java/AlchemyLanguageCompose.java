import com.ibm.watson.developer_cloud.alchemy.v1.AlchemyLanguage;
import com.ibm.watson.developer_cloud.alchemy.v1.model.CombinedResults;

import java.util.*;

public class AlchemyLanguageCompose {

  public static void main(String[] args) {

    //API cedentials
    String API_KEY="905d6b2630433096e24124123450e4798d67913f";
    String URL="https://www.washingtonpost.com/opinions/trump-is-playing-a-risky-spy-game/2016/12/13/1c262bbc-c17c-11e6-9578-0054287507db_story.html";

    AlchemyLanguage service = new AlchemyLanguage();
    service.setApiKey(API_KEY);

    Map<String,Object> params = new HashMap<String, Object>();

    params.put(AlchemyLanguage.URL, URL);
    CombinedResults combinedResults = service.getCombinedResults(params).execute();
    System.out.println(combinedResults);

  }

}

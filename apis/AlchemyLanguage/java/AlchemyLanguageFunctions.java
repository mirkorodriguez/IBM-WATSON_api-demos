import com.ibm.watson.developer_cloud.alchemy.v1.AlchemyLanguage;
import com.ibm.watson.developer_cloud.alchemy.v1.model.DocumentSentiment;
import com.ibm.watson.developer_cloud.alchemy.v1.model.DocumentEmotion;
import com.ibm.watson.developer_cloud.alchemy.v1.model.DocumentAuthors;
import com.ibm.watson.developer_cloud.alchemy.v1.model.Concepts;
import com.ibm.watson.developer_cloud.alchemy.v1.model.DocumentPublicationDate;
import com.ibm.watson.developer_cloud.alchemy.v1.model.Taxonomies;
import com.ibm.watson.developer_cloud.alchemy.v1.model.Feeds;
import com.ibm.watson.developer_cloud.alchemy.v1.model.Entities;
import com.ibm.watson.developer_cloud.alchemy.v1.model.Keywords;
import com.ibm.watson.developer_cloud.alchemy.v1.model.Language;
import com.ibm.watson.developer_cloud.alchemy.v1.model.Microformats;
import com.ibm.watson.developer_cloud.alchemy.v1.model.SAORelations;
import com.ibm.watson.developer_cloud.alchemy.v1.model.DocumentSentiment;
import com.ibm.watson.developer_cloud.alchemy.v1.model.DocumentText;
import com.ibm.watson.developer_cloud.alchemy.v1.model.DocumentTitle;
import com.ibm.watson.developer_cloud.alchemy.v1.model.TypedRelations;
import com.ibm.watson.developer_cloud.alchemy.v1.model.Dates;

import java.util.*;

public class AlchemyLanguageFunctions {

  public static void main(String[] args) {

    //API cedentials
    String API_KEY="905d6b2630433096e24124123450e4798d67913f";
    String URL="https://www.washingtonpost.com/opinions/trump-is-playing-a-risky-spy-game/2016/12/13/1c262bbc-c17c-11e6-9578-0054287507db_story.html";

    AlchemyLanguage service = new AlchemyLanguage();
    service.setApiKey(API_KEY);

    Map<String,Object> params = new HashMap<String, Object>();

    // // authors (HTML)
    // params.put(AlchemyLanguage.HTML, "../resources/example.html");
    // DocumentAuthors authors = service.getAuthors(params).execute();
    // System.out.println(authors);

    // // authors (URL)
    // params.put(AlchemyLanguage.URL, URL);
    // DocumentAuthors authors = service.getAuthors(params).execute();
    // System.out.println(authors);

    // // concepts
    // params.put(AlchemyLanguage.URL, URL);
    // Concepts concepts = service.getConcepts(params).execute();
    // System.out.println(concepts);

    // // DocumentPublicationDate
    // params.put(AlchemyLanguage.URL, URL);
    // DocumentPublicationDate documentPublicationDate = service.getPublicationDate(params).execute();
    // System.out.println(documentPublicationDate);

    // // Taxonomies
    // params.put(AlchemyLanguage.URL, URL);
    // Taxonomies taxonomies = service.getTaxonomy(params).execute();
    // System.out.println(taxonomies);

    // // Taxonomies
    // params.put(AlchemyLanguage.URL, URL);
    // Taxonomies taxonomies = service.getTaxonomy(params).execute();
    // System.out.println(taxonomies);

    // // Entities
    // params.put(AlchemyLanguage.URL, URL);
    // Entities entities = service.getEntities(params).execute();
    // System.out.println(entities);

    // // Feeds
    // params.put(AlchemyLanguage.URL, URL);
    // Feeds feeds = service.getFeeds(params).execute();
    // System.out.println(feeds);

    // // Keywords
    // params.put(AlchemyLanguage.URL, URL);
    // Keywords keywords = service.getKeywords(params).execute();
    // System.out.println(keywords);

    // // Language
    // params.put(AlchemyLanguage.URL, URL);
    // Language language = service.getLanguage(params).execute();
    // System.out.println(language);

    // // Microformats
    // params.put(AlchemyLanguage.URL, URL);
    // Microformats microformats = service.getMicroformats(params).execute();
    // System.out.println(microformats);

    // // Microformats
    // params.put(AlchemyLanguage.URL, URL);
    // SAORelations relations = service.getRelations(params).execute();
    // System.out.println(relations);

    // // Sentiment
    // params.put(AlchemyLanguage.URL, URL);
    // DocumentSentiment sentiment = service.getSentiment(params).execute();
    // System.out.println(sentiment);

    // // Text
    // params.put(AlchemyLanguage.URL, URL);
    // DocumentText text = service.getText(params).execute();
    // System.out.println(text);

    // // Title
    // params.put(AlchemyLanguage.URL, URL);
    // DocumentTitle title = service.getTitle(params).execute();
    // System.out.println(title);

    // // Emotion
    // params.put(AlchemyLanguage.TEXT, "IBM Watson won the Jeopardy television show hosted by Alex Trebek");
    // DocumentEmotion emotion = service.getEmotion(params).execute();
    // System.out.println(emotion);

    // // TypedRelations
    // params.put(AlchemyLanguage.URL, URL);
    // TypedRelations typedRelations = service.getTypedRelations(params).execute();
    // System.out.println(typedRelations);

    // Dates
    params.put(AlchemyLanguage.URL, URL);
    Dates dates = service.getDates(params).execute();
    System.out.println(dates);
  }

}

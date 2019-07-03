import com.ibm.watson.developer_cloud.natural_language_classifier.v1.NaturalLanguageClassifier;
import com.ibm.watson.developer_cloud.natural_language_classifier.v1.model.Classification;
import com.ibm.watson.developer_cloud.natural_language_classifier.v1.model.ClassifyOptions;
import com.ibm.watson.developer_cloud.service.security.IamOptions;

public class NaturalLanguageClassifierClientIAM {

  public static void main(String[] args) {

    //API cedentials
    IamOptions options = new IamOptions.Builder()
    .apiKey("wertytrychghfgh")
    .build();

    NaturalLanguageClassifier naturalLanguageClassifier = new NaturalLanguageClassifier(options);
    naturalLanguageClassifier.setEndPoint("https://gateway.watsonplatform.net/natural-language-classifier/api");

    ClassifyOptions classifyOptions = new ClassifyOptions.Builder()
    .classifierId("asftrertert")
    .text("Presentacion del trabajo final")
    .build();

    Classification classification = naturalLanguageClassifier.classify(classifyOptions)
    .execute();

    //final results
    System.out.println(classification);
  }

}

import com.ibm.watson.developer_cloud.natural_language_classifier.v1.model.Classifier;
import com.ibm.watson.developer_cloud.natural_language_classifier.v1.model.Classification;
import com.ibm.watson.developer_cloud.natural_language_classifier.v1.NaturalLanguageClassifier;

import java.io.*;

public class NaturalLanguageClassifierClient {

  public static void main(String[] args) {

    //API cedentials
    String userName="569206c1-3641-4e54-9438-7fbda0f146a0";
    String passWord="rPYrOqVdpfBi";

    NaturalLanguageClassifier service = new NaturalLanguageClassifier();
    service.setUsernameAndPassword(userName, passWord);

    //Classify a sentence
    String sentenceToClassify = "How hot will it be today?";
    String classifierID = "d67c64x140-nlc-1059";
    Classification classification = service.classify(classifierID,sentenceToClassify).execute();

    //final results
    System.out.println(classification);
  }

}

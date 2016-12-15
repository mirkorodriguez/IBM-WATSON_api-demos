import com.ibm.watson.developer_cloud.natural_language_classifier.v1.model.Classifier;
import com.ibm.watson.developer_cloud.natural_language_classifier.v1.NaturalLanguageClassifier;

import java.io.*;

public class NaturalLanguageClassifierTrain {

  public static void main(String[] args) {

    //API cedentials
    String userName="569206c1-3641-4e54-9438-7fbda0f146a0";
    String passWord="rPYrOqVdpfBi";

    NaturalLanguageClassifier service = new NaturalLanguageClassifier();
    service.setUsernameAndPassword(userName, passWord);

    //Create and train a classifier
    File fileUsedToTrain = new File("../resources/weather_data_train.csv");
    Classifier classifier = service.createClassifier("MyTutorialClassifier", "en",fileUsedToTrain).execute();

    //final results
    System.out.println(classifier);
  }

}

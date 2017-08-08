
import com.ibm.watson.developer_cloud.speech_to_text.v1.SpeechToText;
import com.ibm.watson.developer_cloud.speech_to_text.v1.websocket.BaseRecognizeCallback;
import com.ibm.watson.developer_cloud.speech_to_text.v1.model.RecognizeOptions;
import com.ibm.watson.developer_cloud.speech_to_text.v1.model.SpeechResults;
import com.ibm.watson.developer_cloud.speech_to_text.v1.model.SpeechAlternative;
import com.ibm.watson.developer_cloud.service.WatsonService;

import java.io.*;
import java.util.*;

public class SpeechToTextClient {

  public static void main(String[] args) {

    SpeechToText service = new SpeechToText();
    service.setUsernameAndPassword("6fdc3be5-ff02-4fc7-a071-4c602dfbd9d0", "6UDGmNqKySUz");

    // RecognizeOptions options = new RecognizeOptions.Builder()
    //   .contentType("audio/flac")
    //   .timestamps(true)
    //   .wordAlternativesThreshold(0.9)
    //   .keywords(new String[]{"colorado", "tornado", "tornadoes"})
    //   .keywordsThreshold(0.5)
    //   .build();

    String audioToText = "";

    RecognizeOptions options = new RecognizeOptions.Builder()
      .model("es-ES_NarrowbandModel")
      .contentType("audio/wav")
      .interimResults(true)
      .maxAlternatives(3)
      .keywords(new String[]{"llamadas", "llamada", "llamar"})
      .keywordsThreshold(0.5)
      .build();

      String file = "../audio/tc_recordingaudio.wav";

      SpeechResults results = service.recognize(new File(file), options).execute();
      List alternatives = results.getResults().get(results.getResults().size() - 1).getAlternatives();
      SpeechAlternative speechAlternative = (SpeechAlternative)alternatives.get(0);
      System.out.println(speechAlternative.getConfidence());
      if (speechAlternative.getConfidence() > 0.5){
        audioToText = speechAlternative.getTranscript();
      }
      System.out.println(audioToText);


    // RecognizeOptions options = new RecognizeOptions.Builder()
    //   .model("es-ES_NarrowbandModel")
    //   .contentType("audio/wav")
    //   .interimResults(true)
    //   .maxAlternatives(3)
    //   .keywords(new String[]{"llamadas", "llamada", "llamar"})
    //   .keywordsThreshold(0.5)
    //   .build();
    //
    // BaseRecognizeCallback callback = new BaseRecognizeCallback() {
    //   @Override
    //   public void onTranscription(SpeechResults speechResults) {
    //     SpeechResults mySpeechResults = speechResults;
    //     List results = mySpeechResults.getResults();
    //     System.out.println(" final: --> " + results.get(0));
    //     System.out.println(speechResults);
    //     //String finalText = speechResults.results.final;
    //     //System.out.println(" finalText : " + finalText);
    //   }
    //
    //   @Override
    //   public void onDisconnected() {
    //     System.exit(0);
    //   }
    // };
    //
    // try {
    //   service.recognizeUsingWebSocket(new FileInputStream("../audio/tc_recordingaudio.wav"), options, callback);
    // }
    // catch (FileNotFoundException e) {
    //   e.printStackTrace();
    // }

  }

}

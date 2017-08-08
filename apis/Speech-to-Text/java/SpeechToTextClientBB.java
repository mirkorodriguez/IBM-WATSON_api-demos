
import com.ibm.watson.developer_cloud.speech_to_text.v1.SpeechToText;
import com.ibm.watson.developer_cloud.speech_to_text.v1.model.RecognizeOptions;
import com.ibm.watson.developer_cloud.speech_to_text.v1.model.SpeechResults;
import com.ibm.watson.developer_cloud.speech_to_text.v1.websocket.BaseRecognizeCallback;
import com.ibm.watson.developer_cloud.service.WatsonService;

import java.io.*;

public class SpeechToTextClientBB {

  public static void main(String[] args) {

    SpeechToText service = new SpeechToText();
    service.setUsernameAndPassword("6fdc3be5-ff02-4fc7-a071-4c602dfbd9d0", "6UDGmNqKySUz");

    RecognizeOptions options = new RecognizeOptions.Builder()
      .model("en-US_BroadbandModel").contentType("audio/flac")
      .interimResults(true).maxAlternatives(3)
      .keywords(new String[]{"colorado", "tornado", "tornadoes"})
      .keywordsThreshold(0.5).build();

    BaseRecognizeCallback callback = new BaseRecognizeCallback() {
      @Override
      public void onTranscription(SpeechResults speechResults) {
        System.out.println(speechResults);
      }

      @Override
      public void onDisconnected() {
        System.exit(0);
      }
    };

    try {
      service.recognizeUsingWebSocket(new FileInputStream("../audio/audio-file.flac"), options, callback);
    }
    catch (FileNotFoundException e) {
      e.printStackTrace();
    }

  }

}

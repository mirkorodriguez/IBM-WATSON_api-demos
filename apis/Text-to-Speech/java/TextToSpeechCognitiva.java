import com.ibm.watson.developer_cloud.text_to_speech.v1.TextToSpeech;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import java.io.InputStream;
import java.lang.reflect.Type;
import java.util.Collections;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.ibm.watson.developer_cloud.http.HttpMediaType;
import com.ibm.watson.developer_cloud.http.RequestBuilder;
import com.ibm.watson.developer_cloud.http.ResponseConverter;
import com.ibm.watson.developer_cloud.http.ServiceCall;
import com.ibm.watson.developer_cloud.service.WatsonService;
import com.ibm.watson.developer_cloud.text_to_speech.v1.model.AudioFormat;
import com.ibm.watson.developer_cloud.text_to_speech.v1.model.CustomTranslation;
import com.ibm.watson.developer_cloud.text_to_speech.v1.model.CustomVoiceModel;
import com.ibm.watson.developer_cloud.text_to_speech.v1.model.Phoneme;
import com.ibm.watson.developer_cloud.text_to_speech.v1.model.Pronunciation;
import com.ibm.watson.developer_cloud.text_to_speech.v1.model.Voice;
import com.ibm.watson.developer_cloud.util.*;

public class TextToSpeechCognitiva extends TextToSpeech {

  private static final String URL = "https://stream.watsonplatform.net/text-to-speech/api";
  private static final String PATH_VOICES = "/v1/voices";
  private static final String PATH_VOICE = "/v1/voices/%s";
  private static final String PATH_SYNTHESIZE = "/v1/synthesize";
  private static final String PATH_GET_PRONUNCIATION = "/v1/pronunciation";
  private static final String PATH_CUSTOMIZATIONS = "/v1/customizations";
  private static final String PATH_CUSTOMIZATION = PATH_CUSTOMIZATIONS + "/%s";
  private static final String PATH_WORDS = PATH_CUSTOMIZATION + "/words";
  private static final String PATH_WORD = PATH_WORDS + "/%s";

  private static final String SERVICE_NAME = "text_to_speech";
  private static final String ACCEPT = "accept";
  private static final String TEXT = "text";
  private static final String VOICE = "voice";
  private static final String VOICES = "voices";
  private static final String FORMAT = "format";
  private static final String CUSTOMIZATION_ID = "customization_id";
  private static final String CUSTOMIZATIONS = "customizations";
  private static final String LANGUAGE = "language";
  private static final String WORDS = "words";

  private static final Type TYPE_GET_VOICES = new TypeToken<List<Voice>>() { }.getType();
  private static final Type TYPE_VOICE_MODELS = new TypeToken<List<CustomVoiceModel>>() { }.getType();
  private static final Type TYPE_CUSTOM_TRANSLATIONS = new TypeToken<List<CustomTranslation>>() { }.getType();
  private static final Gson GSON = GsonSingleton.getGson();

  @Override
  /**
   * Synthesize text using a {@link Voice} and {@link AudioFormat}.
   *
   * @param text the text
   * @param voice the voice
   * @param audioFormat the {@link AudioFormat}
   * @param customizationId the customization ID
   * @return the input stream
   */
  public ServiceCall<InputStream> synthesize(final String text, final Voice voice, final AudioFormat audioFormat, String customizationId) {
    Validator.isTrue((text != null) && !text.isEmpty(), "text cannot be null or empty");
    Validator.isTrue(voice != null, "voice cannot be null or empty");

    String encodedText = this.encodeTo(text, "UTF-8");

    final RequestBuilder request = RequestBuilder.get(PATH_SYNTHESIZE);
    request.query(TEXT, encodedText);
    request.query(VOICE, voice.getName());
    request.query(ACCEPT, audioFormat != null ? audioFormat : AudioFormat.WAV);

    if (customizationId != null) {
      request.query(CUSTOMIZATION_ID, customizationId);
    }

    return createServiceCall(request.build(), ResponseConverterUtils.getInputStream());
  }

  private String encodeTo(String content, String encodeType){
    String textEncoded="";
    try {
      //Encode type "UTF-8"
      textEncoded = URLEncoder.encode(content, encodeType).replace("+", "%20");
      System.out.println("Test Encoded " + encodeType + ": " + textEncoded);
    } catch (final UnsupportedEncodingException e) {
      // throw new Exception(e);
    }
    return textEncoded;
  }

}

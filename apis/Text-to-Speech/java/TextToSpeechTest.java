
/**
This is a workaround prepared by Mirko J. Rodriguez <mirodriguez@cognitiva> from Cognitiva Peru to solve the enconded issues.
**/

import java.io.File;
import java.util.List;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.FileOutputStream;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.UnsupportedAudioFileException;

import com.ibm.watson.developer_cloud.text_to_speech.v1.model.AudioFormat;
import com.ibm.watson.developer_cloud.text_to_speech.v1.model.Phoneme;
import com.ibm.watson.developer_cloud.text_to_speech.v1.model.Pronunciation;
import com.ibm.watson.developer_cloud.text_to_speech.v1.model.Voice;
import com.ibm.watson.developer_cloud.text_to_speech.v1.util.WaveUtils;
import com.ibm.watson.developer_cloud.text_to_speech.v1.TextToSpeech;


/**
 * Text to Speech integration tests.
 */
public class TextToSpeechTest {

  // @Test
  // public void testSynthesizeAndFixHeader() throws IOException, UnsupportedAudioFileException {
  //   String text = "one two three four five";
  //   InputStream result = service.synthesize(text, Voice.EN_LISA, AudioFormat.WAV).execute();
  //   assertNotNull(result);
  //   result = WaveUtils.reWriteWaveHeader(result);
  //   File tempFile = File.createTempFile("output", ".wav");
  //   writeInputStreamToFile(result, tempFile);
  //   assertNotNull(AudioSystem.getAudioFileFormat(tempFile));
  // }

  public static void main(String[] args) {

    // TextToSpeech service = new TextToSpeech();
    TextToSpeechCognitiva service = new TextToSpeechCognitiva();
    service.setUsernameAndPassword("fa51a9fd-2fd9-4bb3-8f96-ed63678e9338", "fBEgtEydZCiK");

    try {

      String text = "El Arte de la Guerra – Sun Tzu - Capítulo 1. " +
      "Contenido Gratuito, Audiolibro Alojado en IGETAX, Regístrate y accede a más contenido. " +
      "Sobre la evaluación. " +
      "La guerra es de vital importancia para el Estado; es el dominio de la vida o de la muerte, el camino hacia la supervivencia o la pérdida del Imperio: es forzoso manejarla bien. No reflexionar seriamente sobre todo lo que le concierne es dar prueba de una culpable indiferencia en lo que respecta a la conservación o pérdida de lo que nos es más querido; y ello no debe ocurrir entre nosotros.";

      InputStream stream = service.synthesize(text, Voice.ES_ENRIQUE,AudioFormat.WAV).execute();
      // InputStream stream = service.synthesize(text, Voice.ES_LAURA,AudioFormat.WAV).execute();
      // InputStream stream = service.synthesize(text, Voice.ES_SOFIA,AudioFormat.WAV).execute();

      InputStream in = WaveUtils.reWriteWaveHeader(stream);

      OutputStream out = new FileOutputStream("output_enrique1.wav");
      // OutputStream out = new FileOutputStream("output_laura.wav");
      // OutputStream out = new FileOutputStream("output_sofia.wav");

      byte[] buffer = new byte[1024];
      int length;
      while ((length = in.read(buffer)) > 0) {
        out.write(buffer, 0, length);
      }
      out.close();
      in.close();
      stream.close();
    }
    catch (Exception e) {
      e.printStackTrace();
    }

  }

}

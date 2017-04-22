import java.lang.ProcessBuilder;
import java.io.*;

public class CallTextToSpeech{

  public static void main(String[] args) throws IOException {

      String text = "El Arte de la Guerra – Sun Tzu - Capítulo 1. " +
      "Contenido Gratuito, Audiolibro Alojado en IGETAX, Regístrate y accede a más contenido. " +
      "Sobre la evaluación. " +
      "La guerra es de vital importancia para el Estado; es el dominio de la vida o de la muerte, el camino hacia la supervivencia o la pérdida del Imperio: es forzoso manejarla bien. No reflexionar seriamente sobre todo lo que le concierne es dar prueba de una culpable indiferencia en lo que respecta a la conservación o pérdida de lo que nos es más querido; y ello no debe ocurrir entre nosotros.";

      // {"/bin/bash", "shell", "user","password","textToVoice"};
      String[] command = {"/bin/bash", "executeSTT.sh", "fa51a9fd-2fd9-4bb3-8f96-ed63678e9338","fBEgtEydZCiK",text};
      ProcessBuilder p = new ProcessBuilder(command);
      Process p2 = p.start();
      BufferedReader br = new BufferedReader(new InputStreamReader(p2.getInputStream()));
      String line;

      System.out.println("Output of running " + command + " is: ");
      while ((line = br.readLine()) != null) {
          System.out.println(line);
      }
  }

}

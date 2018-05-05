import com.ibm.watson.developer_cloud.visual_recognition.v3.VisualRecognition;
import com.ibm.watson.developer_cloud.visual_recognition.v3.model.ClassifyImagesOptions;
import com.ibm.watson.developer_cloud.visual_recognition.v3.model.VisualClassification;

public class ClasificarImagenes {

	public static void main(String[] args) {

		VisualRecognition service = new VisualRecognition(VisualRecognition.VERSION_DATE_2016_05_20);
		service.setEndPoint("https://raw.githubusercontent.com/mirkorodriguez/ibm-watson/master/apis/VisualRecognition/resources/images/canasta_de_frutas.jpg");
		service.setApiKey("your_api_key_here");

		String imageURL = new String("https://raw.githubusercontent.com/mirkorodriguez/ibm-watson/master/apis/VisualRecognition/resources/images/canasta_de_frutas.jpg");

		ClassifyImagesOptions options = new ClassifyImagesOptions.Builder().url(imageURL).build();

		VisualClassification result = service.classify(options).execute();

		System.out.println("Classification Results:");

		System.out.println(result);

	}
}

import com.ibm.watson.developer_cloud.visual_recognition.v3.VisualRecognition;
import com.ibm.watson.developer_cloud.visual_recognition.v3.model.DetectedFaces;
import com.ibm.watson.developer_cloud.visual_recognition.v3.model.VisualRecognitionOptions;

public class DetectarRostros {

	public static void main(String[] args) {

		VisualRecognition service = new VisualRecognition(VisualRecognition.VERSION_DATE_2016_05_20);
		service.setEndPoint("https://gateway-a.watsonplatform.net/visual-recognition/api");
		service.setApiKey("303f9c7137446134cfef266505052e8016c50cb7");

		String imageURL = new String("https://raw.githubusercontent.com/mirkorodriguez/ibm-watson/master/apis/VisualRecognition/resources/images/obama.jpg");

		VisualRecognitionOptions options = new VisualRecognitionOptions.Builder().url(imageURL).build();

		DetectedFaces result = service.detectFaces(options).execute();

		System.out.println("Detections Results:");

		System.out.println(result);

	}
}

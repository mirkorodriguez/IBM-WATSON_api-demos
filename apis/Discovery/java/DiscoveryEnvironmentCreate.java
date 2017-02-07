import com.ibm.watson.developer_cloud.discovery.v1.Discovery;
import com.ibm.watson.developer_cloud.discovery.v1.model.collection.CreateCollectionRequest;
import com.ibm.watson.developer_cloud.discovery.v1.model.collection.CreateCollectionResponse;
import com.ibm.watson.developer_cloud.discovery.v1.model.collection.DeleteCollectionRequest;
import com.ibm.watson.developer_cloud.discovery.v1.model.collection.GetCollectionRequest;
import com.ibm.watson.developer_cloud.discovery.v1.model.collection.GetCollectionResponse;
import com.ibm.watson.developer_cloud.discovery.v1.model.common.Status;
import com.ibm.watson.developer_cloud.discovery.v1.model.configuration.Configuration;
import com.ibm.watson.developer_cloud.discovery.v1.model.configuration.GetConfigurationsRequest;
import com.ibm.watson.developer_cloud.discovery.v1.model.configuration.GetConfigurationsResponse;
import com.ibm.watson.developer_cloud.discovery.v1.model.document.CreateDocumentRequest;
import com.ibm.watson.developer_cloud.discovery.v1.model.document.CreateDocumentResponse;
import com.ibm.watson.developer_cloud.discovery.v1.model.document.Document;
import com.ibm.watson.developer_cloud.discovery.v1.model.document.GetDocumentRequest;
import com.ibm.watson.developer_cloud.discovery.v1.model.document.GetDocumentResponse;
import com.ibm.watson.developer_cloud.discovery.v1.model.environment.CreateEnvironmentRequest;
import com.ibm.watson.developer_cloud.discovery.v1.model.environment.CreateEnvironmentResponse;
import com.ibm.watson.developer_cloud.discovery.v1.model.environment.Environment;
import com.ibm.watson.developer_cloud.discovery.v1.model.environment.GetEnvironmentRequest;
import com.ibm.watson.developer_cloud.discovery.v1.model.environment.GetEnvironmentResponse;
import com.ibm.watson.developer_cloud.discovery.v1.model.environment.GetEnvironmentsRequest;
import com.ibm.watson.developer_cloud.discovery.v1.model.environment.GetEnvironmentsResponse;
import com.ibm.watson.developer_cloud.discovery.v1.model.query.QueryRequest;
import com.ibm.watson.developer_cloud.discovery.v1.model.query.QueryResponse;
import com.ibm.watson.developer_cloud.http.HttpMediaType;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

public class DiscoveryEnvironmentCreate {

  private static final String DEFAULT_CONFIG_NAME = "Default Configuration";
  private static String API_VERSION="2016-12-15";
  private static String END_POINT="https://gateway.watsonplatform.net/discovery/api";
  private static String USERNAME="fda6d338-8bc0-4c5f-ab97-7fb236c9ead5";
  private static String PASSWORD="jB2155W0JJ4d";

  public static void main(String[] args) {

    Discovery discovery = new Discovery(API_VERSION);
    discovery.setEndPoint(END_POINT);
    discovery.setUsernameAndPassword(USERNAME, PASSWORD);
    String environmentId = null;
    String configurationId = null;
    String collectionId = null;
    String documentId = null;

    //See if an environment already exists
    System.out.println("Check if environment exists");
    GetEnvironmentsRequest getRequest = new GetEnvironmentsRequest.Builder().build();
    GetEnvironmentsResponse getResponse = discovery.getEnvironments(getRequest).execute();
    for (Environment environment : getResponse.getEnvironments()) {
        //look for an existing environment that isn't read only
        if (!environment.isReadOnly()) {
            environmentId = environment.getEnvironmentId();
            System.out.println("Found existing environment ID: " + environmentId);
            break;
        }
    }

    if (environmentId == null) {
        System.out.println("No environment found, creating new one...");
        //no environment found, create a new one (assuming we are a FREE plan)
        String environmentName = "mirko_test_environment";
        CreateEnvironmentRequest.Size size = CreateEnvironmentRequest.Size.FREE;
        CreateEnvironmentRequest createRequest = new CreateEnvironmentRequest.Builder(environmentName, size).build();
        CreateEnvironmentResponse createResponse = discovery.createEnvironment(createRequest).execute();
        environmentId = createResponse.getEnvironmentId();
        System.out.println("Created new environment ID: " + environmentId);

        //wait for environment to be ready
        System.out.println("Waiting for environment to be ready...");
        boolean environmentReady = false;
        while (!environmentReady) {
            GetEnvironmentRequest getEnvironmentRequest = new GetEnvironmentRequest.Builder(environmentId).build();
            GetEnvironmentResponse getEnvironmentResponse = discovery.getEnvironment(getEnvironmentRequest)
                    .execute();
            environmentReady = getEnvironmentResponse.getStatus().equals(Status.ACTIVE);
            try {
                if (!environmentReady) {
                    Thread.sleep(500);
                }
            } catch (InterruptedException e) {
                throw new RuntimeException("Interrupted", e);
            }
        }
        System.out.println("Environment Ready!");
    }

    // //find the default configuration
    // System.out.println("Finding the default configuration");
    // GetConfigurationsRequest getConfigRequest = new GetConfigurationsRequest.Builder(environmentId).build();
    // GetConfigurationsResponse getConfigResponse = discovery.getConfigurations(getConfigRequest).execute();
    // for (Configuration configuration : getConfigResponse.getConfigurations()) {
    //     if (configuration.getName().equals(DEFAULT_CONFIG_NAME)) {
    //         configurationId = configuration.getConfigurationId();
    //         System.out.println("Found default configuration ID: " + configurationId);
    //         break;
    //     }
    // }
    //
    // //create a new collection
    // System.out.println("Creating a new collection...");
    // String collectionName = "my_watson_developer_cloud_collection";
    // CreateCollectionRequest.Builder createCollectionBuilder = new CreateCollectionRequest.Builder(environmentId,
    //         configurationId, collectionName);
    // CreateCollectionResponse createResponse = discovery.createCollection(createCollectionBuilder.build()).execute();
    // collectionId = createResponse.getCollectionId();
    // System.out.println("Created a collection ID: " + collectionId);
    //
    // //wait for the collection to be "available"
    // System.out.println("Waiting for collection to be ready...");
    // boolean collectionReady = false;
    // while (!collectionReady) {
    //     GetCollectionRequest getCollectionRequest = new GetCollectionRequest.Builder(environmentId, collectionId)
    //             .build();
    //     GetCollectionResponse getCollectionResponse = discovery.getCollection(getCollectionRequest).execute();
    //     collectionReady = getCollectionResponse.getStatus().equals(Status.ACTIVE);
    //     try {
    //         if (!collectionReady) {
    //             Thread.sleep(500);
    //         }
    //     } catch (InterruptedException e) {
    //         throw new RuntimeException("Interrupted", e);
    //     }
    // }
    // System.out.println("Collection Ready!");
    //
    // //add a document
    // System.out.println("Creating a new document...");
    // String documentJson = "{\"field\":\"value\"}";
    // InputStream documentStream = new ByteArrayInputStream(documentJson.getBytes());
    //
    // CreateDocumentRequest.Builder createDocumentBuilder = new CreateDocumentRequest.Builder(environmentId,
    //         collectionId);
    // createDocumentBuilder.inputStream(documentStream, HttpMediaType.APPLICATION_JSON);
    // CreateDocumentResponse createDocumentResponse = discovery.createDocument(createDocumentBuilder.build())
    //         .execute();
    // documentId = createDocumentResponse.getDocumentId();
    // System.out.println("Created a document ID: " + documentId);
    //
    // //wait for document to be ready
    // System.out.println("Waiting for document to be ready...");
    // boolean documentReady = false;
    // while (!documentReady) {
    //     GetDocumentRequest getDocumentRequest = new GetDocumentRequest.Builder(environmentId, collectionId,
    //             documentId).build();
    //     GetDocumentResponse getDocumentResponse = discovery.getDocument(getDocumentRequest).execute();
    //     documentReady = !getDocumentResponse.getStatus().equals(Document.Status.PROCESSING);
    //     try {
    //         if (!documentReady) {
    //             Thread.sleep(500);
    //         }
    //     } catch (InterruptedException e) {
    //         throw new RuntimeException("Interrupted");
    //     }
    // }
    // System.out.println("Document Ready!");
    //
    // //query document
    // System.out.println("Querying the collection...");
    // QueryRequest.Builder queryBuilder = new QueryRequest.Builder(environmentId, collectionId);
    // queryBuilder.query("field:value");
    // QueryResponse queryResponse = discovery.query(queryBuilder.build()).execute();
    //
    // //print out the results
    // System.out.println("Query Results:");
    // System.out.println(queryResponse);
    //
    // //cleanup the collection created
    // System.out.println("Deleting the collection...");
    // DeleteCollectionRequest deleteRequest = new DeleteCollectionRequest.Builder(environmentId, collectionId)
    //         .build();
    // discovery.deleteCollection(deleteRequest).execute();
    // System.out.println("Collection deleted!");
    //
    // System.out.println("Discovery example finished");

  }

}

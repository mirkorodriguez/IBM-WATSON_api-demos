Download jar
http://search.maven.org/#artifactdetails%7Ccom.ibm.watson.developer_cloud%7Cjava-sdk%7C3.5.1%7Cjar
http://repo1.maven.org/maven2/com/ibm/watson/developer_cloud/java-sdk/3.5.1/java-sdk-3.5.1-jar-with-dependencies.jar

<dependency>
    <groupId>com.ibm.watson.developer_cloud</groupId>
    <artifactId>java-sdk</artifactId>
    <version>3.5.1</version>
</dependency>
--------------------------------------------------------------------------------
javac -cp ".:lib/java-sdk-3.5.1-jar-with-dependencies.jar" PersonalityInsightsClient.java
java -cp ".:lib/java-sdk-3.5.1-jar-with-dependencies.jar" PersonalityInsightsClient
--------------------------------------------------------------------------------



++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
Download jar
http://twitter4j.org/en/index.html

<dependency>
     <groupId>org.twitter4j</groupId>
     <artifactId>twitter4j-core</artifactId>
     <version>[4.0,)</version>
 </dependency>

javac -cp ".:lib/*" TwitterMain.java
java -cp ".:lib/*" TwitterMain @BillGates

javac -cp ".:lib/*" PersonalityInsightsTwitterClient.java
java -cp ".:lib/*" PersonalityInsightsTwitterClient @BillGates

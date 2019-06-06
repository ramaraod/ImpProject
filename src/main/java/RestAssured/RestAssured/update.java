package RestAssured.RestAssured;

import java.io.File;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.authentication.BasicAuthScheme;
import io.restassured.response.Response;

public class update {
	
	public void createChangeRequest(String filepath)
	{
		//1) URL
		RestAssured.baseURI="https://dev38211.service-now.com/api/now/table/incident";
		//2) Authentication
		BasicAuthScheme basic=new BasicAuthScheme();
		basic.setUserName("admin");
		basic.setPassword("Tuna@123");
		RestAssured.authentication=basic;
		
		
		File file=new File("./data/"+filepath);
		
		//4)Request-Get send
		Response response=RestAssured
				.given()
				.log()
				.all()
				.contentType("application/json")
				.body("{\r\n" + 
						"\"short_description\": \"This is created by derangulla\",\r\n" + 
						"\r\n" + 
						"}")
				.put("/855daf690f78330030f5cd8ce1050e16");
		//5)Response- read or validate
		response.prettyPrint();
}
}

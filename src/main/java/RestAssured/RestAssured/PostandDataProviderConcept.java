package RestAssured.RestAssured;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.authentication.BasicAuthScheme;
import io.restassured.response.Response;

public class PostandDataProviderConcept {
@DataProvider(name="getData" /*parallel=true,indices={1} */)
public String[] getData()
{
	String[] data=new String[2];
	data[0]="data.json";
	data[1]="data2.json";
	return data;

}
	@Test(dataProvider="getData")
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
		Response response=RestAssured.given()
				
				.contentType("application/json")
				.body(file)
				.post();
		//5)Response- read or validate
		response.prettyPrint();
}
}

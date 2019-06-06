package RestAssured.RestAssured;

import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.authentication.BasicAuthScheme;
import io.restassured.response.Response;

public class GetAllIncidents {
	@Test
	public void getChangeRequests()
	{
		//1) URL
		RestAssured.baseURI="https://dev38211.service-now.com/api/now/table/incident";
		//2) Authentication
		BasicAuthScheme basic=new BasicAuthScheme();
		basic.setUserName("admin");
		basic.setPassword("Tuna@123");
		RestAssured.authentication=basic;
		//3) Create request parameter map
		Map<String,String> paramap=new HashMap<String,String>();
		paramap.put("sysparm_fields", "number,sys_id");
		
		paramap.put("priority","1");
		//4)Request-Get send
		Response response=RestAssured.given().params(paramap).get();
		//5)Response- read or validate
		response.prettyPrint();
		
	}
}

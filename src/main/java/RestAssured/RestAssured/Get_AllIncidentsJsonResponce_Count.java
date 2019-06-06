package RestAssured.RestAssured;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.authentication.BasicAuthScheme;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;

public class Get_AllIncidentsJsonResponce_Count {
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
		JsonPath jsonResponse=response.jsonPath();
		System.out.println("****************The Json Format**********");
		List<String> allNumbers=jsonResponse.getList("result.number");
		for(String eachNumber:allNumbers)
		{
			System.out.println(eachNumber);
		}
		System.out.println(allNumbers.size());
		//Print the content in xml format
		
		response=RestAssured.given().params(paramap).accept(ContentType.XML).get();
		//5)Response- read or validate
		response.prettyPrint();
		XmlPath xml=response.xmlPath();
		System.out.println("****************The xml format**********");
		List<String> lis=xml.getList("responce.result.number");
		
		System.out.println(lis.size());
		
	}
}

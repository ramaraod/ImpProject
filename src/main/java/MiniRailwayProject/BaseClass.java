package MiniRailwayProject;

import java.util.List;

import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.authentication.BasicAuthScheme;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class BaseClass {

	
	
	List<String> allNumbers = null;
	@Test
	public void getChangeRequests()
	{
		//1) URL
		RestAssured.baseURI="https://api.railwayapi.com/v2/between/source/MS/dest/TPJ/date/15-04-2019/apikey/j92fxgmm7j/";
		
		Response response=RestAssured.given().get();
		
		response.prettyPrint();
		
		JsonPath jsonResponse=response.jsonPath();
		//System.out.println("****************The Json Format**********");
		 allNumbers=jsonResponse.getList("trains.number");
		
		
		
		
		//System.out.println(allNumbers.size());
		
	
	}
}

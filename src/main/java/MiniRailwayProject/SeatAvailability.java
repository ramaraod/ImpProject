package MiniRailwayProject;

import java.util.List;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class SeatAvailability {
	
	public void getTrainChair()
	{
		//1) URL
		RestAssured.baseURI="https://api.railwayapi.com/v2/check-seat/train/12605/source/MS/dest/TPJ/date/15-04-2019/pref/CC/quota/GN/apikey/j92fxgmm7j/";
		
		Response response=RestAssured.given().get();
		
		response.prettyPrint();
		
		
		 JsonPath jsonResponse=response.jsonPath();
		System.out.println("****************Printing the codes**********");
		List<String> allCodes=jsonResponse.getList("train.classes.code");
		List<String> available=jsonResponse.getList("train.classes.available");
		for(String eachCode:allCodes)
		{
			System.out.println(eachCode);
		}
		System.out.println(allCodes.size());
		 for(int i=0;i<allCodes.size();i++)
		 {
	if(allCodes.get(i).equals("CC")&&available.get(i).equals("Y"))
	{
	System.out.println("The train has available seats");
	}
		 }
		
	
	}
}

package MiniRailwayProject;

import java.util.List;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class TrainChair extends BaseClass {
	@Test(dependsOnMethods="MiniRailwayProject.BaseClass.getChangeRequests")
	public void getTrainChair()
	{
		for (String eachtrain : allNumbers) {
			
		Response response=RestAssured.given().get("https://api.railwayapi.com/v2/name-number/train/"+eachtrain+"/apikey/j92fxgmm7j");
		
		response.prettyPrint();
		JsonPath jsonResponce=response.jsonPath();
		List<String> classes=jsonResponce.getList("train.classes.code");
		List<String> available=jsonResponce.getList("train.classes.available");
		
		 for(int i=0;i<classes.size();i++)
		 {
	if(classes.get(i).equals("CC")&&available.get(i).equals("Y"))
	{
	System.out.println("The train"+eachtrain+" has available seat");
	break;
	}
	
		}
	
	}}

}

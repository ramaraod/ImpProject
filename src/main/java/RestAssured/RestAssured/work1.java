package RestAssured.RestAssured;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;

public class work1 {
	@Test
	public void pract()
	{
		RestAssured.baseURI="http://restapi.demoqa.com/utilities/weather/city";
	Response res=	(Response) given().
			
		when().
		get("/Hyderabad").
		then().assertThat().statusCode(200).and().contentType(ContentType.JSON).and().extract().response();
	String body=res.asString();
	System.out.println(body);
	JsonPath js=new JsonPath(body);
	String name=js.get("City");
	System.out.println("***********************************");
	System.out.println(name);
		/*
		RequestSpecification request=RestAssured.given();
		Response response=request.get("/Hyderabad");
		System.out.println("Response Body is =>  " + response.asString());
	*/
	}

}

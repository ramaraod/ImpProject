package RestAssured.RestAssured;
import static io.restassured.RestAssured.given;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Work2Post {
	@Test
	public void work2Post()
	{
		/* RestAssured.baseURI="http://restapi.demoqa.com/utilities/weather/city";
		RequestSpecification request=RestAssured.given();
		Response response=request.get("/Hyderabad");
		System.out.println("Response Body is =>  " + response.asString());
		int statuscode=response.getStatusCode();
		System.out.println("Status code is "+statuscode);
		*/
		
		RestAssured.baseURI="http://216.10.245.166";
		Response res=(Response) given().
		header("Content-Type","application/json").
		body("{\\r\\n\\t\\\"name\\\":\\\"rest testing\\\",\\r\\n\\t\\\"isbn\\\":\\\"abc123\\\",\\r\\n\\t\\\"aisle\\\":\\\"1234\\\",\\r\\n\\t\\\"author\\\":\\\"ramarao derangulla\\\"\\r\\n}").
		when().
		post("/Library/Addbook.php").
		then().
		assertThat().statusCode(200).and().contentType(ContentType.JSON).and().extract().response();
		/*String body=res.asString();
		System.out.println(body);
		JsonPath js=new JsonPath(body);
		String name=js.get("ID");
		System.out.println("***********************************");
		System.out.println(name); */
	
	}
}

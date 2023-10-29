package httpMethods;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class QueryandPathParameterPassing 
{
	//https://reqres.in/api/users?page=2&id=8
  @Test
  public void passingQueryandPathParam() 
  {
	  given()
	  	.pathParam("path","users")
	  	.queryParam("page",2)
	  	.queryParam("id",8)
	  	
	  .when()
	  	.get("https://reqres.in/api/{path}")
	  	
	   .then()
	   .statusCode(200).log().all();
  }
}

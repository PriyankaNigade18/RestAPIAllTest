package httpMethods;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
public class PostRequestUsingPOJO {
  @Test
  public void postRequest()
  {
	  //Generating  request pay load
	  StudentsPojo data=new StudentsPojo();
	  data.setId(30);
	  data.setName("Jay");
	  data.setLocation("India");
	  data.setPhone("888888");
	  String arr[]= {"python","c#"};
	  data.setCourses(arr);
	  
	  given()
	  	.contentType("application/json")
	  	.body(data)
	  .when()
	  		.post("http://localhost:3000/students")
	  .then()
	  		.statusCode(201)
	  		.body("name", equalTo("Jay")).log().all();
	  	
	  
	  
	  
	  
  }
}

package httpMethods;

import org.json.JSONObject;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;

public class ValidateStudentJson 
{
  @Test(priority=1)
  public void getStudentId()
  {
	  
	  given()
	  	.when()
	  		.get("http://localhost:3000/students")
	  	.then()
	  		.statusCode(200)
	  		.body("id[2]",equalTo(3))
	  		.log().all();
	  		
	  System.out.println("GET request is completed!");
	  
	  
  }
  
  
  //@Test(priority=2)
  public void postUsingMap()
  {
	  //create request payload
	  HashMap<String,Object> data=new HashMap<String,Object>();
	  data.put("id", 11);
	  data.put("name","Ram");
	  data.put("location","India");
	  data.put("phone", "11111");
	  String arr[]= {"appium","postman"};
	  data.put("courses", arr);
	  
	  given()
	  	.contentType("application/json")
	  	.body(data)
	  .when()
	  	.post("http://localhost:3000/students")
	  .then()
	  	.statusCode(201)
	  	.body("name",equalTo("Ram"))
	  	.body("location",equalTo("India"))
	  	.body("courses[0]",equalTo("appium"))
	  	.body("courses[1]",equalTo("postman"))
	  	.log().all();
	  
	    
	  
  }
  
  
  @Test(priority=3)
  public void postUsingJsonLibrary()
  {
	  
	  JSONObject data=new JSONObject();
	  data.put("id", 27);
	  data.put("name","Seema");
	  data.put("location","India");
	  data.put("phone","333333");
		String arr[]= {"c","c++"};
		data.put("courses",arr);
		
		given()
			.contentType("application/json")
			.body(data.toString())
		.when()
			.post("http://localhost:3000/students")
		.then()
			.statusCode(201)
//			.body("name",equalTo("Seema"))
//			.body("location",equalTo("India"))
//			.body("courses[0]",equalTo("c"))
//			.body("courses[1]",equalTo("c++"))
			.log().all();
			
	
	  
	  
	  
  }
  
  
  
  
  
  
  
}

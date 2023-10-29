package httpMethods;

import java.util.HashMap;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;


public class HttpRequestPOSTPUTDELETE 
{
	
	String id;
  @Test(priority=1)
  public void postRequest()
  {
	  //payload
	  HashMap<String,Object> data=new HashMap<String,Object>();
	  data.put("name", "Priyanka");
	  data.put("job", "Trainer");
	  
	  given()
	  	.contentType("application/json")
	  	.body(data)
	  .when()
	  	.post("https://reqres.in/api/users")
	  	
	  .then()
	  	.statusCode(201).log().all();
	  
	 
	  
  }
  
  
  
  @Test(priority=2)
  public void createUser()
  {
	//payload
	  HashMap<String,Object> data=new HashMap<String,Object>();
	  data.put("name", "Priyanka");
	  data.put("job", "Trainer");
	  
	  id=given()
	  	.contentType("application/json")
	  	.body(data)
	  .when()
	  	.post("https://reqres.in/api/users")
	  	.jsonPath().get("id");
	  
	  System.out.println(id);
	  
	  
  }
  
  
  @Test(priority=3,dependsOnMethods = "createUser")
  public void updateSameUser()
  {
	  
	  HashMap<String,Object> data=new HashMap<String,Object>();
	  data.put("name","Sarang");
	  data.put("job","QA");
	  
	  given()
	  	.body(data)
	  .when()
	  	.put("https://reqres.in/api/users/"+id)
	  .then()
	  	.statusCode(200).log().all();
	  System.out.println("Same user is updated!");	
		  
  }
  
  
  @Test(priority=4,dependsOnMethods = "updateSameUser")
  public void sameUserDelete()
  {
	  given()
	  	.when()
	  		.delete("https://reqres.in/api/users/"+id)
	  	.then()
	  		.statusCode(204).log().all();
	  
	  System.out.println("Same user get deleted!");
	  
  }
  
  
  
  
}

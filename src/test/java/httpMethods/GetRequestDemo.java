package httpMethods;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

/*
 * given() -Prerequisite
 * header ,cookies,body(payload)
 * when()->request(get/post/put/delete)
 * then()- validate response
 * response code,status,payload, header 
 * 
 */
public class GetRequestDemo
{
  @Test(priority=1)
  public void getRequest1() 
  {
	  given()
	  
	  .when()
	  	.get("https://reqres.in/api/users/2")
	  .then()
	  	.assertThat()
	  	.statusCode(200).log().all();
	  
	  System.out.println("Request is completed!");
  }
  
  @Test(priority=2)
  public void getRequest2()
  {
	  given()
	  
	  .when()
	  	.get("https://reqres.in/api/users/2")
	  .then()
	  	.body("data.id",equalTo(2))
	  	.statusCode(200).log().all();
	  
	   
  }
  
  
  @Test(priority=3)
  public void getRequestListOfUsers()
  {
	  
	  given()
	  .when()
	  		.get("https://reqres.in/api/users?page=2")
	  .then()
	  		.statusCode(200).log().all();
	  
  }
  
  @Test(priority=4)
  public void getRequestgetId()
  {
	  
	  given()
	  .when()
	  		.get("https://reqres.in/api/users?page=2")
	  .then()
	  		.body("page", equalTo(2))
	  		.statusCode(200).log().all();
	  
  }
  
  
  
  @Test(priority=5)
  public void getRequestFirstName()
  {
	  
	  given()
	  .when()
	  		.get("https://reqres.in/api/users?page=2")
	  .then()
	  	.body("data.first_name[5]",equalTo("Rachel"))
	  		.statusCode(200).log().all();
	  
  }
  
  
  @Test(priority=6)
  public void getRequestNames()
  {
	  //hasItems() -> Check all elements are in a collection
	  given()
	  .when()
	  		.get("https://reqres.in/api/users?page=2")
	  .then()
	  	.body("data.first_name",hasItems("Rachel","Lindsay","Tobias","Byron","leena"))
	  		.statusCode(200).log().all();
	  
  }
  
  @Test(priority=7)
  public void getRequestContains()
  {
	  //contains() -> Check all elements are in a collection and in a strict order
	  given()
	  .when()
	  		.get("https://reqres.in/api/users?page=2")
	  .then()
	  	.body("data.first_name",contains("Michael", "Lindsay", "Tobias", "Byron", "George", "Rachel"))
	  		.statusCode(200).log().all();
	  
  }
  
  
}

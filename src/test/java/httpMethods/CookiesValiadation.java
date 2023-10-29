package httpMethods;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.Map;

public class CookiesValiadation
{
  //@Test(priority=1)
  public void getAllCookies() 
  {
	  given()
	  .when()
	  	.get("https://www.google.com")
	  .then()
	  	.statusCode(200)
	  	.log().all();
	  	
	  
  }
  
  @Test
  public void validateCookies()
  {
	  Response res=given()
			  	.when()
			  	.get("https://www.google.com");
	  	
	  	String value=res.getCookie("AEC");
	  	System.out.println(value);
	  	//test will fail as cookies are dynamic
	  	Assert.assertEquals("AUEFqZfvKiJj6aPY2MQXlDqQxU-ehc4-Oq7h16xGMKkGx_rcJUoztC0DKWY",value);
	  	
	  	
  }
  
  
  @Test
  public void getInfo()
  {
	  Response res=given()
			  	.when()
			  	.get("https://www.google.com");
	  
	 //to get single cookie info
	  
	  String value=res.getCookie("AEC");
	  System.out.println(value);
	  
	  
	  //to get all cookies info
	  Map<String,String> allCookies=res.getCookies();
	  
	  //iterate map
	  for(String key:allCookies.keySet())
	  {
		  String cvalue=res.getCookie(key);
		  System.out.println(key+":"+cvalue);
		  
	  }
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
  }
  
  
  
  
  
}

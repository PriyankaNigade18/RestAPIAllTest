package httpMethods;

import org.testng.annotations.Test;

import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;


public class HeadersValidation {
  @Test(priority=1)
  public void getAllHeaders()
  {
	  given()
	  .when().get("https://www.google.com")
	  .then()	
	  	.statusCode(200)
	  	.header("Content-Type","text/html; charset=ISO-8859-1").log().headers();
	  
  }
  
  @Test(priority=2)
  public void getHeadersInfo()
  {
	  Response res=given()
			  .when().get("https://www.google.com");
	  
	  //To get single header info
	  
	  	String value=res.getHeader("Content-Type");
	  	System.out.println(value);
	  
	  //To get all headers info
	  	
	  	Headers allheaders=res.getHeaders();
	  	/*
	  	 * Headers returns
	  	 * Header name:value
	  	 * Header name:value
	  	 * Header name:value
	  	 */
	  	
	  	
	  	for(Header hd:allheaders)
	  	{
	  		System.out.println(hd.getName()+" : "+hd.getValue());
	  	}
	  	
	  	
	  	
	  	
	  	
	  	
	  	
	  	
	  	
	  	
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
  }
  
  
  
  
  
  
  
}

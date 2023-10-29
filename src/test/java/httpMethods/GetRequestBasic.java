package httpMethods;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class GetRequestBasic {
  @Test
  public void firstGetRequest() 
  {
	  Response res=RestAssured.get("https://www.google.com");
	  int statuscode= res.getStatusCode();
	  System.out.println("Status code is: "+statuscode);
	 
	 //validate
	 Assert.assertEquals(statuscode, 200,"Status code is not matched!");
	 System.out.println("Status code matched!");
	  
  }
  
  
  
  @Test
  public void getRequest2()
  {
	  Response res=RestAssured.get("https://reqres.in/api/users/2");
	  System.out.println("Session id: "+res.getSessionId());
	  System.out.println("Status code : "+res.getStatusCode());
	  System.out.println("Header data: "+res.getHeader("Content-Type"));
	  System.out.println("Body data: "+res.getBody().asString());
	  
  }
  
  
}

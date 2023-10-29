package jsondataSchemaValidation;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class AuthenticationTest {
  @Test(priority=1)
  public void BasicAuthenticationTest() 
  {
	  given()
	  		.auth().basic("postman","password")
	  .when()
	  	.get("https://postman-echo.com/basic-auth")
	  .then()
	  	.statusCode(200)
	  	.body("authenticated",equalTo(true))
	  	.log().all();
	  System.out.println("Basic Authentication is Completed!");
	  
  }
  
  
  @Test(priority=2)
  public void digestAuthenticationTest()
  {
	  
	  given()
	  	.auth().digest("postman","password")
	  .when()
	  	.get("https://postman-echo.com/basic-auth")
	  .then()
	  	.statusCode(200)
	  	.log().all();
	  
	  System.out.println("DigestAuthentication is completed!");
	  
	  
	  
	  
  }
  
  
  @Test(priority=3)
  public void preemtiveAuthenticationTest()
  {
	  given()
	  	.auth().preemptive().basic("postman", "password")
	  .when()
	  	.get("https://postman-echo.com/basic-auth")
	  .then()
	  	.statusCode(200)
	  	.log().all();
	  
	  System.out.println("Preemptive authentication is completed!");

	  
  } 
  
  @Test(priority=4)
  public void bearerTokenTest()
  {
	  
	  given()
	  	.header("Authorization","Bearer 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")
	  
	  .when()
	  	.get("https://api.github.com/user/repos")
	  .then()
	  	.statusCode(200)
	  	.log().all();
	  System.out.println("Bearer Token authentication is completed!");
	  
	  
  }
  
  
  @Test(priority=5)
  public void OAuth2Authentication()
  {
	  given()
	  	.auth().oauth2("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")
	  .when()
	  	.get("https://api.github.com/user/repos")
	  .then()
	  	.statusCode(200)
	  	.log().all();
	  System.out.println("OAuth2.0 Authentication is completed!");
	  
	  
  }
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
}

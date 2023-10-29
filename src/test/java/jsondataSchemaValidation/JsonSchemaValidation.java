package jsondataSchemaValidation;

import org.testng.annotations.Test;

import io.restassured.matcher.RestAssuredMatchers;
import io.restassured.module.jsv.JsonSchemaValidator;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class JsonSchemaValidation

{
	/*
	 * response data---->data validation
	 * response data type-->schema validation
	 * 
	 * getResponse--->generate schema --->test
	 */
  @Test
  public void jsonSchemaTest()
  {
	  given()
	  .when()
	  .get("http://localhost:3000/store")
	  .then()
	  .assertThat().body(JsonSchemaValidator.matchesJsonSchemaInClasspath("storejsonschema.json"));
	  
	  System.out.println("Json schema validation is completed!");
	  
	  
  }
  
  
  @Test
  public void xmlSchemaValidation()
  {
	  given()
	  .when().get("http://restapi.adequateshop.com/api/Traveler?page=1")
	  .then()
	  .assertThat().body(RestAssuredMatchers.matchesXsdInClasspath("traveler.xsd"));
	  
	  System.out.println("Xml schema validation is completed!");
	  	  
	  
  }
  
  
  
  
}

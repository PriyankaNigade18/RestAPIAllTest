package jsondataSchemaValidation;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.json.JSONObject;


public class JsonDataValidation 
{
  @Test(priority=1)
  public void validateJsonTest1()
  {
	  //approach1: direct validation
	  given()
	  	.contentType(ContentType.JSON)
	  	.when()
	  		.get("http://localhost:3000/store")
	  	.then()
	  		.statusCode(200)
	  		.body("book[0].author",equalTo("Dennis Rtiche"))
	  		.log().all();
	  
  }
  
  @Test(priority=2)
  public void validateJsonRequest2()
  {
	  //Approach 2: get all response the perform assertion
	  
	  Response res=given()
			  		.contentType(ContentType.JSON)
			  			.when()
			  			.get("http://localhost:3000/store");
	  
	  //assertion
	  Assert.assertEquals(res.getStatusCode(), 200);
	  System.out.println("Response code is matched!");
	  
	  Assert.assertEquals(res.getHeader("Content-Type"),"application/json; charset=utf-8");
	  System.out.println("Header is matched!");
	  
	  String authorname=res.jsonPath().get("book[0].author").toString();
	  Assert.assertEquals(authorname, "Dennis Rtiche");
	  System.out.println("BookAuthor name matched!");
	  		
	 
  }
  
  
  
  @Test(priority=3)
  public void validateJsonRequest3()
  {
	  //Approach 2: get all response the perform assertion
	  
	  Response res=given()
			  		.contentType(ContentType.JSON)
			  			.when()
			  			.get("http://localhost:3000/store");
	  
	  //assertion
	  Assert.assertEquals(res.getStatusCode(), 200);
	  System.out.println("Response code is matched!");
	
	  
	  String bookTitle=res.jsonPath().get("book[3].title").toString();
	  Assert.assertEquals(bookTitle, "Python for beginners");
	  System.out.println("BookTitle name is matched!");
	  
	 
  }
  
  
  @Test(priority=4)
    public void totalBooks()
  {
	  Response res=given()
		  		.contentType(ContentType.JSON)
		  			.when()
		  			.get("http://localhost:3000/store");
	  
	  
	  //Convert response in json form
	  
	  JSONObject jo=new JSONObject(res.getBody().asString());
	  
	  System.out.println("Total Books are: "+jo.getJSONArray("book").length());
	  
	  //jsonArray--->jsonObject-->get("path"))
  }
  
  
  
  @Test(priority=5)
  public void getBooksName()
  {
	  Response res=given()
		  		.contentType(ContentType.JSON)
		  			.when()
		  			.get("http://localhost:3000/store");
	  
	  //convert response in Json object
	  
	  JSONObject jo=new JSONObject(res.getBody().asString());
	  
	  System.out.println("Books titles are:");

	  //iterate arry to get the title
	  for(int i=0;i<jo.getJSONArray("book").length();i++)
	  {
		  String title=jo.getJSONArray("book").getJSONObject(i).get("title").toString();
		  System.out.println(title);
	  }
	  
	   
  }
  
  
  @Test(priority=6)
  public void getBooksNameWithPrice()
  {
	  Response res=given()
		  		.contentType(ContentType.JSON)
		  			.when()
		  			.get("http://localhost:3000/store");
	  
	  //convert response in Json object
	  
	  JSONObject jo=new JSONObject(res.getBody().asString());
	  
	  System.out.println("Books titles are:");

	  //iterate arry to get the title
	  for(int i=0;i<jo.getJSONArray("book").length();i++)
	  {
		  String title=jo.getJSONArray("book").getJSONObject(i).get("title").toString();
		  String price=jo.getJSONArray("book").getJSONObject(i).get("price").toString();
		  System.out.println("Book title : "+title+" & its Price is: "+price);
	  }
	  
	   
  }
  
  
  @Test(priority=7)
  public void getBooksNameSearch()
  {
	  Response res=given()
		  		.contentType(ContentType.JSON)
		  			.when()
		  			.get("http://localhost:3000/store");
	  
	  //convert response in Json object
	  
	  JSONObject jo=new JSONObject(res.getBody().asString());
	  
	  System.out.println("Books titles are:");

	
	  //iterate arry to get the title
	  for(int i=0;i<jo.getJSONArray("book").length();i++)
	  {
		  String title=jo.getJSONArray("book").getJSONObject(i).get("title").toString();
		  			if(title.contains("The Complete Reference C"))
				  {
		  				System.out.println("Title match!");
		  				break;
				  }
	  }
	  
	  
	   
  }
  
  
  @Test(priority=8)
  public void calculateTotalPriceOfBooks()
  {
	  Response res=given()
		  		.contentType(ContentType.JSON)
		  			.when()
		  			.get("http://localhost:3000/store");
	  
	  //convert response in Json object
	  
	  JSONObject jo=new JSONObject(res.getBody().asString());
	  
	  System.out.println("Books titles are:");

	
	  int totalprice=0;
	  //iterate arry to get the title
	  for(int i=0;i<jo.getJSONArray("book").length();i++)
	  {
		  String price=jo.getJSONArray("book").getJSONObject(i).get("price").toString();
		  			totalprice=totalprice+Integer.parseInt(price);
	  }
	  
	  System.out.println("Total price is: "+totalprice);
  }
  
  
  
}

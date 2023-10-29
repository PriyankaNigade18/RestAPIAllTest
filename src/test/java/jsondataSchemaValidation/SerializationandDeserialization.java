package jsondataSchemaValidation;

import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import httpMethods.StudentsPojo;

public class SerializationandDeserialization 
{
	/*
	 * request(pojo)---->json =serialization
	 * json----->pojo=deserialization
	 */
  //@Test
  public void serializationTest() throws JsonProcessingException
  {
	  StudentsPojo pojo=new StudentsPojo();
	  pojo.setId(40);
	  pojo.setName("Leena");
	  pojo.setLocation("India");
	  pojo.setPhone("33333");
	  String arr[]= {"Selenium","Api"};
	  pojo.setCourses(arr);
	  
	  //poja data---->json
	  ObjectMapper obj=new ObjectMapper();
	  String jsondata=obj.writerWithDefaultPrettyPrinter().writeValueAsString(pojo);
	  
	  System.out.println(jsondata);
	  System.out.println("Serialization process  completed!");
	  
	 
  }
  
  
  @Test
  public void deserializationTest() throws JsonMappingException, JsonProcessingException
  {
	  String jsondata="{\n"
	  		+ "  \"id\" : 40,\n"
	  		+ "  \"name\" : \"Leena\",\n"
	  		+ "  \"location\" : \"India\",\n"
	  		+ "  \"phone\" : \"33333\",\n"
	  		+ "  \"courses\" : [ \"Selenium\", \"Api\" ]\n"
	  		+ "}";
	  
	  
	  //json to pojo
	  ObjectMapper obj=new ObjectMapper();
	 StudentsPojo pojo= obj.readValue(jsondata, StudentsPojo.class);
	  
	  
	 //get the data
	 
	 System.out.println(pojo.getId());
	 System.out.println(pojo.getName());
	 System.out.println(pojo.getLocation());
	 System.out.println(pojo.getPhone());
	 System.out.println(pojo.getCourses()[0]);
	 System.out.println(pojo.getCourses()[1]);
	 
	 
	 
	 
	 
	 
	  
	  
			  
	  
	  
	  
  }
  
  
  
  
  
  
}

package com.restassured.demo;

import  org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;



public class HTTPRequests {
	
	int id;
	@Test (priority = 1)
	void getListOfUser() 
	
	{
		given()
		.header("x-api-key", "reqres-free-v1") 
		
		.when()
		   .get("https://reqres.in/api/users?page=2")
		
		
		.then()
		     .statusCode(200)
		     .body("page",equalTo(2))
		     .log().all();
	}
	
	
	@Test (priority = 2)
	void createUser () {
		
		
		HashMap data = new HashMap();  
		data.put("name", "Anna");
		data.put("job", "Leader");
		
		
		id=given()
		     .contentType("application/json")  // we need to send content type
		     .header("x-api-key", "reqres-free-v1") 
		     .body(data)
		     .log().all() 
		
		.when()
		      .post("https://reqres.in/api/users")
		      .jsonPath().getInt("id"); // capture the id
		
	//	.then()
		      //.statusCode(201) //validate the status code
		     // .log().all();
			  
	}
	
	
	@Test (priority = 3, dependsOnMethods = ("createUser"))
	void updateUser() {
		
		HashMap data = new HashMap();  
		data.put("name", "Anna");
		data.put("job", "Manager");
		
		given()
			     .contentType("application/json")  // we need to send content type
			     .header("x-api-key", "reqres-free-v1") 
			     .body(data)
			     .log().all() 	
			     
			     .when()
			      .put("https://reqres.in/api/users/"+id)
			
		       .then()
		       		.statusCode(200) //validate the status code
		       		.log().all();
	}
	
	@Test (priority = 4)
	void deleteUser() {
	given()
	.header("x-api-key", "reqres-free-v1") 
		.when()
		.delete("https://reqres.in/api/users/"+id)
		
		.then()
   		   .statusCode(200)
   		   .log().all();
   		
	}
	
	}

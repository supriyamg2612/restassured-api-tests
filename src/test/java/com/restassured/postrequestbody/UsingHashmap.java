package com.restassured.postrequestbody;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;

import org.testng.annotations.Test;


public class UsingHashmap {
	
	
	@Test
	void testUsingHashamp() {
		
		HashMap data = new HashMap();
		data.put("name", "scott");
		data.put("location","USA");
		data.put("phone","778899875");
		
		
		//create a course array because we have multiple cources
		String courceArray []=  {"C","C++"};
		
		data.put("cources", courceArray);
		
		given()
		    .contentType("application/json")
		    .body(data)
		
		.when()
		    .post("http://localhost:3000/students")
		
		.then()
		    .statusCode(201)
		    .header("content-type","application/json; charset=utf-8")
		    .body("name", equalTo("scott"))
		    .body("location", equalTo("USA"))
		    .body("phone", equalTo("778899875"))
		  .body("cources[0]", equalTo("C"))
		  .body("cources[1]", equalTo("C++"))
		   .log().all();
	}
	
		   // id=5 will get created automatically
	
	@Test
	void deleteTheCreatedUser() {
		given()
		.when()
				.delete("http://localhost:3000/students/5")
				.then()
		   		   .statusCode(200)
		   		   .log().all();
	}

		
		
	}


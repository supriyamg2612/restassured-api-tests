package com.restassured.postrequestbody;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.lang.annotation.Target;

import org.testng.annotations.Test;

public class UsingPojoClass {
	
	@Test(priority = 1)
	void testUsingPojoClass() {
		
		POJO_POSTRequest data = new POJO_POSTRequest();
		data.setName("Lester");
		data.setLocation("USA");
		data.setPhone("778899875");
		String coursesArray [] = {"C","C++"};
		data.setCourses(coursesArray);
		
		given()
		.contentType("application/json")
		.body(data)
		
		.when()
	    .post("http://localhost:3000/students")

	   	
	    .then()
	    	    .statusCode(201)
	    	    .header("content-type","application/json; charset=utf-8")
	    	    .body("name", equalTo("Lester"))
			    .body("location", equalTo("USA"))
			    .body("phone", equalTo("778899875"))
			    .body("courses[0]", equalTo("C"))
				 .body("courses[1]", equalTo("C++"))
				 .log().all();
	    

	}
	
	
	@Test (priority = 2)
	void deleteTheCreatedUser() {
		given()
		.when()
				.delete("http://localhost:3000/students/5")
				.then()
		   		   .statusCode(200)
		   		   .log().all();
	}


}

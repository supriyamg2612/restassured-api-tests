package com.restassured.postrequestbody;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

import org.json.JSONObject;
import org.json.JSONTokener;
import org.testng.annotations.Test;


public class UsingExternalJsonFile {
	
	@Test(priority = 1)
	void usingExternalJsonFile () throws FileNotFoundException {
		
		//open the file
		File f = new File("/Users/supriya/Documents/eclipse-workspace/rest-api/restassured-demo/body.json"); 
		FileReader fr = new FileReader(f);
		JSONTokener jt = new JSONTokener(fr);
		JSONObject data = new JSONObject(jt);
		
		
		
		
		given()
		.contentType("application/json")
        .body(data.toString())   // ensure proper serialization



.when()
.post("http://localhost:3000/students")

	
	
.then()
	    .statusCode(201)
	    .header("content-type","application/json; charset=utf-8")
	    .body("name", equalTo("Lester"))
	    .body("location", equalTo("USA"))
	    .body("phone", equalTo("1122334455"))
	    .body("courses[0]", equalTo("Java"))
		 .body("courses[1]", equalTo("Selenium"))
		 .log().all();
}

	//@Test (priority = 2)
	void deleteTheCreatedUser() {
		given()
		.when()
				.delete("http://localhost:3000/students/5")
				.then()
		   		   .statusCode(200)
		   		   .log().all();
	}

		
		
		
		
		
		
		
		
		
		
		
	}



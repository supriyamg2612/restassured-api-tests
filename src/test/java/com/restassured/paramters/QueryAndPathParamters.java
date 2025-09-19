package com.restassured.paramters;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.Test;

public class QueryAndPathParamters {
	
	//  https://reqres.in/api/users?page=2
	
	@Test
	void testQueryAndPathParamters() {
		
		given()
		.pathParam("mypath", "users") //path parameter
		.queryParam("page", 2) // Query parameter
		
		
		
		.when()
		.get("https://reqres.in/api/{mypath}")
		
		
		.then()
		.statusCode(200)
		.log().all();
			
	}
	
	

}

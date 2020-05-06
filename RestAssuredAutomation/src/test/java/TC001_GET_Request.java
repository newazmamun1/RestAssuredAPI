

import org.junit.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC001_GET_Request {
	
	@Test
	void getweatherDetails() {
		//specify base URI
		RestAssured.baseURI = "http://restapi.demoqa.com/utilities/weather/city";
		
		//Request object
		RequestSpecification httprequest = RestAssured.given();
		
		//Respond Object 
		Response response = httprequest.request(Method.GET,"/Dhaka");
		
		//print response in console
		String responseBody =response.getBody().asString();
		System.out.println("Response Body is:" + responseBody);
		
		//Validation Status Code
		int statusCode = response.getStatusCode();
		System.out.println("Status Code is:"+ statusCode);
		Assert.assertEquals(200, statusCode);
		
		//Verification Status line
		String statusLine = response.getStatusLine();
		System.out.println("Status Line is "+ statusLine);
		Assert.assertEquals("HTTP/1.1 200 OK", statusLine);
	}

}

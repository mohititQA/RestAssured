package TestCases;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import base.TestBase;
import io.restassured.RestAssured;
import io.restassured.http.Method;

public class tc2GetSingleEmployeeDetails extends TestBase {
	
	@BeforeClass
	public void setupGetRequest()
	{
		logger.info("&&&&&&&&& Started the Second Test Case &&&&&&&&&&&&&");
		RestAssured.baseURI = "http://dummy.restapiexample.com/api/v1";
		httpRequest = RestAssured.given();
		response = httpRequest.request(Method.GET,"/employees");
	}
   
	
	@Test
	public void getResponseCode()
	{
		logger.info("getting the response code");
		System.out.println("The response code is : "+ response.getStatusCode());
	}
	
	@Test
	public void getStatusLine()
	{
		logger.info("getting the Status line");
		System.out.println("The response code is : "+ response.getStatusLine());
	}
	@AfterClass
	public void teardownMethods()
	{
		logger.info("End of the second test case ");
	}

}

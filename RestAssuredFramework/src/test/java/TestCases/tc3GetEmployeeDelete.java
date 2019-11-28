package TestCases;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import base.TestBase;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;

public class tc3GetEmployeeDelete extends TestBase{
	
	@BeforeClass
	public void DeleteEmployee() throws InterruptedException
	{
		logger.info("&&&&&&&&& Started the Third Test Case &&&&&&&&&&&&&");
		RestAssured.baseURI = "http://dummy.restapiexample.com/api/v1";
		httpRequest = RestAssured.given();
		response = httpRequest.request(Method.GET,"/employees");
		JsonPath jsonpathEvaltor = response.jsonPath();
		String empID = jsonpathEvaltor.get("[0].id");
		response = httpRequest.request(Method.DELETE,"/delete/"+empID);
		Thread.sleep(3000);
		
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
		logger.info("End of the test case of deleteing the Employee");
	}

}

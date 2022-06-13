package io.cucumber.tests;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;

public class ApiTest5 extends BaseTest{
    @Given("^I want to enter the invalid user$")
    public void initialiseUri(){
        RestAssured.baseURI = baseURL;
        System.out.println("Test is Starting.");
    }
    @When("^I submit my invalid \"(.*)\" request$")
    public void submitRequest(String user) {
        RestAssured.baseURI = baseURL;
        RequestSpecification request = RestAssured.given();
        response = request.body("{ \"name\":\" "+user+"\"}")
                .post(baseURL+basePath+"login");
    }

    @Then("^I should get error with 400 response$")
    public void getResponse(){
        int statusCode = response.getStatusCode();
        Assert.assertEquals(statusCode,400,"Issue with end point as invalid user is allowed");
        System.out.println("Test Ends here.");
    }
}

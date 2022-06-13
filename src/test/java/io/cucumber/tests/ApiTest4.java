package io.cucumber.tests;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;

public class ApiTest4 extends BaseTest{

    @Given("^I want to enter the new user$")
    public void initialiseUri(){
        RestAssured.baseURI = baseURL;
        System.out.println("Test is Starting");
    }

    @When("^I submit my new user request$")
    public void submitRequest(){
        RestAssured.baseURI = baseURL;
        RequestSpecification request = RestAssured.given();
        response = request.body("{ \"name\":\" morpheus \", \"job\":\" leader \"}")
                .post(baseURL+basePath+"users");
    }

    @Then("^I should get user created 201 response$")
    public void getResponse(){
        int statusCode = response.getStatusCode();
        Assert.assertEquals(statusCode,201,"Failed to create new user");
        System.out.println("Test Ends here.");
    }
}

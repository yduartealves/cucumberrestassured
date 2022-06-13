package io.cucumber.tests;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.testng.Assert;

public class ApiTest3 extends BaseTest{

    @Given("^I want to enter the request for user$")
    public void initialiseUri(){
        RestAssured.baseURI = API_ENDPOINT;
        System.out.println("Test is Starting.");
    }

    @When("^I submit my request with invalid key")
    public void submitRequest(){
        RequestSpecification request = RestAssured.given();
        response = request.get(RestAssured.baseURI+INVALID_APIKEY);
    }

    @Then("^I should get Unsuccessful response")
    public void getResponse(){
        int statusCode = response.getStatusCode();
        Assert.assertEquals(statusCode,403,"The user is not valid as wrong end point");
        System.out.println("Test Ends here.");
    }

    @Then("^I should get the requestId")
    public void verifyResponse() throws ParseException {
        ResponseBody body = response.body();
        System.out.println("Response Body is:"+body.asString());
        Assert.assertTrue(body.asString().contains("error"),"Promotions are not available");

        JSONParser parse = new JSONParser();
        JSONObject obj = (JSONObject) parse.parse(body.asString());
        JSONObject object = (JSONObject) obj.get("error");
        Assert.assertFalse(object.get("requestId").toString().isEmpty(),"The RequestId is empty");
        Assert.assertEquals(object.get("code").toString(),"8001");
        Assert.assertEquals(object.get("message").toString(),"invalid api key");
    }
}

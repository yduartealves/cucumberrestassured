package io.cucumber.tests;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.testng.Assert;

public class ApiTest2 extends BaseTest{

    @Given("I want to initialise the end point")
    public void initialiseUri(){
        RestAssured.baseURI = API_ENDPOINT;
        System.out.println("Test is Starting.");
    }
    @When("^I want to hit the end point$")
    public void submitRequest(){
        RequestSpecification request = RestAssured.given();
        response = request.get(RestAssured.baseURI+VALID_APIKEY);
    }

    @Then("^I should get the response$")
    public void getResponse(){
        int statusCode = response.getStatusCode();
        Assert.assertEquals(statusCode,200,"The Login is not successful");
    }

    @Then("^I should validate the Json properties$")
    public void checkProperties() throws ParseException {
        ResponseBody body = response.body();
        System.out.println("Response Body is:"+body.asString());
        Assert.assertTrue(body.asString().contains("promotions"),"Promotions are not available");

        JSONParser parse = new JSONParser();
        JSONObject obj = (JSONObject) parse.parse(body.asString());
        JSONArray jsonArray = (JSONArray) obj.get("promotions");

        for (Object o : jsonArray) {
            JSONObject data = (JSONObject) o;
            String promo = (String) data.get("promotionId");
            Assert.assertFalse(promo.isEmpty(), "PromoId has Value");
            Assert.assertFalse(data.get("orderId").toString().isEmpty(), "OrderId has value");
            Assert.assertFalse(data.get("promoArea").toString().isEmpty(), "promoArea has value");
            Assert.assertFalse(data.get("promoType").toString().isEmpty(), "promoType has value");
            boolean showPrice = (boolean) data.get("showPrice");
            Assert.assertFalse(showPrice, "showPrice has True value");
            boolean showText = (boolean) data.get("showText");
            Assert.assertFalse(showText, "showText has True value");
            Assert.assertFalse(data.get("localizedTexts").toString().isEmpty(), "localizedTexts has value");

            JSONArray program = (JSONArray) data.get("properties");
            for(Object ObjArr: program.toArray()){
                JSONObject ArrayIn = (JSONObject) ObjArr;
                    String programType = (String) ArrayIn.get("programType");
                    System.out.println("PROGRAM TYPE:::"+programType);
                    Assert.assertTrue("series".equalsIgnoreCase(programType)||"movie".equalsIgnoreCase(programType),"program type is wrong");
                }
            }

        }
    }

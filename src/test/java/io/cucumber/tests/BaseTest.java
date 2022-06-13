package io.cucumber.tests;

import io.restassured.response.Response;

public class BaseTest {

    //For Reqres.in site learning
    public static Response response;
    public static final String basePath = "/api/";
    public static final String baseURL = "https://reqres.in";
    public static final String Token = "QpwL5tke4Pnpja7X4";
    public static final String USERNAME = "eve.holt@reqres.in";
    public static final String PASSWORD = "cityslicka";

    //For the ApiEnd point Test 
    public static final String API_ENDPOINT = "http://api.intigral-ott.net/popcorn-api-rs-7.9.10/v1/promotions?apikey=";
    public static final String VALID_APIKEY = "GDMSTGExy0sVDlZMzNDdUyZ";
    public static final String INVALID_APIKEY = "apikey";
}

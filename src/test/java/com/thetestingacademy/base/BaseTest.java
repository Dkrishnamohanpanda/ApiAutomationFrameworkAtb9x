package com.thetestingacademy.base;

import com.thetestingacademy.asserts.AssertActions;
import com.thetestingacademy.endpoints.ApiConstants;
import com.thetestingacademy.modules.PayloadManager;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.BeforeTest;

public class BaseTest {
    //common to all
    //Base url ,content type - json

public RequestSpecification requestSpecification;
public AssertActions assertActions;
public PayloadManager payloadManager;
public JsonPath jsonPath;
public Response response;
public ValidatableResponse validatableResponse;

@BeforeTest
    public void setUp(){
    //Base url ,content Type Json

   payloadManager = new PayloadManager();
    assertActions = new AssertActions();

    requestSpecification = RestAssured
            .given()
            .baseUri(ApiConstants.BASE_URL)
            .contentType(ContentType.JSON)
            .log().all();


    requestSpecification = new RequestSpecBuilder()
            .setBaseUri(ApiConstants.BASE_URL)
            .addHeader("Content-Type","application/json")
            .build().log().all();
}
  public String getToken(){
    requestSpecification = RestAssured
            .given()
            .baseUri(ApiConstants.BASE_URL)
            .basePath(ApiConstants.AUTH_URL);
//    setting payload
      String payload = payloadManager.setAuthPayload();
//      get the token
      response = requestSpecification.contentType(ContentType.JSON).body(payload).when().post();

//     String]] extract the token
      String token = payloadManager.getTokenFromJSON(response.asString());
      return token;


//

}
}

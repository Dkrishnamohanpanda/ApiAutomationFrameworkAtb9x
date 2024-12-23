package com.thetestingacademy.tests.crud;

import com.thetestingacademy.base.BaseTest;
import com.thetestingacademy.endpoints.ApiConstants;
import com.thetestingacademy.modules.PayloadManager;
import com.thetestingacademy.pojos.BookingResponse;
import io.qameta.allure.*;
import io.restassured.RestAssured;
import io.restassured.response.ValidatableResponse;
import org.testng.annotations.Test;
import  io.qameta.allure.TmsLink;


public class testCreateBooking extends BaseTest {

    @Owner("Krishna")
    @TmsLink("")
    @Link()
    @Issue("")
    @Description("verify the post request work fine")
    @Test(groups = "qa")
    public void testVerifyCreateBookingPOST01(){
        requestSpecification.basePath(ApiConstants.CREATE_UPDATE_BOOKING_URL);

        response = RestAssured.given(requestSpecification)
                .when().body(PayloadManager.createPayloadBookingASString()).post();

        ValidatableResponse ValidatableResponse = response.then().log().all();
        ValidatableResponse.statusCode(200);

        BookingResponse bookingResponse = payloadManager.bookingResponseJava(response.asString());
        assertActions.verifyStringKey(bookingResponse.getBooking().getFirstname(), "Krishna");

    }
}

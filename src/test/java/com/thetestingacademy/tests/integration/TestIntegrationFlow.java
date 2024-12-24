package com.thetestingacademy.tests.integration;

import com.thetestingacademy.base.BaseTest;
import com.thetestingacademy.endpoints.ApiConstants;
import com.thetestingacademy.modules.PayloadManager;
import com.thetestingacademy.pojos.Booking;
import com.thetestingacademy.pojos.BookingResponse;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import io.restassured.RestAssured;
import io.restassured.response.ValidatableResponse;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class TestIntegrationFlow extends BaseTest {
//    Test Integration Scenario 1
// 1. Create a Booking -> bookingID
// 2. Create Token -> token
// 3. Verify that the Create Booking is working - GET Request to bookingID
// 4. Update the booking ( bookingID, Token) - Need to get the token, bookingID from above request
// 5. Delete the Booking - Need to get the token, bookingID from above request

    @Test(groups = {"integration","P0" },priority =1)
    @Owner("Krishna")
    @Description("Tc#INT1 - step 1 - verify that booking can be created")
    public void testCreateBookingById(ITestContext iTestContext){
        System.out.println(iTestContext.getAttribute("bookingid"));
        requestSpecification.basePath(ApiConstants.CREATE_UPDATE_BOOKING_URL);

        response = RestAssured.given(requestSpecification)
                .when().body(PayloadManager.createPayloadBookingASString()).post();

        ValidatableResponse ValidatableResponse = response.then().log().all();
        ValidatableResponse.statusCode(200);

        String bookingResponse = payloadManager.bookingResponseJava(response.asString());
        assertActions.verifyStringKey(bookingResponse.getBooking().getFirstname(), "Krishna");
        System.out.println(bookingResponse.getBookingid());


    }
    @Test(groups = {"integration","P0" },priority =2)
    @Owner("Krishna")
    @Description("Tc#INT1 - step 1 - verify that booking by id")
    public void testVerifyBookingById(ITestContext iTestContext){
        System.out.println(iTestContext.getAttribute("bookingid"));
        Assert.assertTrue(true);

        Integer bookingid = (Integer) (iTestContext.getAttribute("bookingid"));
//        GET request - to verify that first name after creation is james
        String basePathGET = ApiConstants.CREATE_UPDATE_BOOKING_URL+"/"+ bookingid ;
        System.out.println( basePathGET);


        requestSpecification.basePath(ApiConstants.CREATE_UPDATE_BOOKING_URL);

        response = RestAssured.given(requestSpecification)
                .when().body(PayloadManager.createPayloadBookingASString()).post();

        ValidatableResponse ValidatableResponse = response.then().log().all();
        ValidatableResponse.statusCode(200);






    }
    @Test(groups = {"integration","P0" },priority =3)
    @Owner("Krishna")
    @Description("Tc#INT1 - step 1 - verify update booking by id")
    public void testUpdateBookingById(ITestContext iTestContext){
        System.out.println(iTestContext.getAttribute("bookingid"));
        Assert.assertTrue(true);

        Integer bookingid = (Integer) (iTestContext.getAttribute("bookingid"));
        String token =getToken();
        iTestContext.setAttribute("token",token);
        String basePathPUTPATCH = ApiConstants.CREATE_UPDATE_BOOKING_URL;
        System.out.println(basePathPUTPATCH);

        requestSpecification.basePath(basePathPUTPATCH);
        response = RestAssured.given(requestSpecification).cookie("token",token)
                .when().body(payloadManager.fullUpdatePayloadAsString()).put();
        validatableResponse = response.then().log().all();
        validatableResponse.statusCode(200);
        Booking booking =payloadManager.getResponseFromJSON(response.asString());
        assertThat(booking.getFirstname()).isNotNull().isNotBlank();
        assertThat(booking.getFirstname()).isEqualTo("Krishna");
        assertThat(booking.getLastname()).isEqualTo("panda");



    }
    @Test(groups = {"integration","P0" },priority =4)
    @Owner("Krishna")
    @Description("Tc#INT1 - step 1 - verify Delete booking by id")
    public void testDeleteBookingById(ITestContext iTestContext){
        System.out.println(iTestContext.getAttribute("bookingid"));
        System.out.println(iTestContext.getAttribute("token"));
        Assert.assertTrue(true);

        String token = (String) iTestContext.getAttribute("token");
        Integer bookingid = (Integer)iTestContext.getAttribute("bookingid");
        String basePathDELETE =ApiConstants.CREATE_UPDATE_BOOKING_URL + "/"+bookingid;

        requestSpecification.basePath( basePathDELETE).cookie("token",token)
                .when().body(payloadManager.fullUpdatePayloadAsString()).put();
        validatableResponse =RestAssured.given().spec(requestSpecification)
                        .when().delete().then().log().all();
        validatableResponse.statusCode(201);


    }
    }


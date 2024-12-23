package com.thetestingacademy.tests.sample;

import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestIntegrationSample {

    //create Booking //create Auth Token
    //verify Booking - Get Booking
    //update Booking
    //Delete Booking
    @Test(groups = "qa",priority = 1)
    @Owner("Krishna")
    @Description("TC#Int1 - step 1. verify that booking can be created")
    public void testCreateBooking(){
        Assert.assertTrue(true);
    }

    @Test(groups = "qa",priority = 2)
    @Owner("Krishna")
    @Description("TC#Int1 - step 1. verify that Booking by ID")
    public void testVerifyBookingId(){
        Assert.assertTrue(true);
    }

    @Test(groups = "qa",priority = 3)
    @Owner("Krishna")
    @Description("TC#Int1 - step 3. verify that Booking by ID")
    public void testUpdateBookingId(){
        Assert.assertTrue(true);
    }

    @Test(groups = "qa",priority = 4)
    @Owner("Krishna")
    @Description("TC#Int1 - step 4. Delete the Booking by ID")
    public void testDeleteBookingId(){
        Assert.assertTrue(true);

    }

}

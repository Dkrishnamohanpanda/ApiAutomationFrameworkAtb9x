package com.thetestingacademy.modules;

import com.google.gson.Gson;
import com.thetestingacademy.pojos.Booking;
import com.thetestingacademy.pojos.BookingResponse;
import com.thetestingacademy.pojos.Bookingdates;

public class PayloadManager {
    //convert java objects into json String
    //convert json String objects into java
    static Gson gson;
    public static String createPayloadBookingASString(){
        Booking booking = new Booking();
        booking.setFirstname("Krishna");
        booking.setLastname("panda");
        booking.setTotalprice(112);
        booking.setDeapositpaid(true);

        Bookingdates bookingdates = new Bookingdates();
        bookingdates.setCheckin("2018-01-01");
        bookingdates.setCheckout("2018-01-01");
        bookingdates.setAdditionalneeds("Breakfast");

        System.out.println(booking);
        gson = new Gson();
        String jsonStringPayload =gson.toJson(booking);
        System.out.println(jsonStringPayload);
        return jsonStringPayload;

    }

    //convert json String objects into java

    public BookingResponse bookingResponseJava(String responseString){
        gson = new Gson();
        BookingResponse bookingResponse =gson.fromJson(responseString, BookingResponse.class);
        return  bookingResponse;

//        public void getTToken(){
//
//        }
    }
}

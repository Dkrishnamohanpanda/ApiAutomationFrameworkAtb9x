package com.thetestingacademy.modules;

import com.google.gson.Gson;
import com.thetestingacademy.pojos.Booking;
import com.thetestingacademy.pojos.BookingResponse;
import com.thetestingacademy.pojos.Bookingdates;

public class PayloadManager  {
    //convert java objects into json String
    //convert json String objects into java
    static Gson gson;
    public static String createPayloadBookingASString(){
        Booking booking = new Booking();
        booking.setFirstname("James");
        booking.setLastname("Brown");
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

    public String bookingResponseJava(String responseString){
        gson = new Gson();
        BookingResponse bookingResponse =gson.fromJson(responseString, BookingResponse.class);
        return bookingResponse.toString();
//-------Token-------
//        java to json
  public String setAuthPayload(){
            Auth auth = new Auth();
            auth.setUsername = "Admin";
            auth.setPassword("password123");
            gson = new Gson();
            String jsonPayloadString = gson.toJson(auth);
            System.out.println("payload set to the " + jsonPayloadString);
            return jsonPayloadString;
        }
    }
////json to java
  public  String getTokenFromJSON(String tokenResponse){
        gson = new Gson();
        TokenResponse tokenResponse1 =gson.fromJson(tokenResponse,TokenResponse.class);
        return tokenResponse1.getToken();
  }

   public String fullUpdatePayloadAsString(){
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


    public Booking getResponseFromJSON(String getResponse) {
        gson = new Gson();
        Booking booking = gson.fromJson(getResponse, Booking.class);
        return  booking;
    }
}

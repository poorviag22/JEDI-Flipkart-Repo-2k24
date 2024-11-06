package com.flipfit.business;

import com.flipfit.bean.GymCustomer;

public class GymCustomerBusinessImpl implements GymCustomerBusiness
{
    public void createProfile(GymCustomer customer){
      System.out.println("Profile Created!!");
    }
    public void viewBookings(int customerId){
     System.out.println("My Bookings");
    }
    public boolean waitlistStatus(int customerId){
        return true;
    }
    public boolean modifyBooking(int customerId){
     return true;
    }

    public boolean cancelBooking(int customerId){
        System.out.println("Booking Cancelled!!");
        return true;
    }
    public void makepayment(int customerId){
        System.out.println("Payment Successful");
    }
}

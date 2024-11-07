package com.flipfit.business;

import com.flipfit.bean.GymCustomer;
import com.flipfit.dao.GymAdminDAO;
import com.flipfit.dao.GymAdminDAOImpl;
import com.flipfit.dao.GymCustomerDAO;
import com.flipfit.dao.GymCustomerDAOImpl;

import java.util.Scanner;

public class GymCustomerBusinessImpl implements GymCustomerBusiness
{
    Scanner scanner = new Scanner(System.in);
    GymCustomerDAO custDAO = new GymCustomerDAOImpl();
    public void createProfile(GymCustomer customer){

      System.out.println("Profile Created!!");
      custDAO.createProfile(customer);
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

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

    @Override
    public boolean editProfile(int customerId) {
        java.util.Scanner in = new java.util.Scanner(System.in);
        System.out.println("Editing profile ...");
        System.out.println("Enter your new name");
        String name = in.nextLine();
        System.out.println("Enter your new email");
        String email = in.nextLine();
        System.out.println("Enter your new Address");
        String address = in.nextLine();
        System.out.println("Enter your new password");
        String password = in.nextLine();
        System.out.println("Enter your new Contact Number");
        String contactNumber = in.nextLine();
        GymCustomer customer = new GymCustomer(name,address,email,contactNumber,password);
        customer.setCustomerId(customerId);
        custDAO.editProfile(customer);

        System.out.println("Registered Successfully!!");
        return false;
    }

    @Override
    public int login(String email, String password, String role) {
        return custDAO.login(email, password, role);
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

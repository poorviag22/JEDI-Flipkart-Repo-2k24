package com.flipfit.dao;

import com.flipfit.bean.GymCustomer;
import com.flipfit.bean.GymPayment;

import java.util.Date;

public interface GymCustomerDAO {
    public void createProfile(GymCustomer customer);
    public boolean editProfile(GymCustomer customer);
    public int login(String email, String password, String role);
    public void viewBookings(int customerId);
    public boolean waitlistStatus(int customerId);
    //public int modifyBooking(int bookingID , int customerID , int centerID , int slotID) ;
    public int createBooking(int customerID, int slotID, int centerId, Date date);
    public boolean cancelBooking(int customerId, int bookingID);
    public int makepayment(GymPayment paymentData);
    public void viewSlots(int centerId, Date date);
    public void updatepwd(String email, String password, String role);
}

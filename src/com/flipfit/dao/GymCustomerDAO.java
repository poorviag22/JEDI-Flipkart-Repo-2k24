package com.flipfit.dao;

import com.flipfit.bean.GymCustomer;
import com.flipfit.bean.GymPayment;

public interface GymCustomerDAO {
    public void createProfile(GymCustomer customer);
    public void viewBookings(int customerId);
    public boolean waitlistStatus(int customerId);
    public int modifyBooking(int bookingID , int customerID , int centerID , int slotID) ;
    public int createBooking(int customerID , int centerID , int slotID);
    public boolean cancelBooking(int customerId);
    public boolean makepayment(GymPayment paymentData);
}

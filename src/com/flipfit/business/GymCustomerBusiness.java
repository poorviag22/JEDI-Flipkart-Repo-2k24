package com.flipfit.business;

import com.flipfit.bean.GymCustomer;

import java.util.Date;

public interface GymCustomerBusiness {
    // Interface are using for declaration of the services

    public void createProfile(GymCustomer customer);
    public boolean editProfile(int customerId);
    public int login(String email, String password, String role);
    public int createBooking(int customerId, int slotid, int centerId, Date date);
    public void viewSlots(int centerId, Date date);
    public void viewBookings(int customerId);
    public boolean waitlistStatus(int customerId);
    public boolean modifyBooking(int customerId);
    public boolean cancelBooking(int customerId);
    public int makepayment(int bookingId, String mode);
    public void updatepwd(String email, String password, String role);
}

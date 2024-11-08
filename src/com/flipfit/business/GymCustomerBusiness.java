package com.flipfit.business;

import com.flipfit.bean.GymCustomer;

public interface GymCustomerBusiness {
    // Interface are using for declaration of the services

    public void createProfile(GymCustomer customer);
    public boolean editProfile(int customerId);
    public int login(String email, String password, String role);
    public void viewBookings(int customerId);
    public boolean waitlistStatus(int customerId);
    public boolean modifyBooking(int customerId);
    public boolean cancelBooking(int customerId);
    public void makepayment(int customerId);
}

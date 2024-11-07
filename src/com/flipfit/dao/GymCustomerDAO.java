package com.flipfit.dao;

import com.flipfit.bean.GymCustomer;

public interface GymCustomerDAO {
    public void createProfile(GymCustomer customer);
    public void viewBookings(int customerId);
    public boolean waitlistStatus(int customerId);
    public boolean modifyBooking(int customerId);
    public boolean cancelBooking(int customerId);
    public void makepayment(int customerId);
}

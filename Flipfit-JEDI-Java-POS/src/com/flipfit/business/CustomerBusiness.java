package com.flipfit.business;

import com.flipfit.bean.Customer;

public interface CustomerBusiness {
    // Interface are using for declaration of the services

    public void createProfile(Customer customer);
    public boolean viewBookings(int customerId);
    public boolean waitlistStatus(int customerId);
    public void modifyBooking();
}

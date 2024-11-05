package com.flipfit.business;

import com.flipfit.bean.GymCustomer;

public interface GymCustomerBusiness {
    // Interface are using for declaration of the services

    public void createProfile(GymCustomer customer);
    public boolean viewBookings(int customerId);
    public boolean waitlistStatus(int customerId);
    public void modifyBooking();
}

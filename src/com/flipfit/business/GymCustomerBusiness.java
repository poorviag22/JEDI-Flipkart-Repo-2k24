package com.flipfit.business;

import com.flipfit.bean.GymBooking;
import com.flipfit.bean.GymCustomer;
import com.flipfit.bean.GymSlots;

import java.util.Date;
import java.util.List;

public interface GymCustomerBusiness {
    // Interface are using for declaration of the services

    public boolean createProfile(GymCustomer customer);

    public boolean editProfile(GymCustomer customer);

    public int createBooking(int customerId, int slotid, int centerId, Date date);

    public List<GymBooking> viewBookings(int customerId);

    public boolean cancelBooking(int customerId, int bookingId);

    public int makepayment(int bookingId, String mode);

    public boolean updatepwd(String email, String password, String role);
}

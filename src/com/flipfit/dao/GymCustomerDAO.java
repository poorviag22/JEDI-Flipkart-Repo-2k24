package com.flipfit.dao;

import com.flipfit.bean.GymBooking;
import com.flipfit.bean.GymCustomer;
import com.flipfit.bean.GymPayment;
import com.flipfit.bean.GymSlots;

import java.util.*;

public interface GymCustomerDAO {
    public boolean createProfile(GymCustomer customer);

    public boolean editProfile(GymCustomer customer);

    public int login(String email, String password, String role);

    public List<GymBooking> viewBookings(int customerId);

    public int createBooking(int customerID, int slotID, int centerId, Date date);

    public boolean cancelBooking(int customerId, int bookingID);

    public int makepayment(GymPayment paymentData);

    public boolean updatepwd(String email, String password, String role);
}

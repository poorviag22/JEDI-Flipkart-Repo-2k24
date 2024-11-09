package com.flipfit.dao;

import com.flipfit.bean.GymBooking;
import com.flipfit.bean.GymCustomer;
import com.flipfit.bean.GymPayment;
import com.flipfit.bean.GymSlots;
import com.flipfit.exceptions.DataEntryFailedException;
import com.flipfit.exceptions.InvalidCredentialsException;
import com.flipfit.exceptions.ResourceNotFoundException;
import com.flipfit.exceptions.UnauthorisedAccessException;

import java.util.*;

public interface GymCustomerDAO {
    public boolean createProfile(GymCustomer customer) throws InvalidCredentialsException, DataEntryFailedException;

    public boolean editProfile(GymCustomer customer) throws DataEntryFailedException;

    public List<GymBooking> viewBookings(int customerId) throws ResourceNotFoundException;

    public int createBooking(int customerID, int slotID, int centerId, Date date) throws ResourceNotFoundException;

    public boolean cancelBooking(int customerId, int bookingID) throws InvalidCredentialsException, UnauthorisedAccessException;

    public int makepayment(GymPayment paymentData) throws DataEntryFailedException;

    public boolean updatepwd(String email, String password, String role) throws InvalidCredentialsException;
}

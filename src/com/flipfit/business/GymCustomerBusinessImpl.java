package com.flipfit.business;

import com.flipfit.bean.GymBooking;
import com.flipfit.bean.GymCustomer;
import com.flipfit.bean.GymPayment;
import com.flipfit.bean.GymSlots;
import com.flipfit.dao.GymAdminDAO;
import com.flipfit.dao.GymAdminDAOImpl;
import com.flipfit.dao.GymCustomerDAO;
import com.flipfit.dao.GymCustomerDAOImpl;
import com.flipfit.exceptions.DataEntryFailedException;
import com.flipfit.exceptions.InvalidCredentialsException;
import com.flipfit.exceptions.ResourceNotFoundException;
import com.flipfit.exceptions.UnauthorisedAccessException;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class GymCustomerBusinessImpl implements GymCustomerBusiness {
    Scanner scanner = new Scanner(System.in);
    GymCustomerDAO custDAO = new GymCustomerDAOImpl();

    @Override
    public boolean createProfile(GymCustomer customer) {
        try{
            return custDAO.createProfile(customer);
        } catch (InvalidCredentialsException e){
            System.out.println(e);
        } catch (DataEntryFailedException ex){
            System.out.println(ex);
        }
        return false;
    }

    @Override
    public boolean editProfile(GymCustomer customer) {
        try{
            return custDAO.editProfile(customer);
        } catch (DataEntryFailedException ex){
            System.out.println(ex);
        }
        return false;
    }

    @Override
    public int createBooking(int customerId, int slotid, int centerId, Date date) {
        try{
            return custDAO.createBooking(customerId, slotid, centerId, date);
        } catch (ResourceNotFoundException e) {
            System.out.println(e);
        }
        return -1;
    }

    @Override
    public List<GymBooking> viewBookings(int customerId) {
        //System.out.println("My Bookings:");
        try{
            return custDAO.viewBookings(customerId);
        } catch (ResourceNotFoundException e){
            System.out.println(e);
        }
        return new ArrayList();
    }

    @Override
    public boolean cancelBooking(int customerId, int bookingId) {
        try{
            return custDAO.cancelBooking(customerId, bookingId);
        } catch (InvalidCredentialsException e) {
            System.out.println(e);
        } catch (UnauthorisedAccessException e){
            System.out.println(e);
        }
        return false;
    }

    @Override
    public int makepayment(int bookingId, String mode) {
        GymPayment gymPayment = new GymPayment(bookingId, mode);
        try{
            return custDAO.makepayment(gymPayment);
        } catch (DataEntryFailedException e) {
            System.out.println(e);
        }
        return -1;
    }

    @Override
    public boolean updatepwd(String email, String password, String role) {
        try {
            return custDAO.updatepwd(email, password, role);
        } catch (InvalidCredentialsException e) {
            System.out.println(e);
        }
        return false;
    }
}

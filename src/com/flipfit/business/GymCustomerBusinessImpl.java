package com.flipfit.business;

import com.flipfit.bean.GymBooking;
import com.flipfit.bean.GymCustomer;
import com.flipfit.bean.GymPayment;
import com.flipfit.bean.GymSlots;
import com.flipfit.dao.GymAdminDAO;
import com.flipfit.dao.GymAdminDAOImpl;
import com.flipfit.dao.GymCustomerDAO;
import com.flipfit.dao.GymCustomerDAOImpl;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class GymCustomerBusinessImpl implements GymCustomerBusiness {
    Scanner scanner = new Scanner(System.in);
    GymCustomerDAO custDAO = new GymCustomerDAOImpl();

    @Override
    public boolean createProfile(GymCustomer customer) {
        return custDAO.createProfile(customer);
    }

    @Override
    public boolean editProfile(GymCustomer customer) {
        return custDAO.editProfile(customer);
    }

    @Override
    public int createBooking(int customerId, int slotid, int centerId, Date date) {
        return custDAO.createBooking(customerId, slotid, centerId, date);
    }

    @Override
    public List<GymBooking> viewBookings(int customerId) {
        //System.out.println("My Bookings:");
        return custDAO.viewBookings(customerId);
    }

    @Override
    public boolean cancelBooking(int customerId, int bookingId) {
        return custDAO.cancelBooking(customerId, bookingId);
    }

    @Override
    public int makepayment(int bookingId, String mode) {
        GymPayment gymPayment = new GymPayment(bookingId, mode);
        return custDAO.makepayment(gymPayment);
    }

    @Override
    public boolean updatepwd(String email, String password, String role) {
        return custDAO.updatepwd(email, password, role);
    }
}

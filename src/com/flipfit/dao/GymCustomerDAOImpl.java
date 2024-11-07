package com.flipfit.dao;

import com.flipfit.bean.GymCustomer;
import com.flipfit.utils.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class GymCustomerDAOImpl implements GymCustomerDAO {
    private Connection conn = null;
    private PreparedStatement statement = null;

    @Override
    public void createProfile(GymCustomer customer) {
        try {
            conn = DBConnection.connect();
            System.out.println("Fetching gyms owners..");

            statement = conn.prepareStatement("insert into Customer values(?,?,?,?,?)");
            statement.executeUpdate();

        } catch (SQLException se) {
            se.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void viewBookings(int customerId) {

    }

    @Override
    public boolean waitlistStatus(int customerId) {
        return false;
    }

    @Override
    public boolean modifyBooking(int customerId) {
        return false;
    }

    @Override
    public boolean cancelBooking(int customerId) {
        return false;
    }

    @Override
    public void makepayment(int customerId) {

    }
}

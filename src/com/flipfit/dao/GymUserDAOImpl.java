package com.flipfit.dao;

import com.flipfit.bean.GymCustomer;
import com.flipfit.bean.GymOwner;
import com.flipfit.utils.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class GymUserDAOImpl implements GymUserDAO {

    private Connection conn = null;
    private PreparedStatement statement = null;

    @Override
    public List<GymCustomer> viewAllCustomers() {
        List<GymCustomer> customers = new ArrayList<>();
        try {
            conn = DBConnection.connect();
            statement = conn.prepareStatement("Select * from Customer");
            ResultSet rs=statement.executeQuery();
            while(rs.next()){
                customers.add(new GymCustomer(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6)));
                //System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getString(4)+" "+rs.getString(5)+" "+rs.getString(6));
            }

        } catch (SQLException se) {
            se.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return customers;
    }

    @Override
    public List<GymOwner> viewAllGymOwners() {
        List<GymOwner> owners = new ArrayList<>();
        try {
            conn = DBConnection.connect();
            statement = conn.prepareStatement("Select * from OwnerInfo");
            ResultSet rs=statement.executeQuery();
            while(rs.next()){
                owners.add(new GymOwner(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(5),rs.getString(4),rs.getString(6)));
                //System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getString(4)+" "+rs.getString(5)+" "+rs.getString(6));
            }

        } catch (SQLException se) {
            se.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return owners;
    }

    @Override
    public int login(String email, String password, String role) {
        try {

            conn = DBConnection.connect();
            statement = conn.prepareStatement("select * from registration where EmailAddress = ? and Password = ? and Role = ?");
            statement.setString(1, email);
            statement.setString(2, password);
            statement.setString(3, role);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return resultSet.getInt("UserId");
            } else {
                return -1;
            }
        } catch (SQLException se) {
            se.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return -1;
    }
}

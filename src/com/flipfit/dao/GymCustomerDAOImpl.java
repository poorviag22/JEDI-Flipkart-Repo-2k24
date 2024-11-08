

package com.flipfit.dao;
import com.flipfit.utils.DBConnection;
import com.flipfit.bean.GymBooking;
import com.flipfit.bean.GymCustomer;
import com.flipfit.bean.GymPayment;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class GymCustomerDAOImpl implements GymCustomerDAO {
    private Connection conn = null;
    private PreparedStatement statement = null;

    //    Name , Email , Address , Phone Number , Password
    @Override

    public void createProfile(GymCustomer customer) {
        try {
            conn = DBConnection.connect();
            System.out.println("Adding User Profile");
            statement = conn.prepareStatement("insert into User(`Name`,`Email`,`PhoneNumber`,`Role`,`Address`) values (?,?,?,?,?)", PreparedStatement.RETURN_GENERATED_KEYS);
            statement.setString(1, customer.getCustomerName());
            statement.setString(2, customer.getCustomerEmailAddress());
            statement.setString(3, customer.getCustomerPhone());
            statement.setString(4, "gymcustomer");
            statement.setString(5, customer.getCustomerAddress());
            int rowsAffected = statement.executeUpdate();
            int customerId = 0;
            if (rowsAffected > 0) {
                // Retrieve the generated customerId
                ResultSet generatedKeys = statement.getGeneratedKeys();
                if (generatedKeys.next()) {
                    customerId = generatedKeys.getInt(1);
                }
            }

            statement = conn.prepareStatement("insert into Customer values (?,?,?,?,?,?)");
            statement.setInt(1,customerId);
            statement.setString(2, customer.getCustomerName());
            statement.setString(3, customer.getCustomerEmailAddress());
            statement.setString(4, customer.getCustomerAddress());
            statement.setString(5, customer.getCustomerPhone());
            statement.setString(6, customer.getPassword());
            statement.executeUpdate();

            statement = conn.prepareStatement("insert into Registration values (?,?,?,?)");
            statement.setInt(1,customerId);
            statement.setString(2, customer.getCustomerEmailAddress());
            statement.setString(3, customer.getPassword());
            statement.setString(4, "gymcustomer");
            statement.executeUpdate();
        } catch (SQLException se) {
            se.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    @Override
    public boolean editProfile(GymCustomer customer) {
        String sql = "UPDATE Customer SET Name = ?, Email = ?, Address = ?, PhoneNumber = ?, Password=? WHERE CustId = ?";

        try {
            conn=DBConnection.connect();

            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, customer.getCustomerName());
            statement.setString(2, customer.getCustomerEmailAddress());
            statement.setString(3, customer.getCustomerAddress());
            statement.setString(4, customer.getCustomerPhone());
            statement.setString(5,customer.getPassword());
            statement.setInt(6, customer.getCustomerId());
            int rowsUpdated = statement.executeUpdate();
            if(rowsUpdated <= 0) {
                return false;
            }
            statement = conn.prepareStatement("UPDATE User SET Name = ?, Email = ?, Address = ?, PhoneNumber = ? WHERE UserId = ?");
            statement.setString(1, customer.getCustomerName());
            statement.setString(2, customer.getCustomerEmailAddress());
            statement.setString(3, customer.getCustomerAddress());
            statement.setString(4, customer.getCustomerPhone());
            statement.setInt(5, customer.getCustomerId());
            statement.executeUpdate();

            statement = conn.prepareStatement("UPDATE Registration SET EmailAddress = ?, Password = ? WHERE UserId = ?");
            statement.setString(1, customer.getCustomerEmailAddress());
            statement.setString(2, customer.getPassword());
            statement.setInt(3, customer.getCustomerId());
            statement.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
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

    @Override
    public void viewBookings(int customerId) {
        try {

            conn = DBConnection.connect();
            System.out.println("Adding User Profile");
            statement = conn.prepareStatement("select * from bookings where CustomerId = ?");
            statement.setInt(1, customerId);
            statement.executeQuery();
//            resultSet = statement.executeQuery();

//            while (resultSet.next()) {
//               Depedning on the columns of booking extract and print below
//                int bookingId = resultSet.getInt("BookingId");
//                String bookingDate = resultSet.getString("BookingDate");
            // You can print out other fields as necessary
//                System.out.println("Booking ID: " + bookingId + ", Booking Date: " + bookingDate);
//            }
        } catch (SQLException se) {
            se.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean waitlistStatus(int bookingID) {
        try {
//          Waitlist table :  BookingID , WaitListed Status


            conn = DBConnection.connect();
            System.out.println("Checking Waitlisted");
            statement = conn.prepareStatement("select * from waitlist where BookingID = ?");
            statement.setInt(1, bookingID);
//            statement.executeQuery();
            ResultSet resultSet = statement.executeQuery();

            return resultSet.getInt("Status") > 0;

        } catch (SQLException se) {
            se.printStackTrace();
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }


    @Override
    public boolean cancelBooking(int bookingID) {
        try {
            conn = DBConnection.connect();
            System.out.println("Cancel Booking ");
            statement = conn.prepareStatement("DELETE FROM Bookings where BookingID=?");
            statement.setInt(1, bookingID);
            statement.executeQuery();
            return true;
        } catch (SQLException se) {
            se.printStackTrace();
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public int createBooking(int customerID, int centerID, int slotID) {
        int bookingID = 10;
//    customerID, BookingID,centerID,SlotID,Date(auto gen)
        try {
            conn = DBConnection.connect();
            System.out.println("Creating New Booking ");
            statement = conn.prepareStatement("insert into bookings values (?,?,?,?)");

            statement.setInt(1, customerID);
            statement.setInt(2, bookingID);
            statement.setInt(3, centerID);
            statement.setInt(4, slotID);
            statement.executeQuery();

            //          later have to add waitlist
            return bookingID;

        } catch (SQLException se) {
            se.printStackTrace();
            return -1;
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }


    }

    @Override
    public int modifyBooking(int bookingID, int customerID, int centerID, int slotID) {

        try {
            cancelBooking(bookingID);
            int newBookingID = createBooking(customerID, centerID, slotID);
            return newBookingID;
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    @Override
    public boolean makepayment(GymPayment paymentData) {
        try {
            conn = DBConnection.connect();
            System.out.println("Making Payment ");
            statement = conn.prepareStatement("insert into payment values (?,?,?,?)");
            statement.setInt(1, paymentData.getBookingID());
            statement.setInt(3, paymentData.getMode());
            statement.setInt(2, paymentData.getAmount());
            statement.executeUpdate();
            return true;
//            payment ID needs to auto generated and Mode has to be added in the table and status we need to add here
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
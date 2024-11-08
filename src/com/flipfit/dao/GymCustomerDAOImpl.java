

package com.flipfit.dao;
import com.flipfit.utils.DBConnection;
import com.flipfit.bean.GymBooking;
import com.flipfit.bean.GymCustomer;
import com.flipfit.bean.GymPayment;

import java.sql.*;
import java.time.LocalTime;
import java.util.Date;

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
            statement = conn.prepareStatement("select * from CustomerBooking where CustId = ?");
            statement.setInt(1, customerId);
            ResultSet resultSet = statement.executeQuery();
            System.out.println("BookingId CenterName CenterLocation StartTime EndTime Date");
            while(resultSet.next()) {
                statement = conn.prepareStatement("select * from GymCenters where centerId = ?");
                statement.setInt(1, resultSet.getInt(3));
                ResultSet resultSet1 = statement.executeQuery();
                resultSet1.next();
                String CenterName = resultSet1.getString(3);
                String CenterLoc = resultSet1.getString(4);
                statement = conn.prepareStatement("select * from Slots where slotsId = ?");
                statement.setInt(1, resultSet.getInt(4));
                resultSet1 = statement.executeQuery();
                resultSet1.next();
                LocalTime startTime = resultSet1.getTime(3).toLocalTime();
                LocalTime endTime = resultSet1.getTime(4).toLocalTime();
                System.out.println(resultSet.getInt(2) + " " + CenterName + " " + CenterLoc + " " + startTime.toString() + " " + endTime.toString() + " " + resultSet.getDate(5));
            }
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
    public boolean cancelBooking(int customerId, int bookingID) {
        try {
            conn = DBConnection.connect();
            statement = conn.prepareStatement("select * from CustomerBooking where CustId = ? and BookingID = ?");
            statement.setInt(1, customerId);
            statement.setInt(2, bookingID);
            ResultSet resultSet = statement.executeQuery();
            if(resultSet.next()) {
                System.out.println("Cancel Booking ");
                statement = conn.prepareStatement("DELETE FROM CustomerBooking where BookingID=?");
                statement.setInt(1, bookingID);
                statement.executeUpdate();
                return true;
            } else {
                System.out.println("Check your booking Id again");
                return false;
            }
        } catch (SQLException se) {
            se.printStackTrace();
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public int createBooking(int customerID, int slotID, int centerId, Date date) {
        //int bookingID = 10;
//    customerID, BookingID,centerID,SlotID,Date(auto gen)
        System.out.println(customerID + " " + slotID + " " + centerId);
        try {
            conn = DBConnection.connect();
            statement = conn.prepareStatement("select * from AvailableSeats where slotId=? and Date=?");
            statement.setInt(1, slotID);
            statement.setDate(2, new java.sql.Date(date.getTime()));
            ResultSet resultSet = statement.executeQuery();
            int bookingID = 0;
            if(resultSet.next() && resultSet.getInt(3) > 0) {
                int numSeats = resultSet.getInt(3);
                statement = conn.prepareStatement("update AvailableSeats set NumSeats = ? where slotId=? and Date=?");
                statement.setInt(1, numSeats-1);
                statement.setInt(2, slotID);
                statement.setDate(3, new java.sql.Date(date.getTime()));
                statement.executeUpdate();
                System.out.println("Creating New Booking ");
                statement = conn.prepareStatement("insert into CustomerBooking(`CustId`,`centerId`,`slotId`,`Date`) values (?,?,?,?)",PreparedStatement.RETURN_GENERATED_KEYS);
                statement.setInt(1, customerID);
                statement.setInt(2, centerId);
                statement.setInt(3, slotID);
                statement.setDate(4, new java.sql.Date(date.getTime()));
                int rowsAffected = statement.executeUpdate();
                if (rowsAffected > 0) {
                    // Retrieve the generated customerId
                    ResultSet generatedKeys = statement.getGeneratedKeys();
                    if (generatedKeys.next()) {
                        bookingID = generatedKeys.getInt(1);
                    }
                }
            } else if(!resultSet.next()) {

                statement = conn.prepareStatement("select * from slots where slotsId = ?");
                statement.setInt(1, slotID);
                resultSet = statement.executeQuery();
                if(!resultSet.next()) {
                    System.out.println("Something went wrong");
                }
                int TotalSeats = resultSet.getInt(5);

                statement = conn.prepareStatement("insert into AvailableSeats(`slotId`,`Date`,`NumSeats`) values (?,?,?)");
                statement.setInt(1, slotID);
                statement.setDate(2, new java.sql.Date(date.getTime()));
                statement.setInt(3, TotalSeats-1);
                statement.executeUpdate();

                System.out.println("Creating New Booking ");
                statement = conn.prepareStatement("insert into CustomerBooking(`CustId`,`centerId`,`slotId`,`Date`) values (?,?,?,?)",PreparedStatement.RETURN_GENERATED_KEYS);
                statement.setInt(1, customerID);
                statement.setInt(2, centerId);
                statement.setInt(3, slotID);
                statement.setDate(4, new java.sql.Date(date.getTime()));
                int rowsAffected = statement.executeUpdate();
                if (rowsAffected > 0) {
                    // Retrieve the generated customerId
                    ResultSet generatedKeys = statement.getGeneratedKeys();
                    if (generatedKeys.next()) {
                        bookingID = generatedKeys.getInt(1);
                    }
                }
            } else {
                System.out.println("No Seats Available for the slot on that date");
            }


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
    /*
    @Override
    public int modifyBooking(int bookingID, int customerID, int centerID, int slotID) {
        try {
            conn = DBConnection.connect();
            statement = conn.prepareStatement("Select * from CustomerBooking where BookingId = ?");
            statement.setInt(1, bookingID);
            ResultSet resultSet = statement.executeQuery();
            if (!resultSet.next()) {
                System.out.println("Booking Does Not Exist");
            }
            if(resultSet.getInt(1) != customerID){
                System.out.println("UnAuthorized Access");
            }
            //cancelBooking(bookingID);
            int newBookingID = createBooking(customerID, centerID, slotID, resultSet.getDate(5));
            return newBookingID;
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }
     */
    @Override
    public int makepayment(GymPayment paymentData) {
        try {
            conn = DBConnection.connect();
            System.out.println("Making Payment ");
            statement = conn.prepareStatement("Select * from CustomerBooking where BookingId = ?");
            statement.setInt(1, paymentData.getBookingID());
            ResultSet resultSet = statement.executeQuery();
            if(!resultSet.next()) {
                System.out.println("No Booking found");
            }
            int slotId = resultSet.getInt(4);
            statement = conn.prepareStatement("SELECT * from Slots where slotsId = ?");
            statement.setInt(1, slotId);
            resultSet = statement.executeQuery();
            if(!resultSet.next()) {
                System.out.println("No slot found");
            };
            int cost = resultSet.getInt(6);
            statement = conn.prepareStatement("insert into payment(`BookingId`, `Mode`, `Amount`) values (?,?,?)",PreparedStatement.RETURN_GENERATED_KEYS);
            statement.setInt(1, paymentData.getBookingID());
            statement.setString(2, paymentData.getMode());
            statement.setInt(3, cost);
            int rowsAffected = statement.executeUpdate();
            int paymentId = 0;
            if (rowsAffected > 0) {
                // Retrieve the generated customerId
                ResultSet generatedKeys = statement.getGeneratedKeys();
                if (generatedKeys.next()) {
                    paymentId = generatedKeys.getInt(1);
                }
            }
            return paymentId;
//            payment ID needs to auto generated and Mode has to be added in the table and status we need to add here
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    @Override
    public void viewSlots(int centerId, Date date) {
        try {

            conn = DBConnection.connect();
            System.out.println("SlotId CenterId StartTime EndTime Cost AvailableNumSeats");
            statement = conn.prepareStatement("SELECT * from Slots where centerId = ?");
            statement.setInt(1, centerId);
            ResultSet resultSet = statement.executeQuery();
            int NumSeatsAvailable = 0;
            while (resultSet.next()) {
                int slotID = resultSet.getInt(1);
                statement = conn.prepareStatement("select * from AvailableSeats where slotId = ? and Date = ?");
                statement.setInt(1, slotID);
                statement.setDate(2, new java.sql.Date(date.getTime()));
                ResultSet resultSet1 = statement.executeQuery();
                if(resultSet1.next()){
                    NumSeatsAvailable = resultSet1.getInt(3);
                } else {
                    NumSeatsAvailable = resultSet.getInt(5);
                }
                System.out.println(slotID+" "+resultSet.getInt(2)+" "+resultSet.getTime(3)+" "+resultSet.getTime(4) + " " + resultSet.getInt(6) + " " + NumSeatsAvailable );
            }
        } catch (SQLException se) {
            se.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updatepwd(String email, String password, String role) {
            try {
                conn = DBConnection.connect();
                statement =conn.prepareStatement("Select * from Registration where EmailAddress=? and role=?");
                statement.setString(1, email);
                statement.setString(2, role);
                ResultSet  resultSet=statement.executeQuery();
                if (!resultSet.next() ) {
                    System.out.println("You are not registered for this role yet!!");
                }
                else {
                    int id = resultSet.getInt(1);
                    statement = conn.prepareStatement("update Registration set Password=? where UserId=?");
                    statement.setString(1,password);
                    statement.setInt(2, id);
                    statement.executeUpdate();

                    statement = conn.prepareStatement("update Customer set Password=? where CustId=?");
                    statement.setString(1,password);
                    statement.setInt(2, id);
                    statement.executeUpdate();
                }

            } catch (SQLException se) {
                se.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
            }
    }
}
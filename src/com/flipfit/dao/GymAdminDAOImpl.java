package com.flipfit.dao;

import com.flipfit.bean.*;
import com.flipfit.utils.DBConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.time.LocalTime;
import java.util.*;

public class GymAdminDAOImpl implements GymAdminDAO {
    private Connection conn = null;
    private PreparedStatement statement = null;
    private PreparedStatement stmt = null;

    @Override
    public List<GymBooking> viewBookings() {
        List<GymBooking> bookings = new ArrayList<>();
        try {
            // We get all bookings
            conn = DBConnection.connect();
            statement = conn.prepareStatement("select * from CustomerBooking");
            ResultSet resultSet = statement.executeQuery();
            // For every booking in the table, we iterate the loop
            while (resultSet.next()) {
                // Get the center of this particular booking
                statement = conn.prepareStatement("select * from GymCenters where centerId = ?");
                statement.setInt(1, resultSet.getInt(3));
                ResultSet resultSet1 = statement.executeQuery();
                resultSet1.next();
                String CenterName = resultSet1.getString(3);
                String CenterLoc = resultSet1.getString(4);
                // Get the particular slot of this booking
                statement = conn.prepareStatement("select * from Slots where slotsId = ?");
                statement.setInt(1, resultSet.getInt(4));
                resultSet1 = statement.executeQuery();
                resultSet1.next();
                LocalTime startTime = resultSet1.getTime(3).toLocalTime();
                LocalTime endTime = resultSet1.getTime(4).toLocalTime();
                //Store the bookings in list
                bookings.add(new GymBooking(resultSet.getInt(2), CenterName, CenterLoc, startTime, endTime, resultSet.getDate(5)));
            }
        } catch (SQLException se) {
            se.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bookings;
    }

    public void approveOwnerRegistration(int requestId, String statuss) {
        try {
            conn = DBConnection.connect();
            // check whether request exists
            statement = conn.prepareStatement("Select * from OwnerRequest where RequestId=? and Status=?");
            statement.setInt(1, requestId);
            statement.setString(2, "pending");
            ResultSet resultSet = statement.executeQuery();
            if (!resultSet.next()) {
                System.out.println("Such Pending Request Does Not Exist!!");
                return;
            }
            // update the status
            int ownerId = resultSet.getInt(2);
            String centerName = resultSet.getString(4);
            String location = resultSet.getString(5);
            int NumOfSlots = resultSet.getInt(6);
            statement = conn.prepareStatement("Update OwnerRequest set status=? where RequestId=?");
            statement.setString(1, statuss);
            statement.setInt(2, requestId);
            statement.executeUpdate();

            if (statuss.equals("rejected")) {
                return;
            }
            // if approved, add center to center table
            statement = conn.prepareStatement("insert into GymCenters(`OwnerId`,`CenterName`,`Location`,`NumOfSlots`) values (?,?,?,?)");
            statement.setInt(1, ownerId);
            statement.setString(2, centerName);
            statement.setString(3, location);
            statement.setInt(4, NumOfSlots);
            statement.executeUpdate();
        } catch (SQLException se) {
            se.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<GymOwnerRequest> pendingRequests() {
        List<GymOwnerRequest> requests = new ArrayList<>();
        try {
            //get all pending requests
            conn = DBConnection.connect();
            statement = conn.prepareStatement("Select * from OwnerRequest where Status=?");
            statement.setString(1, "pending");
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                //store all the pending requests in the list
                requests.add(new GymOwnerRequest(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getInt(6)));
            }

        } catch (SQLException se) {
            se.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return requests;
    }

    @Override
    public List<GymCenter> viewCenter() {
        List<GymCenter> centers = new ArrayList<>();
        try {
            // get all gymcenters
            conn = DBConnection.connect();
            statement = conn.prepareStatement("Select * from GymCenters");
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                //store all the centers in a list
                centers.add(new GymCenter(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4), rs.getInt(5)));
            }

        } catch (SQLException se) {
            se.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return centers;
    }

    @Override
    public boolean updatepwd(String email, String password, String role) {
        try {
            // check whether a user exists with the corresponding mailID on that role
            conn = DBConnection.connect();
            stmt = conn.prepareStatement("Select * from Registration where EmailAddress=? and role=?");
            stmt.setString(1, email);
            stmt.setString(2, role);
            ResultSet resultSet = stmt.executeQuery();
            if (!resultSet.next()) {
                System.out.println("You are not registered for this role yet!!");
                return false;
            } else {
                // update password in registration table
                int id = resultSet.getInt(1);
                statement = conn.prepareStatement("update Registration set Password=? where UserId=?");
                statement.setString(1, password);
                statement.setInt(2, id);
                statement.executeUpdate();

                // update password in adminInfo table
                statement = conn.prepareStatement("update AdminInfo set Password=? where AdminId=?");
                statement.setString(1, password);
                statement.setInt(2, id);
                statement.executeUpdate();
                return true;
            }

        } catch (SQLException se) {
            se.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}

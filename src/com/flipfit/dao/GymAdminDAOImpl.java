package com.flipfit.dao;

import com.flipfit.utils.DBConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
public class GymAdminDAOImpl implements GymAdminDAO
{
    private Connection conn = null;
    private PreparedStatement statement = null;
    private PreparedStatement stmt = null;

    @Override
    public void viewBookings() {
        try {
            conn = DBConnection.connect();
            System.out.println("Fetching gyms owners..");

            statement = conn.prepareStatement("Select * from CustomerBooking");
            ResultSet rs=statement.executeQuery();
            while(rs.next()){
                System.out.println(rs.getInt(1)+" "+rs.getInt(2)+" "+rs.getInt(3)+" "+rs.getInt(4));
            }



        } catch (SQLException se) {
            se.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void editProfile(int id, String name,String email,String number,String pwd) {
        try {
            conn = DBConnection.connect();
            System.out.println("Fetching gyms owners..");
            stmt =conn.prepareStatement("Select AdminId from CustomerBooking where AdminId ="+ id);
            ResultSet  resultSet=stmt.executeQuery();

            if (!resultSet.next() ) {
                System.out.println("User Does Not Exist!!");
            }
            else {
                statement = conn.prepareStatement("update AdminInfo set AdminId=?,Name=?,Email=?,PhoneNumber=?,Password=? where AdminId="+id);
                statement.setInt(1,id);
                statement.setString(2, name);
                statement.setString(3, email);
                statement.setString(4, number);
                statement.setString(5, pwd);

                statement.executeUpdate();
            }

        } catch (SQLException se) {
            se.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void viewCustomers() {
        try {
            conn = DBConnection.connect();
            System.out.println("Fetching gyms owners..");

            statement = conn.prepareStatement("Select * from Customer");
            ResultSet rs=statement.executeQuery();

            //PreparedStatement stmt=con.prepareStatement("select * from emp");
            //ResultSet rs=stmt.executeQuery();
            while(rs.next()){
                System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getString(4)+" "+rs.getString(5)+" "+rs.getString(6));
            }

        } catch (SQLException se) {
            se.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public void approveOwnerRegistration(int requestId, String statuss){
        try {
            conn = DBConnection.connect();
            //check whether request exists
            statement = conn.prepareStatement("Select * from OwnerRequest where RequestId=? and Status=?");
            statement.setInt(1, requestId);
            statement.setString(2, "pending");
            ResultSet resultSet = statement.executeQuery();
            if(!resultSet.next()){
                System.out.println("Such Pending Request Does Not Exist!!");
            }
            //update the status
            int ownerId = resultSet.getInt(2);
            String centerName = resultSet.getString(4);
            String location = resultSet.getString(5);
            int NumOfSlots = resultSet.getInt(6);
            statement = conn.prepareStatement("Update OwnerRequest set status=? where RequestId=?");
            statement.setString(1, statuss);
            statement.setInt(2, requestId);
            statement.executeUpdate();

            if(statuss.equals("rejected")){
                return;
            }
            //add center to center table
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
    public void pendingRequests() {
        try {
            conn = DBConnection.connect();
            System.out.println("Fetching gyms owners..");

            statement = conn.prepareStatement("Select * from OwnerRequest where Status=?");
            statement.setString(1, "pending");

            ResultSet rs=statement.executeQuery();

            //PreparedStatement stmt=con.prepareStatement("select * from emp");
            //ResultSet rs=stmt.executeQuery();
            System.out.println("RequestId OwnerId Status CenterName CenterLocation NumOfSlots");
            while(rs.next()){
                System.out.println(rs.getInt(1)+" "+rs.getInt(2)+" "+rs.getString(3)+" "+rs.getString(4)+" "+rs.getString(5)+" "+rs.getInt(6));
            }

        } catch (SQLException se) {
            se.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void viewCenter() {
        try {
            conn = DBConnection.connect();
            System.out.println("Fetching gyms centers..");

            statement = conn.prepareStatement("Select * from GymCenters");
            ResultSet rs=statement.executeQuery();

            //PreparedStatement stmt=con.prepareStatement("select * from emp");
            //ResultSet rs=stmt.executeQuery();
            while(rs.next()){
                System.out.println(rs.getInt(1)+" "+rs.getInt(2)+" "+rs.getString(3)+" "+rs.getString(4)+" "+rs.getInt(5));
            }

        } catch (SQLException se) {
            se.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

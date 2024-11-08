package com.flipfit.utils;

import com.flipfit.exception.DBconnectionException;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DBConnection
{
    public static Connection connect() throws SQLException, DBconnectionException {
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con=DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/GymCustomer","root","sd@2801$");
            System.out.println("Database Connected");
            return con;

        }catch(Exception e){
            System.out.println("Database Not Connected");
            throw new DBconnectionException("Failed to connect to the database: " + e.getMessage());

        }

    }


}
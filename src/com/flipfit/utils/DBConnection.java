package com.flipfit.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DBConnection
{
    public static Connection connect() throws SQLException {
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            String password = "Password123";//Enter your password here
            Connection con=DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/GymCustomer","root",password);



            System.out.println("Database Connected");

            return con;



        }catch(Exception e){
            System.out.println(e);
            System.out.println("Database Not Connected");
            return null;
            }

    }
}
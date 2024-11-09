package com.flipfit.dao;

import com.flipfit.utils.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

public class GymSlotDAOImpl implements GymSlotDAO {
    private Connection conn = null;
    private PreparedStatement statement = null;

    @Override
    public int getNumAvailableSeats(int slotId, Date date, int TotalSeats) {
        int NumSeatsAvailable = 0;
        try{
            conn = DBConnection.connect();
            statement = conn.prepareStatement("select * from AvailableSeats where slotId = ? and Date = ?");
            statement.setInt(1, slotId);
            statement.setDate(2, new java.sql.Date(date.getTime()));
            ResultSet resultSet1 = statement.executeQuery();

            if(resultSet1.next()){
                NumSeatsAvailable = resultSet1.getInt(3);
            } else {
                NumSeatsAvailable = TotalSeats;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return NumSeatsAvailable;
    }
}

package com.flipfit.dao;

import com.flipfit.bean.GymSlots;
import com.flipfit.business.GymSlotsBusiness;
import com.flipfit.business.GymSlotsBusinessImpl;
import com.flipfit.utils.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class GymCenterDAOImpl implements GymCenterDAO {

    private Connection conn = null;
    private PreparedStatement statement = null;

    @Override
    public List<GymSlots> viewSlots(int centerId, Date date) {
        List<GymSlots> slots = new ArrayList<>();
        try {
            // Get all the slots of the particular center
            conn = DBConnection.connect();
            statement = conn.prepareStatement("SELECT * from Slots where centerId = ?");
            statement.setInt(1, centerId);
            ResultSet resultSet = statement.executeQuery();
            int NumSeatsAvailable = 0;
            while (resultSet.next()) {
                //For every slot caluculate available seats
                int slotID = resultSet.getInt(1);
                GymSlotsBusiness slotsBusiness = new GymSlotsBusinessImpl();
                NumSeatsAvailable = slotsBusiness.getNumAvailableSeats(slotID, date, resultSet.getInt(5));
                // Store the slot info in the list
                slots.add(new GymSlots(resultSet.getInt(2), slotID, resultSet.getTime(3).toLocalTime(), resultSet.getTime(4).toLocalTime(), resultSet.getInt(6), NumSeatsAvailable));
            }
        } catch (SQLException se) {
            se.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return slots;
    }
}

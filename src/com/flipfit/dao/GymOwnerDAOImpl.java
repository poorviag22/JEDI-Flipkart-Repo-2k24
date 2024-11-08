package com.flipfit.dao;

import com.flipfit.bean.GymOwner;
import com.flipfit.bean.GymSlots;
import com.flipfit.exception.DBconnectionException;
import com.flipfit.utils.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.time.LocalDateTime;

public class GymOwnerDAOImpl implements GymOwnerDAO {
    private Connection connection = null;
    private PreparedStatement statement = null;
    private PreparedStatement stmt = null;
    @Override
    public void registerCenter(int requestId,String centerName,String location,int slots)
    {
        try {
            connection = DBConnection.connect();
            statement = connection.prepareStatement("insert into OwnerRequest values (?,?,?,?)");
            statement.setInt(1, requestId);
            statement.setString(2, centerName);
            statement.setString(3, location);
            statement.setInt(4, slots);
            statement.executeUpdate();
//            payment ID needs to auto generated and Mode has to be added in the table and status we need to add here
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void addSlots(int centerID, GymSlots slot)
    {
        // Check if the same slot is already present in the slot table for the given gymCenter
        if (isSlotExists(centerID, slot))
        {
            System.out.println("Slot already exists for the given GymCenter.");
            return; // Or throw an exception or handle the situation as per your requirement
        }

        String sql = "INSERT INTO slot (slotID, starttime, endtime, capacity, centerID) VALUES (?,?,?,?,?)";

        try
        {
              connection = DBConnection.connect();

               PreparedStatement statement = connection.prepareStatement(sql);


                statement.setInt(1, slot.getSlotId()); // Assuming slot.getSlotID() retrieves the slot ID
                statement.setTimestamp(2, java.sql.Timestamp.valueOf(slot.getStartTime())); // Assuming slot.getStarttime() returns LocalDateTime
                statement.setTimestamp(3, java.sql.Timestamp.valueOf(slot.getEndTime())); // Assuming slot.getEndTime() returns a LocalTime object
                statement.setInt(4, slot.getAvailableSeats()); // Assuming slot.getCapacity() returns the capacity
                statement.setInt(5, centerID); // Assuming gymCenter.getGymID() retrieves the gymID

                int rowsInserted = statement.executeUpdate();
                if (rowsInserted > 0) {
                    System.out.println("Slot added successfully.");
                } else {
                    System.out.println("Failed to add slot.");
                }

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (DBconnectionException e) {
            throw new RuntimeException(e);
        }
    }
    public boolean isSlotExists(int centerID, GymSlots slot)
    {
        String sql = "SELECT COUNT(*) AS count FROM slot WHERE centerID = ? AND starttime = ? AND endtime = ?";
        try
        {
            connection = DBConnection.connect();
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, centerID);
            statement.setTimestamp(2, java.sql.Timestamp.valueOf(slot.getStartTime())); // Assuming slot.getStarttime() returns LocalDateTime
            statement.setTimestamp(3, java.sql.Timestamp.valueOf(slot.getEndTime()));

            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next())
            {
                int count = resultSet.getInt("count");
                return count > 0;
            }
      }
        catch (SQLException | DBconnectionException e)
        {
            throw new RuntimeException(e);
        }
        return false;
    }


        @Override
        public void deleteSlot(String centerID, LocalDateTime starttime)
        {
            String sql = "DELETE FROM slot WHERE centerID = ? AND starttime = ?";

            try {
                connection=DBConnection.connect();

            PreparedStatement statement = connection.prepareStatement(sql);

                // Convert LocalDateTime to java.sql.Timestamp for DATETIME columns
                statement.setString(1, centerID);
                statement.setTimestamp(2, java.sql.Timestamp.valueOf(starttime));

                int rowsDeleted = statement.executeUpdate();
                if (rowsDeleted > 0) {
                    System.out.println("Slot deleted successfully.");
                }
                else
                {
                    System.out.println("Slot not found or failed to delete.");
                }

            }
            catch (SQLException e) {
                e.printStackTrace();
            } catch (DBconnectionException e) {
                throw new RuntimeException(e);
            }
        }

    @Override
            public void deleteCenter(int centerID)
    {
                String sql = "DELETE FROM  GymCenters WHERE centerID = ? ";

                try {
                    connection=DBConnection.connect();

                PreparedStatement statement = connection.prepareStatement(sql);
                    statement.setInt(1, centerID);


                    int rowsDeleted = statement.executeUpdate();
                    if (rowsDeleted > 0)
                    {
                        System.out.println("Center Deleted successfully.");
                    }
                    else
                    {
                        System.out.println("Center not found or failed to delete.");
                    }

                } catch (SQLException e) {
                    e.printStackTrace();
                } catch (DBconnectionException e) {
                    throw new RuntimeException(e);
                }
    }

    @Override
        public boolean editProfile(GymOwner gymOwner)
        {
            String sql = "UPDATE OwnerInfo SET OwnerId= ?, Name = ?, Email = ?, PhoneNumber = ?, Password=?, WHERE OwnerId = ?";

            try {
                connection=DBConnection.connect();

            PreparedStatement statement = connection.prepareStatement(sql);
                statement.setInt(1, gymOwner.getOwnerId());
                statement.setString(2, gymOwner.getOwnerName());
                statement.setString(3, gymOwner.getOwnerEmailAddress());
                statement.setString(4, gymOwner.getOwnerPhone());
                statement.setString(5,gymOwner.getPassword());
                int rowsUpdated = statement.executeUpdate();
                return rowsUpdated > 0;
            } catch (SQLException | DBconnectionException e) {
                e.printStackTrace();
            }
            return false;
        }

    @Override
    public void viewReport()
    {

    }
}

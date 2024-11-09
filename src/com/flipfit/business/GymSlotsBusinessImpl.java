package com.flipfit.business;

import com.flipfit.dao.GymSlotDAO;
import com.flipfit.dao.GymSlotDAOImpl;

import java.util.Date;

public class GymSlotsBusinessImpl implements GymSlotsBusiness {

    GymSlotDAO gymSlotDAO = new GymSlotDAOImpl();

    @Override
    public int getNumAvailableSeats(int slotId, Date date, int TotalSeats) {
        return gymSlotDAO.getNumAvailableSeats(slotId, date, TotalSeats);
    }
}

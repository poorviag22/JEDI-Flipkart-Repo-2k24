package com.flipfit.business;

import java.util.Date;

public interface GymSlotsBusiness {
    public int getNumAvailableSeats(int slotId, Date date, int TotalSeats);

}

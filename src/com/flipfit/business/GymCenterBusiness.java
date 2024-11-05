package com.flipfit.business;

public interface GymCenterBusiness {
    public String viewSlots(int centerId);
    public boolean bookSlot(int centerId,int slotId);
    public boolean cancelBooking(int centerId,int slotId);
    public int waitlist(int centerId,int slotId);
}

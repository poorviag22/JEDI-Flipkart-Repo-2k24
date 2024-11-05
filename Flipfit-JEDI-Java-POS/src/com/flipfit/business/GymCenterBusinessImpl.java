package com.flipfit.business;

public class GymCenterBusinessImpl implements GymCenterBusiness {
    public String viewSlots(int centerId){
        return "";
    }
    public boolean bookSlot(int centerId,int slotId){
        return true;
    }
    public boolean cancelBooking(int centerId,int slotId){
        return true;
    }
    public int waitlist(int centerId,int slotId){
        return 1;
    }
}

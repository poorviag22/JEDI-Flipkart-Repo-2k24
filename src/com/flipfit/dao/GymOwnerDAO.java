package com.flipfit.dao;

import com.flipfit.bean.GymCustomer;
import com.flipfit.bean.GymOwner;
import com.flipfit.bean.GymSlots;

import java.time.LocalDateTime;

public interface GymOwnerDAO {
    public void createProfile(GymOwner gymOwner);
    public void registerCenter(int ownerId, String centerName,String location,int slots);
    public void addSlots(int centerID, GymSlots slot);
    public void deleteSlot(String centerID, LocalDateTime starttime);
    public void deleteCenter(int centerId);
    public boolean editProfile(GymOwner gymOwner);
    public void viewReport();
    public int login(String email, String password, String role);
}

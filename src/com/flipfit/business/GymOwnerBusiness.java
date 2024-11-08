package com.flipfit.business;

import com.flipfit.bean.GymCenter;
import com.flipfit.bean.GymOwner;
import com.flipfit.bean.GymSlots;

public interface GymOwnerBusiness {

    public void registerCenter(int ownerId);
    public void addnewSlot();
    public void deleteSlot();
    public void deleteCenter();
    public void editProfile(int ownerId);
    public void viewReport();
    public void createProfile(GymOwner owner);
    public int login(String email, String password, String role);


}

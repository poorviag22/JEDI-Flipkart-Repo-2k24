package com.flipfit.business;

import com.flipfit.bean.GymCenter;
import com.flipfit.bean.GymOwner;
import com.flipfit.bean.GymSlots;

import java.time.LocalTime;

public interface GymOwnerBusiness {

    public void registerCenter(int ownerId, String centerName,String location,int slots);

    public void addnewSlot(int centerId, GymSlots slot);

    public void deleteSlot(int centerId, LocalTime startTime);

    public void deleteCenter(int centerId);

    public void editProfile(GymOwner owner);

    public boolean createProfile(GymOwner owner);

    public boolean updatepwd(String email, String password, String role);


}

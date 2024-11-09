package com.flipfit.business;

import com.flipfit.bean.GymCenter;
import com.flipfit.bean.GymOwner;
import com.flipfit.bean.GymSlots;

import java.time.LocalTime;

public interface GymOwnerBusiness {

    public boolean registerCenter(int ownerId, String centerName,String location,int slots);

    public boolean addnewSlot(int centerId, GymSlots slot);

    public boolean deleteSlot(int centerId, LocalTime startTime);

    public boolean deleteCenter(int centerId);

    public boolean editProfile(GymOwner owner);

    public boolean createProfile(GymOwner owner);

    public boolean updatepwd(String email, String password, String role);


}

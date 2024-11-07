package com.flipfit.business;

import com.flipfit.bean.GymCenter;
import com.flipfit.bean.GymSlots;

public interface GymOwnerBusiness {

    public void registerCenter(int ownerId);
    public void addnewSlot();
    public void deleteSlot();
    public void deleteCenter();
    public void editProfile();
    public void viewReport();


}

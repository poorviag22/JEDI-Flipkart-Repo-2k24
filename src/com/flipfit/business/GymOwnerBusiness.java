package com.flipfit.business;

import com.flipfit.bean.GymCenter;
import com.flipfit.bean.GymSlots;

public interface GymOwnerBusiness {

    public void registerCenter(GymCenter center);
    public void addnewSlot(GymSlots slot);
    public void deleteSlot(int slotId);
    public void deleteCenter(int centerId);


}

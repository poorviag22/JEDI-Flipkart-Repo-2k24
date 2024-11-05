package com.flipfit.business;

import com.flipfit.bean.Center;
import com.flipfit.bean.Slots;

public interface OwnerBusiness {

    public void registerCenter(Center center);
    public void addnewSlot(Slots slot);
    public void deleteSlot(int slotId);
    public void deleteCenter(int centerId);


}

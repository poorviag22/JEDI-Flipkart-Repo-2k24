package com.flipfit.business;

import com.flipfit.bean.GymSlots;

import java.util.Date;
import java.util.List;

public interface GymCenterBusiness {
    public List<GymSlots> viewSlots(int centerId, Date date);
}

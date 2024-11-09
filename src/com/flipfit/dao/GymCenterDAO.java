package com.flipfit.dao;

import com.flipfit.bean.GymSlots;
import com.flipfit.exceptions.ResourceNotFoundException;

import java.util.Date;
import java.util.List;

public interface GymCenterDAO {
    public List<GymSlots> viewSlots(int centerId, Date date) throws ResourceNotFoundException;
}

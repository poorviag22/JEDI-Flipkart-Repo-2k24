package com.flipfit.business;

import com.flipfit.bean.GymSlots;
import com.flipfit.dao.GymCenterDAO;
import com.flipfit.dao.GymCenterDAOImpl;

import java.util.Date;
import java.util.List;

public class GymCenterBusinessImpl implements GymCenterBusiness {

    GymCenterDAO gymCenterDAO = new GymCenterDAOImpl();
    @Override
    public List<GymSlots> viewSlots(int centerId, Date date) {
        return gymCenterDAO.viewSlots(centerId, date);
    }
}

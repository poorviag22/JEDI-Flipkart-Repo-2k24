package com.flipfit.business;

import com.flipfit.bean.GymSlots;
import com.flipfit.dao.GymCenterDAO;
import com.flipfit.dao.GymCenterDAOImpl;
import com.flipfit.exceptions.ResourceNotFoundException;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class GymCenterBusinessImpl implements GymCenterBusiness {

    GymCenterDAO gymCenterDAO = new GymCenterDAOImpl();
    @Override
    public List<GymSlots> viewSlots(int centerId, Date date) {
        try {
            return gymCenterDAO.viewSlots(centerId, date);
        } catch (ResourceNotFoundException e) {
            System.out.println(e);
        }
        return new ArrayList();
    }
}

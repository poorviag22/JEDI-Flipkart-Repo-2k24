package com.flipfit.business;

import com.flipfit.bean.GymAdmin;
import com.flipfit.bean.GymCustomer;
import com.flipfit.bean.GymOwner;
import com.flipfit.dao.GymUserDAO;
import com.flipfit.dao.GymUserDAOImpl;

import java.util.List;

public class GymUserBusinessImpl implements GymUserBusiness {

    GymUserDAO gymUserDAO = new GymUserDAOImpl();
    @Override
    public List<GymCustomer> viewAllCustomers() {
        return gymUserDAO.viewAllCustomers();
    }

    @Override
    public List<GymOwner> viewAllGymOwners() {
        return gymUserDAO.viewAllGymOwners();
    }

    @Override
    public int login(String email, String password, String role) {
        return gymUserDAO.login(email, password, role);
    }


}

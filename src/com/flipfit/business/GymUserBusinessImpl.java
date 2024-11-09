package com.flipfit.business;

import com.flipfit.bean.GymAdmin;
import com.flipfit.bean.GymCustomer;
import com.flipfit.bean.GymOwner;
import com.flipfit.dao.GymUserDAO;
import com.flipfit.dao.GymUserDAOImpl;
import com.flipfit.exceptions.DBConnectionException;
import com.flipfit.exceptions.InvalidCredentialsException;
import com.flipfit.exceptions.ResourceNotFoundException;

import java.util.ArrayList;
import java.util.List;

public class GymUserBusinessImpl implements GymUserBusiness {

    GymUserDAO gymUserDAO = new GymUserDAOImpl();
    @Override
    public List<GymCustomer> viewAllCustomers() {
        try {
            return gymUserDAO.viewAllCustomers();
        } catch (ResourceNotFoundException e) {
            System.out.println(e);
        }
        return new ArrayList();
    }

    @Override
    public List<GymOwner> viewAllGymOwners() {
        try {
            return gymUserDAO.viewAllGymOwners();
        } catch (ResourceNotFoundException e) {
            System.out.println(e);
        }
        return new ArrayList();
    }

    @Override
    public int login(String email, String password, String role) {
        try{
            return gymUserDAO.login(email, password, role);
        } catch (InvalidCredentialsException inex) {
            System.out.println(inex);
        } catch (DBConnectionException dbex){
            System.out.println(dbex);
        }
        return -1;
    }


}

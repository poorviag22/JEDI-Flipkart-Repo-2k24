package com.flipfit.business;

import com.flipfit.bean.*;
import com.flipfit.dao.GymAdminDAO;
import com.flipfit.dao.GymAdminDAOImpl;
import com.flipfit.exceptions.InvalidCredentialsException;
import com.flipfit.exceptions.ResourceNotFoundException;
import com.flipfit.exceptions.StatusUpdatedException;

import java.util.Scanner;
import java.util.*;

public class GymAdminBusinessImpl implements GymAdminBusiness {
    Scanner scanner = new Scanner(System.in);
    GymAdminDAO adminDAO = new GymAdminDAOImpl();

    public List<GymBooking> viewBookings() {
        try {
            return adminDAO.viewBookings();
        } catch (ResourceNotFoundException e) {
            System.out.println(e);
        }
        return new ArrayList();
    }

    public void approveOwnerRegistration(int requestId, String statuss) {
        try{
            adminDAO.approveOwnerRegistration(requestId, statuss);
        } catch (StatusUpdatedException e) {
            System.out.println(e);
        } catch (ResourceNotFoundException e) {
            System.out.println(e);
        }
    }

    public List<GymOwnerRequest> pendingRequests() {
        try{
            return adminDAO.pendingRequests();
        } catch (ResourceNotFoundException e) {
            System.out.println(e);
        }
        return new ArrayList();
    }

    public List<GymCenter> viewCenter() {
        try {
            return adminDAO.viewCenter();
        } catch (ResourceNotFoundException e) {
            System.out.println(e);
        }
        return new ArrayList();
    }

    @Override
    public boolean updatepwd(String email, String password, String role) {
        try{
            return adminDAO.updatepwd(email, password, role);
        } catch (InvalidCredentialsException e) {
            System.out.println(e);
        }
        return false;
    }

}

package com.flipfit.business;

import com.flipfit.bean.*;
import com.flipfit.dao.GymAdminDAO;
import com.flipfit.dao.GymAdminDAOImpl;

import java.util.Scanner;
import java.util.*;

public class GymAdminBusinessImpl implements GymAdminBusiness {
    Scanner scanner = new Scanner(System.in);
    GymAdminDAO adminDAO = new GymAdminDAOImpl();

    public List<GymBooking> viewBookings() {
        return adminDAO.viewBookings();
    }

    public void approveOwnerRegistration(int requestId, String statuss) {
        adminDAO.approveOwnerRegistration(requestId, statuss);
    }

    public List<GymOwnerRequest> pendingRequests() {
        return adminDAO.pendingRequests();
    }

    public List<GymCenter> viewCenter() {
        return adminDAO.viewCenter();
    }

    @Override
    public boolean updatepwd(String email, String password, String role) {
        return adminDAO.updatepwd(email, password, role);
    }

}

package com.flipfit.business;

import com.flipfit.bean.GymAdmin;
import com.flipfit.bean.GymCustomer;
import com.flipfit.bean.GymOwner;

import java.util.List;

public interface GymUserBusiness {
    public List<GymCustomer> viewAllCustomers();

    public List<GymOwner> viewAllGymOwners();

    public int login(String email, String password, String role);
}

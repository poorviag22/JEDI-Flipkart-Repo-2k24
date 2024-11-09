package com.flipfit.dao;

import com.flipfit.bean.GymCustomer;
import com.flipfit.bean.GymOwner;

import java.util.List;

public interface GymUserDAO {
    public List<GymCustomer> viewAllCustomers();
    public List<GymOwner> viewAllGymOwners();
    public int login(String email, String password, String role);
}

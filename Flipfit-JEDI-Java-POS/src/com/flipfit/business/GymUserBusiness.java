package com.flipfit.business;

import com.flipfit.bean.GymAdmin;
import com.flipfit.bean.GymCustomer;
import com.flipfit.bean.GymOwner;

public interface GymUserBusiness {
    public void registerUser();
    public String registerCustomer(GymCustomer customerDetails);
    public boolean getAdmin(int id);
    public boolean viewAllCustomers(int id);
    public boolean viewAllGymOwners(int id);
    public void authenticateUser();
    public void registerGymOwner(GymOwner gymOwner);
    public void registerGymAdmin(GymAdmin gymadmin);


}

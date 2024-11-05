package com.flipfit.business;

import com.flipfit.bean.Customer;

public interface UserBusiness {
    public String registerCustomer(Customer customerDetails);
    public boolean getAdmin(int id);
    public boolean viewAllCustomers(int id);
    public boolean viewAllGymOwners(int id);
    public void authenticateUser();
    public void registerGymOwner();
    public void registerUser();

}

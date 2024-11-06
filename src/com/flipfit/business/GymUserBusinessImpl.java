package com.flipfit.business;

import com.flipfit.bean.GymAdmin;
import com.flipfit.bean.GymCustomer;
import com.flipfit.bean.GymOwner;

public class GymUserBusinessImpl implements GymUserBusiness {
    public void registerUser(){

    }
    public String registerCustomer(GymCustomer customerDetails){
        return "";
    }
    public boolean getAdmin(int id){
        return true;
    }
    public boolean viewAllCustomers(int id){
        return true;
    }
    public boolean viewAllGymOwners(int id){
        return true;
    }
    public void authenticateUser(){

    }
    public void registerGymOwner(GymOwner gymOwner){

    }
    public void registerGymAdmin(GymAdmin gymadmin){

    }
}

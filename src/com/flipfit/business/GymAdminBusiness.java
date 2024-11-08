package com.flipfit.business;

public interface GymAdminBusiness {
public void viewBookings();
public void editProfile(int adminId);;
public void viewCustomers();
public void approveOwnerRegistration(int requestId, String statuss);
public void pendingRequests();
public void viewCenter();
public int login(String email, String password, String role);
public void updatepwd(String email, String password, String role);
}

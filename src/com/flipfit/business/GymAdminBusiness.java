package com.flipfit.business;

public interface GymAdminBusiness {
public void viewBookings();
public void editProfile();;
public void viewCustomers();
public void approveOwnerRegistration(int requestId, String statuss);
public void pendingRequests();
public void viewCenter();
}

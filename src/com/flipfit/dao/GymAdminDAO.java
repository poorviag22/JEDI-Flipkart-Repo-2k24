package com.flipfit.dao;

public interface GymAdminDAO
{



        public void viewBookings();
        public void editProfile(int id,String name,String email,String number,String pwd);;
        public void viewCustomers();
        public void approveOwnerRegistration(int requestId,String status);
        public void pendingRequests();
        public void viewCenter();
        public int login(String email, String password, String role);
        public void updatepwd(String email, String password, String role);

}

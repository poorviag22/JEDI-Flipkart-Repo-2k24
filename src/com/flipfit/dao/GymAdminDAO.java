package com.flipfit.dao;

public interface GymAdminDAO {



        public void viewBookings();
        public void editProfile();;
        public void viewCustomers();
        public void approveOwnerRegistration(int requestId,String status);
        public void pendingRequests();
        public void viewCenter();


}

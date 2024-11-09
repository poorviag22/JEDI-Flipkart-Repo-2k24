package com.flipfit.dao;

import com.flipfit.bean.*;

import java.util.*;

public interface GymAdminDAO {


        public List<GymBooking> viewBookings();

        public void approveOwnerRegistration(int requestId, String status);

        public List<GymOwnerRequest> pendingRequests();

        public List<GymCenter> viewCenter();

        public boolean updatepwd(String email, String password, String role);

}

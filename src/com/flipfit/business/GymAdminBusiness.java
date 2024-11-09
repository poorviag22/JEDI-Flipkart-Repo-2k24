package com.flipfit.business;

import com.flipfit.bean.*;

import java.util.*;

public interface GymAdminBusiness {
    public List<GymBooking> viewBookings();

    public void approveOwnerRegistration(int requestId, String statuss);

    public List<GymOwnerRequest> pendingRequests();

    public List<GymCenter> viewCenter();

    public boolean updatepwd(String email, String password, String role);
}

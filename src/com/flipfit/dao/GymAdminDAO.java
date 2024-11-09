package com.flipfit.dao;

import com.flipfit.bean.*;
import com.flipfit.exceptions.InvalidCredentialsException;
import com.flipfit.exceptions.ResourceNotFoundException;
import com.flipfit.exceptions.StatusUpdatedException;

import java.util.*;

public interface GymAdminDAO {


        public List<GymBooking> viewBookings() throws ResourceNotFoundException;

        public void approveOwnerRegistration(int requestId, String status) throws StatusUpdatedException, ResourceNotFoundException;

        public List<GymOwnerRequest> pendingRequests() throws ResourceNotFoundException;

        public List<GymCenter> viewCenter() throws ResourceNotFoundException;

        public boolean updatepwd(String email, String password, String role) throws InvalidCredentialsException;

}

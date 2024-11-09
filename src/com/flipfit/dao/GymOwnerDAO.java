package com.flipfit.dao;

import com.flipfit.bean.GymCustomer;
import com.flipfit.bean.GymOwner;
import com.flipfit.bean.GymSlots;
import com.flipfit.exceptions.DataEntryFailedException;
import com.flipfit.exceptions.InvalidCredentialsException;
import com.flipfit.exceptions.ResourceAlreadyExistsException;

import java.time.LocalDateTime;
import java.time.LocalTime;

public interface GymOwnerDAO {
    public boolean createProfile(GymOwner gymOwner) throws InvalidCredentialsException, DataEntryFailedException;

    public boolean registerCenter(int ownerId, String centerName, String location, int slots) throws DataEntryFailedException;

    public boolean addSlots(int centerID, GymSlots slot) throws ResourceAlreadyExistsException, DataEntryFailedException;

    public boolean deleteSlot(int centerID, LocalTime starttime) throws DataEntryFailedException;

    public boolean deleteCenter(int centerId) throws DataEntryFailedException;

    public boolean editProfile(GymOwner gymOwner) throws DataEntryFailedException;

    public boolean updatepwd(String email, String password, String role) throws InvalidCredentialsException;
}

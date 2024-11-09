package com.flipfit.business;

import com.flipfit.bean.GymCenter;
import com.flipfit.bean.GymOwner;
import com.flipfit.bean.GymSlots;
import com.flipfit.dao.GymAdminDAO;
import com.flipfit.dao.GymAdminDAOImpl;
import com.flipfit.dao.GymOwnerDAO;
import com.flipfit.dao.GymOwnerDAOImpl;
import com.flipfit.exceptions.DataEntryFailedException;
import com.flipfit.exceptions.InvalidCredentialsException;
import com.flipfit.exceptions.ResourceAlreadyExistsException;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Scanner;

public class GymOwnerBusinessImpl implements GymOwnerBusiness
{
    Scanner scanner = new Scanner(System.in);
    GymOwnerDAO ownerDAO = new GymOwnerDAOImpl();

    @Override
    public boolean registerCenter(int ownerId, String centerName,String location,int slots)
    {
        try{
            return ownerDAO.registerCenter(ownerId, centerName,location,slots);
        } catch (DataEntryFailedException e) {
            System.out.println(e);
        }
        return false;
    }
    @Override
    public boolean addnewSlot(int centerId, GymSlots slot){
        try{
            ownerDAO.addSlots(centerId, slot);
        } catch (ResourceAlreadyExistsException e) {
            System.out.println(e);
        } catch (DataEntryFailedException e) {
            System.out.println(e);
        }
        return false;
    }
    @Override
    public boolean deleteSlot(int centerId, LocalTime startTime){
        try{
            return ownerDAO.deleteSlot(centerId, startTime);
        } catch (DataEntryFailedException e) {
            System.out.println(e);
        }
        return false;
    }
    @Override
    public boolean deleteCenter(int centerId){
        try {
            return ownerDAO.deleteCenter(centerId);
        } catch (DataEntryFailedException e) {
            System.out.println(e);
        }
        return false;
    }
    @Override
    public boolean editProfile(GymOwner owner)
    {
        try {
            return ownerDAO.editProfile(owner);
        } catch (DataEntryFailedException e) {
            System.out.println(e);
        }
        return false;
    }

    @Override
    public boolean createProfile(GymOwner owner) {
        try{
            return ownerDAO.createProfile(owner);
        } catch (DataEntryFailedException e) {
            System.out.println(e);
        } catch (InvalidCredentialsException e){
            System.out.println(e);
        }
        return false;
    }

    @Override
    public boolean updatepwd(String email, String password, String role) {
        try {
            return ownerDAO.updatepwd(email, password, role);
        } catch (InvalidCredentialsException e) {
            System.out.println(e);
        }
        return false;
    }
}

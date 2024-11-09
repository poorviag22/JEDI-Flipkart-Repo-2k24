package com.flipfit.business;

import com.flipfit.bean.GymCenter;
import com.flipfit.bean.GymOwner;
import com.flipfit.bean.GymSlots;
import com.flipfit.dao.GymAdminDAO;
import com.flipfit.dao.GymAdminDAOImpl;
import com.flipfit.dao.GymOwnerDAO;
import com.flipfit.dao.GymOwnerDAOImpl;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Scanner;

public class GymOwnerBusinessImpl implements GymOwnerBusiness
{
    Scanner scanner = new Scanner(System.in);
    GymOwnerDAO ownerDAO = new GymOwnerDAOImpl();

    @Override
    public void registerCenter(int ownerId, String centerName,String location,int slots)
    {
      ownerDAO.registerCenter(ownerId, centerName,location,slots);
    }
    @Override
    public void addnewSlot(int centerId, GymSlots slot){
      ownerDAO.addSlots(centerId, slot);
    }
    @Override
    public void deleteSlot(int centerId, LocalTime startTime){
        ownerDAO.deleteSlot(centerId, startTime);
    }
    @Override
    public void deleteCenter(int centerId){
        ownerDAO.deleteCenter(centerId);
    }
    @Override
    public void editProfile(GymOwner owner)
    {
        ownerDAO.editProfile(owner);
    }

    @Override
    public boolean createProfile(GymOwner owner) {
        return ownerDAO.createProfile(owner);
    }

    @Override
    public boolean updatepwd(String email, String password, String role) {
        return ownerDAO.updatepwd(email, password, role);
    }
}

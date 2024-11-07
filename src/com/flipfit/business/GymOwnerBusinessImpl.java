package com.flipfit.business;

import com.flipfit.bean.GymCenter;
import com.flipfit.bean.GymSlots;
import com.flipfit.dao.GymAdminDAO;
import com.flipfit.dao.GymAdminDAOImpl;
import com.flipfit.dao.GymOwnerDAO;
import com.flipfit.dao.GymOwnerDAOImpl;

import java.util.Scanner;

public class GymOwnerBusinessImpl implements GymOwnerBusiness
{
    Scanner scanner = new Scanner(System.in);
    GymOwnerDAO ownerDAO = new GymOwnerDAOImpl();


    public void registerCenter(int ownerId)
    {
      System.out.println("Registering Gym Center...");
        System.out.println("Enter your CenterName");
        String centerName = scanner.next();

        System.out.println("Enter your Center Location");
        String location = scanner.next();

        System.out.println("Enter No Of Slots In Center");
        int slots = scanner.nextInt();

      int requestId = (int) Math.random()*100;
      ownerDAO.registerCenter(requestId,centerName,location,slots);
    }




    public void addnewSlot(){
      System.out.println("Adding new slot...");
    }
    public void deleteSlot(){
     System.out.println("Deleting slot...");
    }
    public void deleteCenter(){
  System.out.println("Deleting center...");
    }
    public void editProfile()
    {
      System.out.println("Editing profile...");
    }
    public void viewReport()
    {
System.out.println("Viewing report...");
    }
}

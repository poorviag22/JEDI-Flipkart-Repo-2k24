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


    public void registerCenter(int ownerId)
    {
      System.out.println("Registering Gym Center...");
        System.out.println("Enter your CenterName");
        String centerName = scanner.next();

        System.out.println("Enter your Center Location");
        String location = scanner.next();

        System.out.println("Enter No Of Slots In Center");
        int slots = scanner.nextInt();

      ownerDAO.registerCenter(ownerId, centerName,location,slots);
    }

    public void addnewSlot(){
      System.out.println("Adding new slot...");
      System.out.println("Enter your CenterId:");
      int centerId = scanner.nextInt();
      System.out.println("Enter your StartTime as HH:MM:SS in 24-Hour Format");
        LocalTime startTime= LocalTime.parse(scanner.next());
      System.out.println("Enter your StartTime as HH:MM:SS in 24-Hour Format");
      LocalTime endTime = LocalTime.parse(scanner.next());
      System.out.println("Enter Number of Seats:");
      int seats = scanner.nextInt();
      System.out.println("Enter Cost:");
      int cost = scanner.nextInt();
      GymSlots slot = new GymSlots(centerId, startTime, endTime, seats, cost);
      ownerDAO.addSlots(centerId, slot);
    }
    public void deleteSlot(){
        System.out.println("Deleting slot...");
        System.out.println("Enter your CenterId:");
        int centerId = scanner.nextInt();
        System.out.println("Enter your StartTime as HH:MM:SS in 24-Hour Format");
        LocalTime startTime= LocalTime.parse(scanner.next());
        ownerDAO.deleteSlot(centerId, startTime);
    }
    public void deleteCenter(){
        System.out.println("Deleting center...");
        java.util.Scanner in = new java.util.Scanner(System.in);
        System.out.println("Enter the center ID to be deleted: ");
        int centerId = in.nextInt();
        ownerDAO.deleteCenter(centerId);
    }
    public void editProfile(int ownerId)
    {
        java.util.Scanner in = new java.util.Scanner(System.in);
        System.out.println("Editing profile...");
        System.out.println("Enter your new name");
        String name = in.nextLine();
        System.out.println("Enter your new email");
        String email = in.nextLine();
        System.out.println("Enter your new password");
        String password = in.nextLine();
        System.out.println("Enter your new Address");
        String address = in.nextLine();
        System.out.println("Enter your new Contact Number");
        String contactNumber = in.nextLine();
        GymOwner owner = new GymOwner(name, email, contactNumber, address, password);
        owner.setOwnerId(ownerId);
        ownerDAO.editProfile(owner);
    }
    public void viewReport()
    {
System.out.println("Viewing report...");
    }

    @Override
    public void createProfile(GymOwner owner) {
        ownerDAO.createProfile(owner);
    }

    @Override
    public int login(String email, String password, String role) {
        return ownerDAO.login(email, password, role);
    }

    @Override
    public void updatepwd(String email, String password, String role) {
        ownerDAO.updatepwd(email, password, role);
    }
}

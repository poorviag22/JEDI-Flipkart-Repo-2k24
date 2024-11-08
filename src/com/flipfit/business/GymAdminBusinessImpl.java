package com.flipfit.business;

import com.flipfit.dao.GymAdminDAO;
import com.flipfit.dao.GymAdminDAOImpl;

import java.util.Scanner;

public class GymAdminBusinessImpl implements GymAdminBusiness {
    Scanner scanner = new Scanner(System.in);
    GymAdminDAO adminDAO = new GymAdminDAOImpl();
    public void viewBookings(){
         System.out.println("Bookings: ");
         adminDAO.viewBookings();
    }
    public void editProfile(){

        System.out.println("Enter your Registered ID");
        int id = scanner.nextInt();

        System.out.println("Enter your UserName");
        String userName = scanner.next();

        System.out.println("Enter your Email");
        String email = scanner.next();

        System.out.println("Enter your Phone Number");
        String phoneNumber = scanner.next();

        System.out.println("Enter your Password");
        String pwd = scanner.next();

        adminDAO.editProfile(id,userName, email,phoneNumber,pwd);
    }
    public void viewCustomers(){
      System.out.println("Customers Details: ");
      adminDAO.viewCustomers();
    }
    public void approveOwnerRegistration(int requestId,String statuss)
    {
        adminDAO.approveOwnerRegistration(requestId,statuss);
    }

    public void pendingRequests()
    {

        System.out.println("Pending Requests: ");
        adminDAO.pendingRequests();
    }
    public void viewCenter()
    {
        adminDAO.viewCenter();
    }

}

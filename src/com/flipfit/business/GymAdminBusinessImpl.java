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
    public void editProfile(int id){
        System.out.println("Enter your Name: ");
        String name = scanner.nextLine();

        System.out.println("Enter your New Email");
        String email = scanner.next();

        System.out.println("Enter your New Phone Number");
        String phoneNumber = scanner.next();

        System.out.println("Enter your New Password");
        String pwd = scanner.next();

        adminDAO.editProfile(id,name,email,phoneNumber,pwd);
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

    @Override
    public int login(String email, String password, String role) {
        return adminDAO.login(email, password, role);
    }

    @Override
    public void updatepwd(String email, String password, String role) {
        adminDAO.updatepwd(email, password, role);
    }

}

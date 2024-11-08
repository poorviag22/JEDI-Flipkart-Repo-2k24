package com.flipfit.Application;

import com.flipfit.business.*;
import com.flipfit.utils.DBConnection;

import java.sql.Connection;
import java.sql.SQLException;

public class FlipfitApplication
{
       public static void login()
         {
              java.util.Scanner in = new java.util.Scanner(System.in);
                System.out.println("Enter the Email Address :---");
                in = new java.util.Scanner(System.in);
                 String email=in.nextLine();
                System.out.println("Enter the Password :----");
                in = new java.util.Scanner(System.in);
                String pwd=in.nextLine();
                System.out.println("Enter the ROLE: (GymCustomer/GymOwner/GymAdmin)");
                in = new java.util.Scanner(System.in);
                String role=in.nextLine().toLowerCase();
              if(role.equals("gymadmin"))
              {
                  GymAdminBusiness adminBusiness = new GymAdminBusinessImpl();
                  int adminId = adminBusiness.login(email, pwd, role);
                  if(adminId == -1){
                      System.out.println("Login Failed, Check your Credentials Again !!");
                  } else {
                      GymAdminFlipfitmenu admin=new GymAdminFlipfitmenu();
                      admin.gymadminmenu(adminId);
                  }
              }
              if(role.equals("gymcustomer"))
              {
                  GymCustomerBusiness customerBusiness = new GymCustomerBusinessImpl();
                  int custId = customerBusiness.login(email, pwd, role);
                  if(custId == -1){
                      System.out.println("Login Failed, Check Your Credentials Again !!");
                  } else {
                      GymCustomerFlipfitmenu customer=new GymCustomerFlipfitmenu();
                      customer.gymcustomermenu(custId);
                  }
              }
              if(role.equals("gymowner"))
              {
                  GymOwnerBusiness ownerBusiness = new GymOwnerBusinessImpl();
                  int ownerId = ownerBusiness.login(email, pwd, role);
                  if(ownerId == -1){
                      System.out.println("Login Failed, Check Your Credentials Again !!");
                  } else {
                      GymOwnerFlipfitmenu owner = new GymOwnerFlipfitmenu();
                      owner.gymownermenu(ownerId);
                  }

              }

         }
         public static void registration(int choice)
         {
             if(choice==2)
             {
                 GymCustomerFlipfitmenu customer=new GymCustomerFlipfitmenu();
                 customer.register();
             }
             if(choice==3)
             {
                 GymOwnerFlipfitmenu own=new GymOwnerFlipfitmenu();
                 own.register();
             }
         }
         public static void updatepwd()
         {
             java.util.Scanner in = new java.util.Scanner(System.in);
             System.out.println("Enter the Email Address :---");
             String email=in.nextLine();
             System.out.println("Enter the New Password :---");
             String pwd=in.nextLine();
             System.out.println("Enter Your Role :---");
             String role=in.nextLine().toLowerCase();
             if(role.equals("gymadmin"))
             {
                 GymAdminBusiness adminBusiness = new GymAdminBusinessImpl();
                 adminBusiness.updatepwd(email, pwd, role);
             }
             if(role.equals("gymcustomer"))
             {
                 GymCustomerBusiness customerBusiness = new GymCustomerBusinessImpl();
                 customerBusiness.updatepwd(email, pwd, role);
             }
             if(role.equals("gymowner"))
             {
                 GymOwnerBusiness ownerBusiness = new GymOwnerBusinessImpl();
                 ownerBusiness.updatepwd(email, pwd, role);

             }
             //System.out.println("Password Updated Successfully : "+ pwd);

         }
     public static void main(String agrs[])
     {


    int choice;
     while(true)
     {
         System.out.println("Welcome to FlipFit Application");
        java.util.Scanner in = new java.util.Scanner(System.in);
		System.out.println("1. Login");
        System.out.println("2. Registration for GymCustomer");
        System.out.println("3. Registration for GymOwner");
        System.out.println("4. Update Password");
        System.out.println("5. Exit");

        choice = in.nextInt();
	    if(choice==1)
            {
                login();
            }
        if(choice==2||choice==3)
        {
            registration(choice);
        }
        if(choice==4) {
            updatepwd();
        }
         if(choice==5)
             break;
        }
}





}

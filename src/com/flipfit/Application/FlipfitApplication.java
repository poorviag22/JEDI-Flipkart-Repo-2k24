package com.flipfit.Application;

import com.flipfit.exception.DBconnectionException;
import com.flipfit.utils.DBConnection;

import java.sql.Connection;
import java.sql.SQLException;

public class FlipfitApplication
{
       public static void login()
         {
              java.util.Scanner in = new java.util.Scanner(System.in);
                System.out.println("Enter the User Name :---");
                in = new java.util.Scanner(System.in);
                 String name=in.nextLine();
                System.out.println("Enter the Password :----");
                in = new java.util.Scanner(System.in);
                String pwd=in.nextLine();
                System.out.println("Enter the ROLE: (GymCustomer/GymOwner/GymAdmin)");
                in = new java.util.Scanner(System.in);
                String role=in.nextLine().toLowerCase();

              if(role.equals("admin"))
              {
                    GymAdminFlipfitmenu admin=new GymAdminFlipfitmenu();
                    admin.gymadminmenu();
              }
              if(role.equals("user"))
              {
                  GymCustomerFlipfitmenu customer=new GymCustomerFlipfitmenu();
                  int id=0;//after authentication
                  customer.gymcustomermenu(id);
              }
              if(role.equals("owner"))
              {
                GymOwnerFlipfitmenu owner=new GymOwnerFlipfitmenu();
                owner.gymownermenu();

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
             System.out.println("Enter the New Password :---");
             java.util.Scanner in = new java.util.Scanner(System.in);
             String pwd=in.nextLine();
             System.out.println("Password Updated Successfully : "+ pwd);

         }
     public static void main(String agrs[]) throws SQLException, DBconnectionException {

           Connection conn = null;
           conn = DBConnection.connect();

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

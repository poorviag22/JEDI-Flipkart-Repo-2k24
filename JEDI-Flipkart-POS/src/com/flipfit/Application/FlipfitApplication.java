package com.flipfit.Application;

import com.flipfit.Application.GymAdminFlipfitmenu;
import com.flipfit.Application.GymCustomerFlipfitmenu;
import com.flipfit.Application.GymOwnerFlipfitmenu;
import com.flipfit.business.*;
import com.flipfit.exceptions.DBConnectionException;
import com.flipfit.exceptions.InvalidCredentialsException;

import java.sql.Connection;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class FlipfitApplication {
      /**
     * This method handles the login functionality for the FlipFit application.
     * It prompts the user for their email, password, and role (GymAdmin, GymCustomer, GymOwner),
     * and performs the login operation based on the provided role. 
     * It then redirects the user to the respective menu (GymAdmin, GymCustomer, or GymOwner) 
     * if the login is successful. 
     * If the login fails, it shows an error message.
     */
    public static void login() {
        java.util.Scanner in = new java.util.Scanner(System.in);
        System.out.println("Enter the Email Address :---");
        in = new java.util.Scanner(System.in);
        String email = in.nextLine();
        System.out.println("Enter the Password :----");
        in = new java.util.Scanner(System.in);
        String pwd = in.nextLine();
        System.out.println("Enter the ROLE: (GymCustomer/GymOwner/GymAdmin)");
        in = new java.util.Scanner(System.in);
        String role = in.nextLine().toLowerCase();
        GymUserBusiness userBusiness = new GymUserBusinessImpl();
        if (role.equals("gymadmin")) {
            int adminId = userBusiness.login(email, pwd, role);
            if (adminId != -1) {
                GymAdminFlipfitmenu admin = new GymAdminFlipfitmenu();
                admin.gymadminmenu(adminId);
            }
        }
        else if (role.equals("gymcustomer")) {
            int custId = userBusiness.login(email, pwd, role);
            if (custId != -1) {
                GymCustomerFlipfitmenu customer = new GymCustomerFlipfitmenu();
                customer.gymcustomermenu(custId);
            }
        }
        else if (role.equals("gymowner")) {
            int ownerId = userBusiness.login(email, pwd, role);
            if (ownerId != -1) {
                GymOwnerFlipfitmenu owner = new GymOwnerFlipfitmenu();
                owner.gymownermenu(ownerId);
            }
        } else {
            System.out.println("Invalid role, try again");
        }
    }
  /**
     * This method handles user registration based on the user's choice.
     * If the choice is 2, it registers a GymCustomer by invoking the appropriate registration method.
     * If the choice is 3, it registers a GymOwner by invoking the respective registration method.
     */
    public static void registration(int choice) {
        if (choice == 2) {
            GymCustomerFlipfitmenu customer = new GymCustomerFlipfitmenu();
            customer.register();
        }
        if (choice == 3) {
            GymOwnerFlipfitmenu own = new GymOwnerFlipfitmenu();
            own.register();
        }
    }
    /**
     * This method allows the user to update their password.
     * It prompts the user for their email, new password, and role.
     * Based on the role, it calls the appropriate business logic to update the password in the database.
     * If the update is successful, a success message is displayed; otherwise, an error message is shown.
     */

    public static void updatepwd() {
        java.util.Scanner in = new java.util.Scanner(System.in);
        System.out.println("Enter the Email Address :---");
        String email = in.nextLine();
        System.out.println("Enter the New Password :---");
        String pwd = in.nextLine();
        System.out.println("Enter Your Role :---");
        String role = in.nextLine().toLowerCase();
        if (role.equals("gymadmin")) {
            GymAdminBusiness adminBusiness = new GymAdminBusinessImpl();
            if(!adminBusiness.updatepwd(email, pwd, role)){
                System.out.println("Update Failed, Check Your Credentials Again !!");
            } else {
                System.out.println("Password Update Successful");
            }
        }
        else if (role.equals("gymcustomer")) {
            GymCustomerBusiness customerBusiness = new GymCustomerBusinessImpl();
            if(!customerBusiness.updatepwd(email, pwd, role)){
                System.out.println("Update Failed, Check Your Credentials Again !!");
            } else {
                System.out.println("Password Update Successful");
            }
        }
        else if (role.equals("gymowner")) {
            GymOwnerBusiness ownerBusiness = new GymOwnerBusinessImpl();
            if(!ownerBusiness.updatepwd(email, pwd, role)){
                System.out.println("Update Failed, Check Your Credentials Again !!");
            } else {
                System.out.println("Password Update Successful");
            }
        } else {
            System.out.println("Invalid Role, Try Again");
        }
    }

//main function

    public static void main(String agrs[]) {


        int choice;
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        System.out.println("Current Date and Time: " + dtf.format(now));

        while (true) {
            System.out.println("Welcome to FlipFit Application");
            System.out.println("------------------------------------------------------------------------------------------------");
            java.util.Scanner in = new java.util.Scanner(System.in);
            System.out.println("1. Login");
            System.out.println("2. Registration for GymCustomer");
            System.out.println("3. Registration for GymOwner");
            System.out.println("4. Update Password");
            System.out.println("5. Exit");
            System.out.println("------------------------------------------------------------------------------------------------");

            choice = in.nextInt();
            if (choice == 1) {
                login();
            }
            else if (choice == 2 || choice == 3) {
                registration(choice);
            }
            else if (choice == 4) {
                updatepwd();
            }
            else if (choice == 5)
                break;
            else
                System.out.println("Invalid Choice Try Again");
        }
    }
}

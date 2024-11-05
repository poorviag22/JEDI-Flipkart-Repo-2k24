package com.flipfit.Application;

import java.util.Scanner;

public class GymRegistration {
    public static void mainPage() {

    System.out.println("Welcome to FlipFit Application");

    Scanner in = new Scanner(System.in);
		System.out.println("1. Admin");
        System.out.println("2. Owner");
        System.out.println("3. Customer");
        System.out.print("Enter your choice: ");
        int role = in.nextInt();

	    if(role==1)
            System.out.println("Welcome to Admin Menu");

        else if (role==2)
            System.out.println("Welcome to Owner Menu");

         else if (role==3)
         {
            System.out.println("Welcome to Customer Menu");

            System.out.println("1. Register");
            System.out.println("2. Login");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            int choice = in.nextInt();

            }
        }
    }


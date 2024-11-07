package com.flipfit.Application;

public class GymOwnerFlipfitmenu {
    com.flipfit.business.GymOwnerBusiness service =new com.flipfit.business.GymOwnerBusinessImpl();
    public void gymownermenu()
    {

        while(true)
       {System.out.println("Welcome to FlipFit Owner Menu");
        java.util.Scanner in = new java.util.Scanner(System.in);
		System.out.println("1. Register Center");
        System.out.println("2. Add New Slot");
        System.out.println("3. Delete Slot");
        System.out.println("4. Delete Center");
        System.out.println("5. Edit Profile");
        System.out.println("6. View Report");
        System.out.println("7. Exit");

        int choice = in.nextInt();
	    if(choice==1) {
            System.out.println("Enter Owner ID");
            int id = in.nextInt();
            service.registerCenter(id);
        }
        if(choice==2) {
            service.addnewSlot();
        }
        if(choice==3) {
          service.deleteSlot();
        }
       if(choice==4)
       {
           service.deleteCenter();
       }
         if(choice==5) {
             service.editProfile();
         }
         if(choice==6) {
             service.viewReport();
         }
        if(choice==7)
          break;
    }

    }
    public void register()
    {
        java.util.Scanner in = new java.util.Scanner(System.in);
        System.out.println("Registering Gym Owner Menu");
        System.out.println("Enter your name");
        String name = in.nextLine();
        System.out.println("Enter your email");
        String email = in.nextLine();
        System.out.println("Enter your password");
        String password = in.nextLine();
        System.out.println("Enter your Contact Number");
        String contactNumber = in.nextLine();
        //saving details into db


       System.out.println("Registered Successfully!!");

    }
}

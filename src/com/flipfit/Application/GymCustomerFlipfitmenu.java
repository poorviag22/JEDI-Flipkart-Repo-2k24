package com.flipfit.Application;

public class GymCustomerFlipfitmenu
{
    int currentcustId;
    com.flipfit.business.GymCustomerBusiness service =new com.flipfit.business.GymCustomerBusinessImpl();
    com.flipfit.business.GymAdminBusiness ser =new com.flipfit.business.GymAdminBusinessImpl();
      public void register()
    {
        java.util.Scanner in = new java.util.Scanner(System.in);
        System.out.println("Registering Gym Customer Menu");
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
    public void gymcustomermenu(int custId)
    {
        currentcustId = custId;
      System.out.println("Welcome to FlipFit Customer Menu");

      while(true)
       {
        java.util.Scanner in = new java.util.Scanner(System.in);
		System.out.println("1. View My Bookings");
        System.out.println("2. View GymCenter");
        System.out.println("3. Modify Booking");
        System.out.println("4. Cancel Booking");
        System.out.println("5. Check Waitlist Status");
        System.out.println("6. Make Payment");
        System.out.println("7. Exit");

        int choice = in.nextInt();
	    if(choice==1) {
            service.viewBookings(currentcustId);
        }
        if(choice==2) {
            ser.viewCenter();
        }
        if(choice==3) {
            boolean status = service.modifyBooking(currentcustId);
        }
       if(choice==4)
       {
           boolean status = service.cancelBooking(currentcustId);
       }
         if(choice==5) {
             boolean waitlist = service.waitlistStatus(currentcustId);
         }
         if(choice==6) {
             service.makepayment(currentcustId);
         }
        if(choice==7)
          break;
    }

}
}

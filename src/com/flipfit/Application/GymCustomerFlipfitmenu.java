package com.flipfit.Application;

import com.flipfit.bean.GymCustomer;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

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
        System.out.println("Enter your Address");
        String address = in.nextLine();
        System.out.println("Enter your password");
        String password = in.nextLine();
        System.out.println("Enter your Contact Number");
        String contactNumber = in.nextLine();
        //saving details into db
        GymCustomer customer = new GymCustomer(name,address,email,contactNumber,password);
        service.createProfile(customer);

       System.out.println("Registered Successfully!!");

    }
    public void gymcustomermenu(int custId)
    {
        currentcustId = custId;
        System.out.println("Customer ID is " + currentcustId);
      System.out.println("Welcome to FlipFit Customer Menu");

      while(true)
       {
        java.util.Scanner in = new java.util.Scanner(System.in);
		System.out.println("1. View My Bookings");
        System.out.println("2. View GymCenter/Book a Slot");
        System.out.println("3. Modify Booking"); //to be removed
        System.out.println("4. Cancel Booking");
        System.out.println("5. Check Waitlist Status"); //?
           System.out.println("6. Make Payment");//to be removed
        System.out.println("7. Edit Profile");
        System.out.println("8. Exit");

        int choice = in.nextInt();
	    if(choice==1) {
            service.viewBookings(currentcustId);
        }
        if(choice==2) {
            ser.viewCenter();
            System.out.println("Enter a date (dd/mm/yyyy): ");
            in = new java.util.Scanner(System.in);
            String dateStr = in.nextLine();
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            try{
                Date date = sdf.parse(dateStr);
                System.out.println("Date you entered is : " + date.toString());
                System.out.println("Enter the centre ID to select a slot for booking");
                int centerId = in.nextInt();
                service.viewSlots(centerId, date);
                System.out.println("select a slot Id for booking");
                int slotId = in.nextInt();
                int bookingId = service.createBooking(currentcustId, slotId, centerId, date);
                System.out.println("Type Payment Option as one of below without spaces:");
                System.out.println("1. CreditCard");
                System.out.println("2. DebitCard");
                System.out.println("3. UPI"); //to be removed
                System.out.println("4. Netbanking");
                in = new java.util.Scanner(System.in);
                String mode = in.nextLine().toLowerCase();
                int paymentId = service.makepayment(bookingId, mode);
                System.out.println("PaymentId = " + paymentId + "|| BookingId = " + bookingId);
            } catch (ParseException e) {
                e.printStackTrace();
            }
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
             //service.makepayment();
         }
         if(choice==7) {
             service.editProfile(currentcustId);
         }
        if(choice==8)
          break;
    }

}
}

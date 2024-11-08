package com.flipfit.Application;

public class GymAdminFlipfitmenu {
    com.flipfit.business.GymAdminBusiness service =new com.flipfit.business.GymAdminBusinessImpl();
    int currentAdminId = 0;
    public void gymadminmenu(int adminId)
      {
           System.out.println("Welcome to FlipFit Admin Menu");
           currentAdminId = adminId;
      while(true)
       {
        java.util.Scanner in = new java.util.Scanner(System.in);
		System.out.println("1. View All Bookings");
        System.out.println("2. View All Customers");
        System.out.println("3. Edit Profile"); //to be removed
        System.out.println("4. See Pending Requests");
        System.out.println("5. Approve Requests");
        System.out.println("6. Exit");

        int choice = in.nextInt();
	    if(choice==1) {
            service.viewBookings();
        }
        if(choice==2) {
            service.viewCustomers();
        }
        if(choice==3) {

            service.editProfile(adminId);
        }
       if(choice==4)
       {
          service.pendingRequests();
       }
         if(choice==5) {
             java.util.Scanner scanner = new java.util.Scanner(System.in);
             System.out.println("Provide Your Request ID for approving/rejecting");
             int requestId=scanner.nextInt();
             System.out.println("Select Choice : approved/rejected");
             String statuss=scanner.next();
             service.approveOwnerRegistration(requestId,statuss);
         }
        if(choice==6)
          break;
    }

}



}

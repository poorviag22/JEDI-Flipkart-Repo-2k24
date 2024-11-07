package com.flipfit.business;

public class GymAdminBusinessImpl implements GymAdminBusiness {

    public void viewBookings(){
         System.out.println("Bookings: ");
    }
    public void editProfile(){
        System.out.println("Enter your UserName");
        String userName = scanner.next();

        System.out.println("Enter your Passkey");
        String password = scanner.next();

        System.out.println("Enter your Email");
        String email = scanner.next();

        System.out.println("Enter your Phone Number");
        String phoneNumber = scanner.next();

        System.out.println("Enter your Card Number");
        String cardNumber = scanner.next();

        return customerDAO.registerCustomer(userName, password, email, phoneNumber, cardNumber);
    }
    public void viewCustomers(){
      System.out.println("Customers Details: ");
    }
    public void approveOwnerRegistration(){
      System.out.println("Owner Registration Approved: ");
    }

    public void pendingRequests()
{
System.out.println("Pending Requests: ");
}
public void viewCenter()
{

}

}

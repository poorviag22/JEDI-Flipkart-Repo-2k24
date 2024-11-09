package com.flipfit.Application;

import com.flipfit.bean.GymBooking;
import com.flipfit.bean.GymCustomer;
import com.flipfit.bean.GymOwner;
import com.flipfit.bean.GymOwnerRequest;
import com.flipfit.business.GymAdminBusiness;
import com.flipfit.business.GymAdminBusinessImpl;
import com.flipfit.business.GymUserBusiness;
import com.flipfit.business.GymUserBusinessImpl;

import java.util.*;

public class GymAdminFlipfitmenu {
    GymAdminBusiness service = new GymAdminBusinessImpl();
    GymUserBusiness userService = new GymUserBusinessImpl();
    int currentAdminId = 0;

    public void gymadminmenu(int adminId) {
        System.out.println("Welcome to FlipFit Admin Menu");
        currentAdminId = adminId;
        while (true) {
            java.util.Scanner in = new java.util.Scanner(System.in);
            System.out.println("1. View All Bookings");
            System.out.println("2. View All Customers");
            System.out.println("3. View All Owners");
            System.out.println("4. See Pending Requests");
            System.out.println("5. Approve Requests");
            System.out.println("6. Exit");

            int choice = in.nextInt();
            if (choice == 1) {
                List<GymBooking> list = service.viewBookings();
                if (list.isEmpty()) {
                    System.out.println("No bookings found");
                } else {
                    System.out.println("BookingId CenterName CenterLocation StartTime EndTime Date");
                    for (GymBooking booking : list) {
                        System.out.println(booking.getBookingId() + " " + booking.getCenterName() + " " + booking.getStartTime().toString() + " " + booking.getEndTime().toString() + " " + booking.getBookingDate());
                    }
                }

            }
            else if (choice == 2) {
                List<GymCustomer> list = userService.viewAllCustomers();
                if (list.isEmpty()) {
                    System.out.println("No customers found");
                } else {
                    System.out.println("CustomerId CustomerName CustomerEmail CustomerAddress CustomerPhone");
                    for (GymCustomer customer : list) {
                        System.out.println(customer.getCustomerId() + " " + customer.getCustomerName() + " " + customer.getCustomerEmailAddress() + " " + customer.getCustomerAddress() + " " + customer.getCustomerPhone());
                    }
                }
            }
            else if (choice == 3) {
                List<GymOwner> list = userService.viewAllGymOwners();
                if (list.isEmpty()) {
                    System.out.println("No owners found");
                } else {
                    System.out.println("OwnerId OwnerName OwnerEmail OwnerAddress OwnerPhone");
                    for (GymOwner owner : list) {
                        System.out.println(owner.getOwnerId() + " " + owner.getOwnerName() + " " + owner.getOwnerEmailAddress() + " " + owner.getOwnerAddress() + " " + owner.getOwnerPhone());
                    }
                }
            }
            else if (choice == 4) {
                List<GymOwnerRequest> requests = service.pendingRequests();
                if (requests.isEmpty()) {
                    System.out.println("No pending requests found");
                } else {
                    System.out.println("RequestId OwnerId Status CenterName CenterLocation NumOfSlots");
                    for (GymOwnerRequest request : requests) {
                        System.out.println(request.getOwnerId() + " " + request.getRequestId() + " " + request.getStatus() + " " + request.getCenterName() + " " + request.getCenterLocation() + " " + request.getNumOfSlots());
                    }
                }
            }
            else if (choice == 5) {
                java.util.Scanner scanner = new java.util.Scanner(System.in);
                System.out.println("Provide Your Request ID for approving/rejecting");
                int requestId = scanner.nextInt();
                System.out.println("Select Choice : approved/rejected");
                String statuss = scanner.next();
                service.approveOwnerRegistration(requestId, statuss);
            }
            else if (choice == 6)
                break;
            else {
                System.out.println("Invalid choice, Try Again");
            }
        }

    }


}

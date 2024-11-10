package com.flipfit.Application;

import com.flipfit.bean.GymBooking;
import com.flipfit.bean.GymCenter;
import com.flipfit.bean.GymCustomer;
import com.flipfit.bean.GymSlots;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.time.*;
import java.util.List;
import java.util.Scanner;

import com.flipfit.business.*;


public class GymCustomerFlipfitmenu {
    int currentcustId;
    GymCustomerBusiness service = new GymCustomerBusinessImpl();
    GymCenterBusiness centerBusiness = new GymCenterBusinessImpl();
    GymAdminBusiness ser = new GymAdminBusinessImpl();

    public void register() {
        java.util.Scanner in = new java.util.Scanner(System.in);
        System.out.println("------------------------------------------------------------------------------------------------");
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
        GymCustomer customer = new GymCustomer(name, address, email, contactNumber, password);
        if(service.createProfile(customer)){
            System.out.println("Registered Successfully!!");
        } else {
            System.out.println("User already exists with this emailID!!");
        }
    }

    public void gymcustomermenu(int custId) {
        currentcustId = custId;
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        System.out.println("Current Date and Time: " + dtf.format(now));

        while (true) {
            System.out.println("Customer ID:" + currentcustId);
            System.out.println("Welcome to FlipFit Customer Menu");
            System.out.println("------------------------------------------------------------------------------------------------");
            java.util.Scanner in = new java.util.Scanner(System.in);
            System.out.println("1. View My Bookings");
            System.out.println("2. View GymCenter/Book a Slot");
            System.out.println("3. Cancel Booking");
            System.out.println("4. Edit Profile");
            System.out.println("5. Exit");

            int choice = in.nextInt();
            if (choice == 1) {
                List<GymBooking> list = service.viewBookings(currentcustId);
                if(!list.isEmpty()){
                    System.out.println("------------------------------------------------------------------------------------------------");
                    System.out.printf("%-15s %-15s %-20s %-25s %-20s %-15s%n",
                            "BookingId", "CenterName","CenterLocation","StartTime","EndTime","Date");
                    for (GymBooking booking : list) {
                        System.out.printf("%-15s %-15s %-20s %-25s %-20s %-15s%n",
                                booking.getBookingId(), booking.getCenterName(), booking.getCenterLocation() , booking.getStartTime().toString(),booking.getEndTime().toString() , booking.getBookingDate());
                    }
                }
            }
            else if (choice == 2) {
                List<GymCenter> list = ser.viewCenter();
                if(list.size() == 0){
                    continue;
                }
                System.out.println("------------------------------------------------------------------------------------------------");
                System.out.printf("%-15s %-15s %-20s %-25s %-30s%n","CenterId"," OwnerId","CenterName"," CenterLocation"," NumOfSlots");
                for (GymCenter center : list) {
                    System.out.printf("%-15s %-15s %-20s %-25s %-30s%n",center.getCenterId(),center.getOwnerId(),center.getGymName(), center.getGymLocation() , center.getNumOfSlots());
                }
                System.out.println("Enter a date (dd/mm/yyyy): ");
                in = new java.util.Scanner(System.in);
                String dateStr = in.nextLine();
                SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                try {
                    Date date = sdf.parse(dateStr);
                    System.out.println("------------------------------------------------------------------------------------------------");
                    System.out.println("Date you entered is : " + date.toString());
                    System.out.println("Enter the centre ID to select a slot for booking");
                    int centerId = in.nextInt();
                    List<GymSlots> slots = centerBusiness.viewSlots(centerId, date);
                    if(slots.size() == 0){
                        System.out.println("No slot found");
                        continue;
                    }
                    System.out.println("------------------------------------------------------------------------------------------------");
                    System.out.printf("%-15s %-15s %-20s %-25s %-30s %-15s%n","SlotId", "CenterId" ,"StartTime" ,"EndTime" ,"AvailableNumSeats" ,"Cost");
                    for (GymSlots slot : slots) {
                        System.out.printf("%-15s %-15s %-20s %-25s %-30s %-15s%n",slot.getSlotId() , slot.getCenterId(), slot.getStartTime() , slot.getEndTime() , slot.getCost(), slot.getTotalSeats());
                    }
                    System.out.println("select a slot Id for booking");
                    int slotId = in.nextInt();
                    int bookingId = service.createBooking(currentcustId, slotId, centerId, date);
                    System.out.println("------------------------------------------------------------------------------------------------");
                    System.out.println("Type Payment Option as one of below without spaces:");
                    System.out.println("1. CreditCard");
                    System.out.println("2. DebitCard");
                    System.out.println("3. UPI");
                    System.out.println("4. Netbanking");
                    in = new java.util.Scanner(System.in);
                    String mode = in.nextLine().toLowerCase();
                    int paymentId = service.makepayment(bookingId, mode);
                    System.out.println("PaymentId = " + paymentId + "|| BookingId = " + bookingId);
                } catch (ParseException e) {
                    e.printStackTrace();
                }
            }
            else if (choice == 3) {
                in = new Scanner(System.in);
                System.out.println("Enter the booking Id to be cancelled");
                int bookingId = in.nextInt();
                if(service.cancelBooking(currentcustId, bookingId)){
                    System.out.println("Booking Canceled Successfully");
                }
            }
            else if (choice == 4) {
                in = new java.util.Scanner(System.in);
                System.out.println("------------------------------------------------------------------------------------------------");
                System.out.println("Editing profile ...");
                System.out.println("Enter your new name");
                String name = in.nextLine();
                System.out.println("Enter your new email");
                String email = in.nextLine();
                System.out.println("Enter your new Address");
                String address = in.nextLine();
                System.out.println("Enter your new password");
                String password = in.nextLine();
                System.out.println("Enter your new Contact Number");
                String contactNumber = in.nextLine();
                GymCustomer customer = new GymCustomer(name, address, email, contactNumber, password);
                customer.setCustomerId(currentcustId);
                if(service.editProfile(customer)){
                    System.out.println("Profile Edited Successfully");
                }
            }
            else if (choice == 5)
                break;
            else
                System.out.println("Invalid choice Try Again");
        }

    }
}

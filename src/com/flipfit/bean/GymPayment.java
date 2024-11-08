package com.flipfit.bean;

public class GymPayment {
    private int paymentID;
    private int bookingID;
    private String mode;
    private int amount;

    public int getBookingID() {
        return bookingID;
    }

    public void setBookingID(int bookingID) {
        this.bookingID = bookingID;
    }

    public String getMode() {
        return mode;
    }

    public void setMode(String mode) {
        this.mode = mode;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public GymPayment(int bookingID, String mode) {
        this.bookingID = bookingID;
        this.mode = mode;
    }
}

package com.flipfit.bean;

public class GymPayment {
    private int paymentID;
    private int bookingID;
    private int mode;
    private int amount;

    public int getBookingID() {
        return bookingID;
    }

    public void setBookingID(int bookingID) {
        this.bookingID = bookingID;
    }

    public int getMode() {
        return mode;
    }

    public void setMode(int mode) {
        this.mode = mode;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public void setPaymentID(int paymentID) {
        this.paymentID = paymentID;
    }
}

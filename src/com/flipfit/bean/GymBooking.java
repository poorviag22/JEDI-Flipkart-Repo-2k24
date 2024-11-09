package com.flipfit.bean;

import java.time.LocalTime;
import java.util.Date;

public class GymBooking {
    //BookingId CenterName CenterLocation StartTime EndTime Date
    private int bookingId;
    private String centerName;
    private String centerLocation;
    private LocalTime startTime;
    private LocalTime endTime;
    private Date bookingDate;

    public GymBooking(int bookingId, String centerName, String centerLocation, LocalTime startTime, LocalTime endTime, Date bookingDate) {
        this.bookingId = bookingId;
        this.centerName = centerName;
        this.centerLocation = centerLocation;
        this.startTime = startTime;
        this.endTime = endTime;
        this.bookingDate = bookingDate;
    }

    public int getBookingId() {
        return bookingId;
    }

    public void setBookingId(int bookingId) {
        this.bookingId = bookingId;
    }

    public String getCenterName() {
        return centerName;
    }

    public void setCenterName(String centerName) {
        this.centerName = centerName;
    }

    public String getCenterLocation() {
        return centerLocation;
    }

    public void setCenterLocation(String centerLocation) {
        this.centerLocation = centerLocation;
    }

    public LocalTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalTime startTime) {
        this.startTime = startTime;
    }

    public LocalTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalTime endTime) {
        this.endTime = endTime;
    }

    public Date getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(Date bookingDate) {
        this.bookingDate = bookingDate;
    }
}

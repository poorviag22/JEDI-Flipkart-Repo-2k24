package com.flipfit.bean;

public class GymBooking {
    private int centerId;
    private int slotId;
    private int customerId;
    private int bookingId;

    public int getCenterId() {
        return centerId;
    }

    public void setCenterId(int centerId) {
        this.centerId = centerId;
    }

    public int getSlotId() {
        return slotId;
    }

    public void setSlotId(int slotId) {
        this.slotId = slotId;
    }

    public int getCustomerId() {
        return customerId;
    }

    public int getBookingId() {
        return bookingId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }
}

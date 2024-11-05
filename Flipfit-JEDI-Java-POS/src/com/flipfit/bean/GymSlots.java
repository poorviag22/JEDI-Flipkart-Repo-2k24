package com.flipfit.bean;

import java.util.Date;

public class GymSlots {
    private int centerId;
    private int slotId;
    private Date date;
    private int customerId;
    private String time;

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
    public Date getDate() {
        return date;
    }
    public void setDate(Date date) {
        this.date = date;
    }
    public int getCustomerId() {
        return customerId;
    }
    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }
    public String getTime() {
        return time;
    }
    public void setTime(String time) {
        this.time = time;
    }

}

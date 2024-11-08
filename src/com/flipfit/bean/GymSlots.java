package com.flipfit.bean;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;

public class GymSlots {
    private int centerId;
    private int slotId;
    private LocalTime startTime;
    private LocalTime endTime;
    private int totalSeats;
    private int cost;

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }



    public int getTotalSeats() {
        return totalSeats;
    }

    public void setTotalSeats(int totalSeats) {
        this.totalSeats = totalSeats;
    }

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

    public GymSlots(int centerId, LocalTime StartTime, LocalTime EndTime, int totalSeats, int cost) {
        this.centerId = centerId;
        this.startTime = StartTime;
        this.endTime = EndTime;
        this.totalSeats = totalSeats;
        this.cost = cost;
    }
}

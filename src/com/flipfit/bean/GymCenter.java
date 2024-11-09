package com.flipfit.bean;

public class GymCenter {
    private int centerId;
    private int ownerId;
    private String gymName;
    private String gymLocation;
    private int numOfSlots;

    public int getId() {
        return centerId;
    }
    public void setId(int id) {
        this.centerId = centerId;
    }
    public String getGymName() {
        return gymName;
    }
    public void setGymName(String gymName) {
        this.gymName = gymName;
    }

    public String getGymLocation() {
        return gymLocation;
    }
    public void setGymLocation(String gymLocation) {
        this.gymLocation = gymLocation;
    }

    public int getNumOfSlots() {
        return numOfSlots;
    }

    public void setNumOfSlots(int numOfSlots) {
        this.numOfSlots = numOfSlots;
    }

    public int getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(int ownerId) {
        this.ownerId = ownerId;
    }

    public int getCenterId() {
        return centerId;
    }

    public GymCenter(int centerId, int ownerId, String gymName, String gymLocation, int numOfSlots) {
        this.centerId = centerId;
        this.ownerId = ownerId;
        this.gymName = gymName;
        this.gymLocation = gymLocation;
        this.numOfSlots = numOfSlots;
    }
}

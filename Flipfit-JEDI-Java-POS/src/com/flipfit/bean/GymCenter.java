package com.flipfit.bean;

public class GymCenter {
    private int id;
    private String gymName;
    private String gymLocation;
    private int numOfSlots;

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
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
}

package com.flipfit.bean;

public class GymOwnerRequest {
    private int requestId;
    private int ownerId;
    private String status;
    private String centerName;
    private String centerLocation;
    private int NumOfSlots;

    public int getRequestId() {
        return requestId;
    }

    public void setRequestId(int requestId) {
        this.requestId = requestId;
    }

    public int getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(int ownerId) {
        this.ownerId = ownerId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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

    public int getNumOfSlots() {
        return NumOfSlots;
    }

    public void setNumOfSlots(int numOfSlots) {
        NumOfSlots = numOfSlots;
    }

    public GymOwnerRequest(int requestId, int ownerId, String status, String centerName, String centerLocation, int numOfSlots) {
        this.requestId = requestId;
        this.ownerId = ownerId;
        this.status = status;
        this.centerName = centerName;
        this.centerLocation = centerLocation;
        NumOfSlots = numOfSlots;
    }
}

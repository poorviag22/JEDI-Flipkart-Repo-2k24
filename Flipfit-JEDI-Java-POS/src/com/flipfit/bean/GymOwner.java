package com.flipfit.bean;

public class GymOwner {
    private int ownerId;
    private String ownerName;
    private String ownerEmailAddress;
    private int ownerPhone;
    private int ownerGSTNum;
    private boolean isApproved;
    private String ownerAddress;

    public int getOwnerId() {
        return ownerId;
    }
    public void setOwnerId(int ownerId) {
        this.ownerId = ownerId;
    }
    public String getOwnerName() {
        return ownerName;
    }
    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }
    public String getOwnerEmailAddress() {
        return ownerEmailAddress;
    }
    public void setOwnerEmailAddress(String ownerEmailAddress) {
        this.ownerEmailAddress = ownerEmailAddress;
    }
    public int getOwnerPhone() {
        return ownerPhone;
    }
    public void setOwnerPhone(int ownerPhone) {
        this.ownerPhone = ownerPhone;
    }
    public int getOwnerGSTNum() {
        return ownerGSTNum;
    }
    public void setOwnerGSTNum(int ownerGSTNum) {
        this.ownerGSTNum = ownerGSTNum;
    }
    public boolean isApproved() {
        return isApproved;
    }
    public void setApproved(boolean isApproved) {
        this.isApproved = isApproved;
    }
    public String getOwnerAddress() {
        return ownerAddress;
    }
    public void setOwnerAddress(String ownerAddress) {
        this.ownerAddress = ownerAddress;
    }
}

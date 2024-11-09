package com.flipfit.bean;

public class GymOwner {
    private int ownerId;
    private String ownerName;
    private String ownerEmailAddress;
    private String ownerPhone;
    //private int ownerGSTNum;
    //private boolean isApproved;
    private String ownerAddress;
    private String password;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

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
    public String getOwnerPhone() {
        return ownerPhone;
    }
    public void setOwnerPhone(String ownerPhone) {
        this.ownerPhone = ownerPhone;
    }
    /*public int getOwnerGSTNum() {
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
     */
    public String getOwnerAddress() {
        return ownerAddress;
    }
    public void setOwnerAddress(String ownerAddress) {
        this.ownerAddress = ownerAddress;
    }
    public GymOwner(String ownerName, String ownerEmailAddress, String ownerPhone, String ownerAddress, String password) {
        this.ownerName = ownerName;
        this.ownerEmailAddress = ownerEmailAddress;
        this.ownerPhone = ownerPhone;
        this.ownerAddress = ownerAddress;
        this.password = password;
    }

    public GymOwner(int ownerId, String ownerName, String ownerEmailAddress, String ownerPhone, String ownerAddress, String password) {
        this.ownerId = ownerId;
        this.ownerName = ownerName;
        this.ownerEmailAddress = ownerEmailAddress;
        this.ownerPhone = ownerPhone;
        this.ownerAddress = ownerAddress;
        this.password = password;
    }
}

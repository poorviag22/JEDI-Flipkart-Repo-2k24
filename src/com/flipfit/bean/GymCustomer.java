package com.flipfit.bean;

public class GymCustomer {
    // the Properties of the bean class which contains the Setter Getter As well

    private int customerId;
    private String customerName;
    private String customerAddress;
    private String customerEmailAddress;
    private String customerPhone;
    private String password;

    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public int getCustomerId() {
        return customerId;
    }
    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }
    public String getCustomerName() {
        return customerName;
    }
    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }
    public String getCustomerAddress() {
        return customerAddress;
    }
    public void setCustomerAddress(String customerAddress) {
        this.customerAddress = customerAddress;
    }
    public String getCustomerEmailAddress() {
        return customerEmailAddress;
    }
    public void setCustomerEmailAddress(String customerEmailAddress) {
        this.customerEmailAddress = customerEmailAddress;
    }
    public String getCustomerPhone() {
        return customerPhone;
    }
    public void setCustomerPhone(String customerPhone) {
        this.customerPhone = customerPhone;
    }

    public GymCustomer(String name, String address, String email, String phone, String password) {
        this.customerName = name;
        this.customerAddress = address;
        this.customerEmailAddress = email;
        this.customerPhone = phone;
        this.password = password;


    }

    public GymCustomer(int customerId, String customerName, String customerAddress, String customerEmailAddress, String customerPhone, String password) {
        this.customerId = customerId;
        this.customerName = customerName;
        this.customerAddress = customerAddress;
        this.customerEmailAddress = customerEmailAddress;
        this.customerPhone = customerPhone;
        this.password = password;
    }
}

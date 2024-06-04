package com.lld.creational.prototype;

public class Address implements Cloneable{
    private String addressLine1;
    private String addressLine2;
    private int pinCode;
    private String city;
    private  String state;

    public Address(String addressLine1, String addressLine2, int pinCode, String city, String state) {
        this.addressLine1 = addressLine1;
        this.addressLine2 = addressLine2;
        this.pinCode = pinCode;
        this.city = city;
        this.state = state;
    }

    public String getAddressLine1() {
        return addressLine1;
    }

    public String getAddressLine2() {
        return addressLine2;
    }

    public int getPinCode() {
        return pinCode;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }

    public void setAddressLine1(String addressLine1) {
        this.addressLine1 = addressLine1;
    }

    public void setAddressLine2(String addressLine2) {
        this.addressLine2 = addressLine2;
    }

    public void setPinCode(int pinCode) {
        this.pinCode = pinCode;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setState(String state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "Address{" +
                "addressLine1='" + addressLine1 + '\'' +
                ", addressLine2='" + addressLine2 + '\'' +
                ", pinCode=" + pinCode +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                '}';
    }

    @Override
    public Address clone() throws CloneNotSupportedException {
        return (Address)super.clone();

    }


}

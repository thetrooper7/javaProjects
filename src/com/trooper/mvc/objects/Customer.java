package com.trooper.mvc.objects;

import java.io.Serializable;

public class Customer implements Serializable {

    private String firstName;
    private String lastName;
    private String address;
    private String phone;

    public Customer() {
        super();
    }

    public Customer(String firstName, String lastName, String address,
                    String phone) {
        super();
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.phone = phone;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    public String toString() {
        return " FirstName:" + this.firstName + " LastName:" + this.lastName + " Address:"
                + this.address + " Phone:" + this.phone;
    }

}

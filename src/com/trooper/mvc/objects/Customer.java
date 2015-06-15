package com.trooper.mvc.objects;

public class Customer {

    private static int id;
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
        setId(getId() + 1);
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.phone = phone;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
        /*return "id:" + this.id + " FirstName:" + this.firstName + " LastName:" + this.lastName + " Address:"
                + this.address + " Phone:" + this.phone;*/
        return " FirstName:" + this.firstName + " LastName:" + this.lastName + " Address:"
                + this.address + " Phone:" + this.phone;
    }

}

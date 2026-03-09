package com.addressbook.model;

import java.time.LocalDate;
import java.util.Objects;

public class Contact {

    private String firstName;
    private String lastName;
    private String address;
    private String city;
    private String state;
    private String zip;
    private String phoneNumber;
    private String email;
    private LocalDate dateAdded;

    public Contact(String firstName, String lastName, String address,
                   String city, String state, String zip,
                   String phoneNumber, String email,
                   LocalDate dateAdded) {

        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.city = city;
        this.state = state;
        this.zip = zip;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.dateAdded = dateAdded;
    }

    public String getFirstName() { return firstName; }

    public String getLastName() { return lastName; }

    public String getAddress() { return address; }

    public String getCity() { return city; }

    public String getState() { return state; }

    public String getZip() { return zip; }

    public String getPhoneNumber() { return phoneNumber; }

    public String getEmail() { return email; }

    public LocalDate getDateAdded() { return dateAdded; }

    public void setAddress(String address) { this.address = address; }

    public void setCity(String city) { this.city = city; }

    public void setState(String state) { this.state = state; }

    public void setZip(String zip) { this.zip = zip; }

    public void setPhoneNumber(String phoneNumber) { this.phoneNumber = phoneNumber; }

    public void setEmail(String email) { this.email = email; }

    @Override
    public String toString() {
        return firstName + " " + lastName + "\n" +
                address + ", " + city + ", " + state + "\n" +
                "Zip: " + zip + "\n" +
                "Phone: " + phoneNumber + "\n" +
                "Email: " + email + "\n" +
                "Added On: " + dateAdded;
    }

    @Override
    public boolean equals(Object o) {

        if (this == o) return true;
        if (!(o instanceof Contact)) return false;

        Contact contact = (Contact) o;

        return Objects.equals(firstName, contact.firstName) &&
                Objects.equals(lastName, contact.lastName) &&
                Objects.equals(address, contact.address) &&
                Objects.equals(city, contact.city) &&
                Objects.equals(state, contact.state) &&
                Objects.equals(zip, contact.zip) &&
                Objects.equals(phoneNumber, contact.phoneNumber) &&
                Objects.equals(email, contact.email);
    }

    @Override
    public int hashCode() {

        return Objects.hash(firstName, lastName, address, city, state, zip, phoneNumber, email);
    }
}
package com.addressbook;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AddressBookApp {

    public static void main(String[] args) {

        SpringApplication.run(AddressBookApp.class, args);

        AddressBookMain addressBookMain = new AddressBookMain();
        addressBookMain.start();
    }

}
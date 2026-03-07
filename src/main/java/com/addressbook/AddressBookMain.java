package com.addressbook;

import com.addressbook.model.Contact;
import java.util.ArrayList;
import java.util.List;

public class AddressBookMain {

    private List<Contact> contacts = new ArrayList<>();

    public void start() {

        System.out.println("\nWELCOME TO ADDRESS BOOK APP\n");

        Contact person = new Contact(
                "Pratham",
                "Kacher",
                "MP Nagar",
                "Bhopal",
                "Madhya Pradesh",
                "462023",
                "9876543210",
                "pratham@gmail.com"
        );

        contacts.add(person);

        displayContacts();
    }

    private void displayContacts() {

        for (Contact contact : contacts) {
            System.out.println(contact);
            System.out.println("-------------------------");
        }
    }
}
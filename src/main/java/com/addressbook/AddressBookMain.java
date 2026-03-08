package com.addressbook;

import com.addressbook.model.Contact;
import com.addressbook.service.AddressBook;

import java.util.Scanner;

public class AddressBookMain {

    private AddressBook addressBook = new AddressBook();

    public void start() {

        System.out.println("\nWELCOME TO ADDRESS BOOK APP\n");

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter First Name: ");
        String firstName = scanner.nextLine();

        System.out.print("Enter Last Name: ");
        String lastName = scanner.nextLine();

        System.out.print("Enter Address: ");
        String address = scanner.nextLine();

        System.out.print("Enter City: ");
        String city = scanner.nextLine();

        System.out.print("Enter State: ");
        String state = scanner.nextLine();

        System.out.print("Enter Zip: ");
        String zip = scanner.nextLine();

        System.out.print("Enter Phone Number: ");
        String phone = scanner.nextLine();

        System.out.print("Enter Email: ");
        String email = scanner.nextLine();

        Contact contact = new Contact(
                firstName,
                lastName,
                address,
                city,
                state,
                zip,
                phone,
                email
        );

        addressBook.addContact(contact);

        System.out.println("\nContact Added Successfully!\n");

        addressBook.displayContacts();

        // UC3
        System.out.print("\nEnter First Name of Contact to Edit: ");
        String name = scanner.nextLine();

        addressBook.editContact(name);

        System.out.println("\nUpdated Contact List:\n");
        addressBook.displayContacts();
    }
}
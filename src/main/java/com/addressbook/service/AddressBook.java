package com.addressbook.service;

import com.addressbook.model.Contact;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AddressBook {

    private List<Contact> contacts = new ArrayList<>();

    public void addContact(Contact contact) {
        contacts.add(contact);
    }

    public void displayContacts() {

        for (Contact contact : contacts) {
            System.out.println(contact);
            System.out.println("----------------------");
        }
    }

    // UC3 - Edit Contact
    public void editContact(String name) {

        Scanner scanner = new Scanner(System.in);
        boolean found = false;

        for (Contact contact : contacts) {

            if (contact.getFirstName().equalsIgnoreCase(name)) {

                System.out.println("\nEditing Contact: " + name);

                System.out.print("Enter New Address: ");
                contact.setAddress(scanner.nextLine());

                System.out.print("Enter New City: ");
                contact.setCity(scanner.nextLine());

                System.out.print("Enter New State: ");
                contact.setState(scanner.nextLine());

                System.out.print("Enter New Zip: ");
                contact.setZip(scanner.nextLine());

                System.out.print("Enter New Phone Number: ");
                contact.setPhoneNumber(scanner.nextLine());

                System.out.print("Enter New Email: ");
                contact.setEmail(scanner.nextLine());

                System.out.println("\nContact Updated Successfully!\n");

                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("Contact not found!");
        }
    }

    // UC4 - Delete Contact
    public void deleteContact(String name) {

        boolean found = false;

        for (int i = 0; i < contacts.size(); i++) {

            Contact contact = contacts.get(i);

            if (contact.getFirstName().equalsIgnoreCase(name)) {

                contacts.remove(i);

                System.out.println("\nContact Deleted Successfully!\n");

                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("Contact not found!");
        }
    }
}
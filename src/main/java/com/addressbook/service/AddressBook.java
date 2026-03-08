package com.addressbook.service;

import com.addressbook.model.Contact;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AddressBook {

    private List<Contact> contacts = new ArrayList<>();

    // UC7 - Add contact with duplicate check
    public void addContact(Contact contact) {

        boolean duplicate = contacts.stream()
                .anyMatch(existing -> existing.equals(contact));

        if (duplicate) {

            System.out.println("Duplicate contact! Person already exists.");
            return;
        }

        contacts.add(contact);
        System.out.println("Contact Added Successfully!");
    }

    public void displayContacts() {

        if (contacts.isEmpty()) {
            System.out.println("No contacts found.");
            return;
        }

        for (Contact contact : contacts) {

            System.out.println(contact);
            System.out.println("----------------------");
        }
    }

    // Edit Contact
    public void editContact(String name) {

        Scanner scanner = new Scanner(System.in);

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

                System.out.print("Enter New Phone: ");
                contact.setPhoneNumber(scanner.nextLine());

                System.out.print("Enter New Email: ");
                contact.setEmail(scanner.nextLine());

                System.out.println("Contact Updated Successfully!");
                return;
            }
        }

        System.out.println("Contact not found!");
    }

    // Delete Contact
    public void deleteContact(String name) {

        boolean removed = contacts.removeIf(
                contact -> contact.getFirstName().equalsIgnoreCase(name)
        );

        if (removed) {
            System.out.println("Contact Deleted Successfully!");
        } else {
            System.out.println("Contact not found!");
        }
    }
}
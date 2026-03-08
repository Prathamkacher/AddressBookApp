package com.addressbook;

import com.addressbook.model.Contact;
import com.addressbook.service.AddressBook;

import java.util.Scanner;

public class AddressBookMain {

    private AddressBook addressBook = new AddressBook();

    public void start() {

        Scanner scanner = new Scanner(System.in);

        System.out.println("\nWELCOME TO ADDRESS BOOK APP\n");

        while (true) {

            System.out.println("\n===== ADDRESS BOOK MENU =====");
            System.out.println("1. Add Contact");
            System.out.println("2. View Contacts");
            System.out.println("3. Edit Contact");
            System.out.println("4. Delete Contact");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");

            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {

                // Add Contact
                case 1:

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

                    System.out.println("\nContact Added Successfully!");
                    break;

                // View Contacts
                case 2:

                    System.out.println("\nCONTACT LIST:");
                    addressBook.displayContacts();
                    break;

                // Edit Contact
                case 3:

                    System.out.print("Enter First Name to Edit: ");
                    String editName = scanner.nextLine();

                    addressBook.editContact(editName);
                    break;

                // Delete Contact
                case 4:

                    System.out.print("Enter First Name to Delete: ");
                    String deleteName = scanner.nextLine();

                    addressBook.deleteContact(deleteName);
                    break;

                // Exit
                case 5:

                    System.out.println("Exiting Address Book. Goodbye!");
                    return;

                default:

                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
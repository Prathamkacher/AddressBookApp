package com.addressbook;

import com.addressbook.model.Contact;
import com.addressbook.service.AddressBook;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class AddressBookMain {

    private Map<String, AddressBook> addressBooks = new HashMap<>();

    public void start() {

        Scanner scanner = new Scanner(System.in);

        System.out.println("\nWELCOME TO ADDRESS BOOK SYSTEM\n");

        while (true) {

            System.out.println("\n===== ADDRESS BOOK SYSTEM MENU =====");
            System.out.println("1. Create Address Book");
            System.out.println("2. Select Address Book");
            System.out.println("3. Search Person by City");
            System.out.println("4. Search Person by State");
            System.out.println("5. Exit");

            System.out.print("Choose option: ");

            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {

                case 1:

                    System.out.print("Enter Address Book Name: ");

                    String bookName = scanner.nextLine();

                    if (addressBooks.containsKey(bookName)) {

                        System.out.println("Address Book already exists!");
                    }

                    else {

                        addressBooks.put(bookName, new AddressBook());

                        System.out.println("Address Book Created!");
                    }

                    break;

                case 2:

                    System.out.print("Enter Address Book Name: ");

                    String name = scanner.nextLine();

                    AddressBook book = addressBooks.get(name);

                    if (book == null) {

                        System.out.println("Address Book not found!");
                    }

                    else {

                        addressBookMenu(book, scanner);
                    }

                    break;

                case 3:

                    System.out.print("Enter City: ");

                    String city = scanner.nextLine();

                    searchByCity(city);

                    break;

                case 4:

                    System.out.print("Enter State: ");

                    String state = scanner.nextLine();

                    searchByState(state);

                    break;

                case 5:

                    System.out.println("Exiting...");

                    return;

                default:

                    System.out.println("Invalid choice.");
            }
        }
    }

    private void addressBookMenu(AddressBook addressBook, Scanner scanner) {

        while (true) {

            System.out.println("\n--- ADDRESS BOOK MENU ---");

            System.out.println("1. Add Contact");
            System.out.println("2. View Contacts");
            System.out.println("3. Edit Contact");
            System.out.println("4. Delete Contact");
            System.out.println("5. Back");

            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {

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

                    System.out.print("Enter Phone: ");
                    String phone = scanner.nextLine();

                    System.out.print("Enter Email: ");
                    String email = scanner.nextLine();

                    Contact contact = new Contact(
                            firstName, lastName, address, city, state, zip, phone, email
                    );

                    addressBook.addContact(contact);

                    break;

                case 2:

                    addressBook.displayContacts();

                    break;

                case 3:

                    System.out.print("Enter First Name to Edit: ");

                    addressBook.editContact(scanner.nextLine());

                    break;

                case 4:

                    System.out.print("Enter First Name to Delete: ");

                    addressBook.deleteContact(scanner.nextLine());

                    break;

                case 5:

                    return;
            }
        }
    }

    // UC8 Search by City using Streams
    private void searchByCity(String city) {

        addressBooks.values().stream()

                .flatMap(book -> book.getContacts().stream())

                .filter(contact -> contact.getCity().equalsIgnoreCase(city))

                .forEach(contact -> {

                    System.out.println(contact);

                    System.out.println("-------------------");
                });
    }

    // UC8 Search by State using Streams
    private void searchByState(String state) {

        addressBooks.values().stream()

                .flatMap(book -> book.getContacts().stream())

                .filter(contact -> contact.getState().equalsIgnoreCase(state))

                .forEach(contact -> {

                    System.out.println(contact);

                    System.out.println("-------------------");
                });
    }
}
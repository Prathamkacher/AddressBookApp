package com.addressbook;

import com.addressbook.model.Contact;
import com.addressbook.service.AddressBook;
import com.addressbook.service.FileService;

import java.util.*;
import java.util.stream.Collectors;

public class AddressBookMain {

    private Map<String, AddressBook> addressBooks = new HashMap<>();
    private FileService fileService = new FileService();

    public void start() {

        Scanner scanner = new Scanner(System.in);

        System.out.println("\nWELCOME TO ADDRESS BOOK SYSTEM\n");

        while (true) {

            System.out.println("\n===== ADDRESS BOOK SYSTEM MENU =====");
            System.out.println("1. Create Address Book");
            System.out.println("2. Select Address Book");
            System.out.println("3. Search Person by City");
            System.out.println("4. Search Person by State");
            System.out.println("5. View Persons by City");
            System.out.println("6. View Persons by State");
            System.out.println("7. Count Persons by City");
            System.out.println("8. Count Persons by State");
            System.out.println("9. Sort Contacts by Name");
            System.out.println("10. Sort Contacts by City");
            System.out.println("11. Sort Contacts by State");
            System.out.println("12. Sort Contacts by Zip");
            System.out.println("13. Write Contacts to File");
            System.out.println("14. Read Contacts from File");
            System.out.println("15. Exit");

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
                    searchByCity(scanner.nextLine());

                    break;

                case 4:

                    System.out.print("Enter State: ");
                    searchByState(scanner.nextLine());

                    break;

                case 5:

                    viewPersonsByCity();

                    break;

                case 6:

                    viewPersonsByState();

                    break;

                case 7:

                    countPersonsByCity();

                    break;

                case 8:

                    countPersonsByState();

                    break;

                case 9:

                    sortContactsByName();

                    break;

                case 10:

                    sortContactsByCity();

                    break;

                case 11:

                    sortContactsByState();

                    break;

                case 12:

                    sortContactsByZip();

                    break;

                case 13:

                    fileService.writeContactsToFile(getAllContacts());

                    break;

                case 14:

                    fileService.readContactsFromFile();

                    break;

                case 15:

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

    private List<Contact> getAllContacts() {

        return addressBooks.values().stream()
                .flatMap(book -> book.getContacts().stream())
                .collect(Collectors.toList());
    }

    private void searchByCity(String city) {

        getAllContacts().stream()
                .filter(c -> c.getCity().equalsIgnoreCase(city))
                .forEach(System.out::println);
    }

    private void searchByState(String state) {

        getAllContacts().stream()
                .filter(c -> c.getState().equalsIgnoreCase(state))
                .forEach(System.out::println);
    }

    private void viewPersonsByCity() {

        getAllContacts().stream()
                .collect(Collectors.groupingBy(Contact::getCity))
                .forEach((city, persons) -> {

                    System.out.println("\nCity: " + city);

                    persons.forEach(System.out::println);
                });
    }

    private void viewPersonsByState() {

        getAllContacts().stream()
                .collect(Collectors.groupingBy(Contact::getState))
                .forEach((state, persons) -> {

                    System.out.println("\nState: " + state);

                    persons.forEach(System.out::println);
                });
    }

    private void countPersonsByCity() {

        getAllContacts().stream()
                .collect(Collectors.groupingBy(Contact::getCity, Collectors.counting()))
                .forEach((city, count) ->
                        System.out.println(city + " : " + count));
    }

    private void countPersonsByState() {

        getAllContacts().stream()
                .collect(Collectors.groupingBy(Contact::getState, Collectors.counting()))
                .forEach((state, count) ->
                        System.out.println(state + " : " + count));
    }

    private void sortContactsByName() {

        getAllContacts().stream()
                .sorted(Comparator.comparing(Contact::getFirstName))
                .forEach(System.out::println);
    }

    private void sortContactsByCity() {

        getAllContacts().stream()
                .sorted(Comparator.comparing(Contact::getCity))
                .forEach(System.out::println);
    }

    private void sortContactsByState() {

        getAllContacts().stream()
                .sorted(Comparator.comparing(Contact::getState))
                .forEach(System.out::println);
    }

    private void sortContactsByZip() {

        getAllContacts().stream()
                .sorted(Comparator.comparing(Contact::getZip))
                .forEach(System.out::println);
    }
}
package com.addressbook;

import com.addressbook.model.Contact;
import com.addressbook.service.AddressBook;
import com.addressbook.service.FileService;
import com.addressbook.service.CsvService;
import com.addressbook.service.JsonService;
import com.addressbook.service.DatabaseService;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class AddressBookMain {

    private Map<String, AddressBook> addressBooks = new HashMap<>();

    private FileService fileService = new FileService();
    private CsvService csvService = new CsvService();
    private JsonService jsonService = new JsonService();
    private DatabaseService databaseService = new DatabaseService();

    public void start() {

        Scanner scanner = new Scanner(System.in);

        while (true) {

            System.out.println("\n===== ADDRESS BOOK MENU =====");
            System.out.println("1 Create Address Book");
            System.out.println("2 Select Address Book");
            System.out.println("3 Search by City");
            System.out.println("4 Search by State");
            System.out.println("5 View Persons by City");
            System.out.println("6 View Persons by State");
            System.out.println("7 Count Persons by City");
            System.out.println("8 Count Persons by State");
            System.out.println("9 Sort by Name");
            System.out.println("10 Sort by City");
            System.out.println("11 Sort by State");
            System.out.println("12 Sort by Zip");
            System.out.println("13 Write TXT");
            System.out.println("14 Read TXT");
            System.out.println("15 Write CSV");
            System.out.println("16 Read CSV");
            System.out.println("17 Write JSON");
            System.out.println("18 Read JSON");
            System.out.println("19 Retrieve Contacts by Date Range (UC18)");
            System.out.println("20 Exit");

            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {

                case 1 -> createAddressBook(scanner);
                case 2 -> selectAddressBook(scanner);
                case 3 -> search(scanner, Contact::getCity);
                case 4 -> search(scanner, Contact::getState);
                case 5 -> groupBy(Contact::getCity);
                case 6 -> groupBy(Contact::getState);
                case 7 -> countBy(Contact::getCity);
                case 8 -> countBy(Contact::getState);
                case 9 -> sortBy(Contact::getFirstName);
                case 10 -> sortBy(Contact::getCity);
                case 11 -> sortBy(Contact::getState);
                case 12 -> sortBy(Contact::getZip);
                case 13 -> fileService.writeContactsToFile(getAllContacts());
                case 14 -> fileService.readContactsFromFile();
                case 15 -> csvService.writeContactsToCSV(getAllContacts());
                case 16 -> csvService.readContactsFromCSV();
                case 17 -> jsonService.writeContactsToJson(getAllContacts());
                case 18 -> jsonService.readContactsFromJson();
                case 19 -> retrieveContactsByDate(scanner);
                case 20 -> { return; }
            }
        }
    }

    private void retrieveContactsByDate(Scanner scanner) {

        System.out.print("Enter Start Date (YYYY-MM-DD): ");
        String start = scanner.nextLine();

        System.out.print("Enter End Date (YYYY-MM-DD): ");
        String end = scanner.nextLine();

        List<Contact> contacts =
                databaseService.getContactsByDateRange(start, end);

        contacts.forEach(System.out::println);
    }

    private void createAddressBook(Scanner scanner) {

        System.out.print("Enter AddressBook Name: ");
        String name = scanner.nextLine();

        addressBooks.putIfAbsent(name, new AddressBook());

        System.out.println("AddressBook created.");
    }

    private void selectAddressBook(Scanner scanner) {

        System.out.print("Enter AddressBook Name: ");
        AddressBook book = addressBooks.get(scanner.nextLine());

        if (book == null) {

            System.out.println("Not found.");
            return;
        }

        addressBookMenu(book, scanner);
    }

    private void addressBookMenu(AddressBook book, Scanner scanner) {

        while (true) {

            System.out.println("\n1 Add Contact");
            System.out.println("2 View Contacts");
            System.out.println("3 Edit");
            System.out.println("4 Delete");
            System.out.println("5 Back");

            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {

                case 1 -> book.addContact(createContact(scanner));
                case 2 -> book.displayContacts();
                case 3 -> {
                    System.out.print("Enter Name: ");
                    book.editContact(scanner.nextLine());
                }
                case 4 -> {
                    System.out.print("Enter Name: ");
                    book.deleteContact(scanner.nextLine());
                }
                case 5 -> { return; }
            }
        }
    }

    private Contact createContact(Scanner scanner) {

        System.out.print("First Name: ");
        String firstName = scanner.nextLine();

        System.out.print("Last Name: ");
        String lastName = scanner.nextLine();

        System.out.print("Address: ");
        String address = scanner.nextLine();

        System.out.print("City: ");
        String city = scanner.nextLine();

        System.out.print("State: ");
        String state = scanner.nextLine();

        System.out.print("Zip: ");
        String zip = scanner.nextLine();

        System.out.print("Phone: ");
        String phone = scanner.nextLine();

        System.out.print("Email: ");
        String email = scanner.nextLine();

        return new Contact(firstName,lastName,address,city,state,zip,phone,email,java.time.LocalDate.now());
    }

    private List<Contact> getAllContacts() {

        return addressBooks.values().stream()
                .flatMap(book -> book.getContacts().stream())
                .toList();
    }

    private void search(Scanner scanner, Function<Contact,String> field) {

        System.out.print("Enter value: ");
        String value = scanner.nextLine();

        getAllContacts().stream()
                .filter(c -> field.apply(c).equalsIgnoreCase(value))
                .forEach(System.out::println);
    }

    private void groupBy(Function<Contact,String> field) {

        getAllContacts().stream()
                .collect(Collectors.groupingBy(field))
                .forEach((key,list)->{

                    System.out.println("\n"+key);
                    list.forEach(System.out::println);
                });
    }

    private void countBy(Function<Contact,String> field) {

        getAllContacts().stream()
                .collect(Collectors.groupingBy(field,Collectors.counting()))
                .forEach((k,v)->System.out.println(k+" : "+v));
    }

    private void sortBy(Function<Contact,String> field) {

        getAllContacts().stream()
                .sorted(Comparator.comparing(field))
                .forEach(System.out::println);
    }
}
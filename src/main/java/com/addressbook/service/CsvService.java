package com.addressbook.service;

import com.addressbook.model.Contact;
import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class CsvService {

    private static final String FILE_NAME = "addressbook.csv";

    public void writeContactsToCSV(List<Contact> contacts) {

        try (CSVWriter writer = new CSVWriter(new FileWriter(FILE_NAME))) {

            String[] header = {"FirstName","LastName","Address","City","State","Zip","Phone","Email"};
            writer.writeNext(header);

            for (Contact contact : contacts) {

                String[] data = {
                        contact.getFirstName(),
                        contact.getLastName(),
                        contact.getAddress(),
                        contact.getCity(),
                        contact.getState(),
                        contact.getZip(),
                        contact.getPhoneNumber(),
                        contact.getEmail()
                };

                writer.writeNext(data);
            }

            System.out.println("Contacts successfully written to CSV.");

        } catch (IOException e) {

            System.out.println("Error writing CSV: " + e.getMessage());
        }
    }

    public void readContactsFromCSV() {

        try (CSVReader reader = new CSVReader(new FileReader(FILE_NAME))) {

            String[] line;

            System.out.println("\nContacts in CSV File:\n");

            while ((line = reader.readNext()) != null) {

                System.out.println(String.join(" | ", line));
            }

        } catch (Exception e) {

            System.out.println("Error reading CSV: " + e.getMessage());
        }
    }
}
package com.addressbook.service;

import com.addressbook.model.Contact;

import java.io.*;
import java.util.List;

public class FileService {

    private static final String FILE_NAME = "addressbook.txt";

    public void writeContactsToFile(List<Contact> contacts) {

        try (FileWriter writer = new FileWriter(FILE_NAME)) {

            for (Contact contact : contacts) {

                writer.write(contact.toString());
                writer.write("\n---------------------\n");
            }

            System.out.println("Contacts written to file successfully.");

        } catch (IOException e) {

            System.out.println("Error writing file: " + e.getMessage());
        }
    }

    public void readContactsFromFile() {

        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {

            String line;

            System.out.println("\nContacts in File:\n");

            while ((line = reader.readLine()) != null) {

                System.out.println(line);
            }

        } catch (IOException e) {

            System.out.println("Error reading file: " + e.getMessage());
        }
    }
}
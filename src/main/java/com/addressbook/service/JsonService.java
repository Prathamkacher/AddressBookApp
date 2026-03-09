package com.addressbook.service;

import com.addressbook.model.Contact;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.FileReader;
import java.io.FileWriter;
import java.lang.reflect.Type;
import java.util.List;

public class JsonService {

    private static final String FILE_NAME = "addressbook.json";

    private Gson gson = new GsonBuilder().setPrettyPrinting().create();

    public void writeContactsToJson(List<Contact> contacts) {

        try (FileWriter writer = new FileWriter(FILE_NAME)) {

            gson.toJson(contacts, writer);

            System.out.println("Contacts successfully written to JSON file.");

        } catch (Exception e) {

            System.out.println("Error writing JSON: " + e.getMessage());
        }
    }

    public void readContactsFromJson() {

        try (FileReader reader = new FileReader(FILE_NAME)) {

            Type listType = new TypeToken<List<Contact>>(){}.getType();

            List<Contact> contacts = gson.fromJson(reader, listType);

            System.out.println("\nContacts in JSON File:\n");

            if (contacts != null) {

                contacts.forEach(contact -> {

                    System.out.println(contact);
                    System.out.println("----------------------");
                });
            }

        } catch (Exception e) {

            System.out.println("Error reading JSON: " + e.getMessage());
        }
    }
}
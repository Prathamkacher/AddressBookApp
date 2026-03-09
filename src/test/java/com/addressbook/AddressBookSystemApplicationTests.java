package com.addressbook;

import com.addressbook.model.Contact;
import com.addressbook.service.DatabaseService;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class AddressBookSystemApplicationTests {

    DatabaseService databaseService = new DatabaseService();

    @Test
    void testRetrieveContactsFromDatabase() {

        List<Contact> contacts =
                databaseService.getAllContacts();

        assertNotNull(contacts);

        System.out.println("\nContacts Retrieved From Database:\n");

        contacts.forEach(System.out::println);
    }
}
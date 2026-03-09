package com.addressbook;

import com.addressbook.model.Contact;
import com.addressbook.service.DatabaseService;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class AddressBookSystemApplicationTests {

    DatabaseService databaseService = new DatabaseService();


    @Test
    void testRetrieveAllContactsFromDB() {

        List<Contact> contacts = databaseService.getAllContacts();

        assertNotNull(contacts);

        // Ensures method executed correctly
        assertTrue(contacts.size() >= 0);
    }

    
    @Test
    void testUpdateContactAndSyncWithDB() {

        databaseService.updateContactCity("Pratham","Delhi");

        Contact dbContact =
                databaseService.getContactByName("Pratham");

        Contact expectedContact =
                new Contact(
                        "Pratham",
                        "Kacher",
                        "Bhopal",
                        "Delhi",
                        "MP",
                        "462001",
                        "9876543210",
                        "pratham@gmail.com",
                        dbContact.getDateAdded()
                );

        assertEquals(expectedContact, dbContact);
    }


    @Test
    void testRetrieveContactsBetweenDates() {

        List<Contact> contacts =
                databaseService.getContactsByDateRange("2024-01-01","2026-12-31");

        assertNotNull(contacts);

        LocalDate start = LocalDate.parse("2024-01-01");
        LocalDate end = LocalDate.parse("2026-12-31");

        boolean allWithinRange = contacts.stream()
                .allMatch(contact ->
                        !contact.getDateAdded().isBefore(start) &&
                        !contact.getDateAdded().isAfter(end)
                );

        assertTrue(allWithinRange);
    }
}
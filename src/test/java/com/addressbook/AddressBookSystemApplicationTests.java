package com.addressbook;

import com.addressbook.model.Contact;
import com.addressbook.service.DatabaseService;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

public class AddressBookSystemApplicationTests {

    DatabaseService databaseService = new DatabaseService();


    // UC16
    @Test
    void testRetrieveAllContactsFromDB() {

        List<Contact> contacts = databaseService.getAllContacts();

        assertNotNull(contacts);
    }


    // UC17
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


    // UC18
    @Test
    void testRetrieveContactsBetweenDates() {

        List<Contact> contacts =
                databaseService.getContactsByDateRange("2024-01-01","2026-12-31");

        assertNotNull(contacts);

        LocalDate start = LocalDate.parse("2024-01-01");
        LocalDate end = LocalDate.parse("2026-12-31");

        boolean validRange = contacts.stream()
                .allMatch(contact ->
                        !contact.getDateAdded().isBefore(start) &&
                        !contact.getDateAdded().isAfter(end)
                );

        assertTrue(validRange);
    }


    // UC19
    @Test
    void testCountContactsByCity() {

        Map<String, Integer> cityCount =
                databaseService.getContactCountByCity();

        assertNotNull(cityCount);
    }


    // UC20
    @Test
    void testAddContactToDatabase() {

        Contact contact = new Contact(
                "TestUser",
                "Demo",
                "Indore",
                "Indore",
                "MP",
                "452001",
                "9999999999",
                "testuser@gmail.com",
                LocalDate.now()
        );

        boolean result = databaseService.addContact(contact);

        assertTrue(result);
    }
}
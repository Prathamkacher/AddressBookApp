package com.addressbook;

import com.addressbook.model.Contact;
import com.addressbook.service.DatabaseService;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class AddressBookSystemApplicationTests {

    DatabaseService databaseService = new DatabaseService();

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
                        "pratham@gmail.com"
                );

        assertEquals(expectedContact, dbContact);
    }
}
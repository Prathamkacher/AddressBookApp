package com.addressbook.service;

import com.addressbook.model.Contact;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DatabaseService {

    private static final String URL =
            "jdbc:mysql://localhost:3306/addressbook";

    private static final String USER = "root";

    private static final String PASSWORD = "root";

    public List<Contact> getAllContacts() {

        List<Contact> contacts = new ArrayList<>();

        try {

            Connection connection =
                    DriverManager.getConnection(URL, USER, PASSWORD);

            Statement statement =
                    connection.createStatement();

            String query = "SELECT * FROM contacts";

            ResultSet rs = statement.executeQuery(query);

            while (rs.next()) {

                Contact contact = new Contact(

                        rs.getString("first_name"),
                        rs.getString("last_name"),
                        rs.getString("address"),
                        rs.getString("city"),
                        rs.getString("state"),
                        rs.getString("zip"),
                        rs.getString("phone"),
                        rs.getString("email")
                );

                contacts.add(contact);
            }

            connection.close();

        } catch (Exception e) {

            System.out.println("Database Error: " + e.getMessage());
        }

        return contacts;
    }
}
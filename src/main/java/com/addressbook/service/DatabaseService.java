package com.addressbook.service;

import com.addressbook.model.Contact;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class DatabaseService {

    private static final String URL =
            "jdbc:mysql://localhost:3306/addressbook";

    private static final String USER = "root";

    private static final String PASSWORD = "root";

    public Connection getConnection() throws SQLException {

        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    public List<Contact> getAllContacts() {

        List<Contact> contacts = new ArrayList<>();

        try (Connection connection = getConnection();
             Statement statement = connection.createStatement()) {

            ResultSet rs = statement.executeQuery("SELECT * FROM contacts");

            while (rs.next()) {

                Contact contact = new Contact(

                        rs.getString("first_name"),
                        rs.getString("last_name"),
                        rs.getString("address"),
                        rs.getString("city"),
                        rs.getString("state"),
                        rs.getString("zip"),
                        rs.getString("phone"),
                        rs.getString("email"),
                        rs.getDate("date_added").toLocalDate()
                );

                contacts.add(contact);
            }

        } catch (Exception e) {

            System.out.println("DB Error: " + e.getMessage());
        }

        return contacts;
    }

    public void updateContactCity(String firstName, String city) {

        String query = "UPDATE contacts SET city=? WHERE first_name=?";

        try (Connection connection = getConnection();
             PreparedStatement ps = connection.prepareStatement(query)) {

            ps.setString(1, city);
            ps.setString(2, firstName);

            ps.executeUpdate();

        } catch (Exception e) {

            System.out.println("Update Error: " + e.getMessage());
        }
    }

    public Contact getContactByName(String name) {

        String query = "SELECT * FROM contacts WHERE first_name=?";

        try (Connection connection = getConnection();
             PreparedStatement ps = connection.prepareStatement(query)) {

            ps.setString(1, name);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                return new Contact(

                        rs.getString("first_name"),
                        rs.getString("last_name"),
                        rs.getString("address"),
                        rs.getString("city"),
                        rs.getString("state"),
                        rs.getString("zip"),
                        rs.getString("phone"),
                        rs.getString("email"),
                        rs.getDate("date_added").toLocalDate()
                );
            }

        } catch (Exception e) {

            System.out.println("Fetch Error: " + e.getMessage());
        }

        return null;
    }

    // UC18
    public List<Contact> getContactsByDateRange(String startDate, String endDate) {

        List<Contact> contacts = new ArrayList<>();

        String query = "SELECT * FROM contacts WHERE date_added BETWEEN ? AND ?";

        try (Connection connection = getConnection();
             PreparedStatement ps = connection.prepareStatement(query)) {

            ps.setString(1, startDate);
            ps.setString(2, endDate);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                Contact contact = new Contact(

                        rs.getString("first_name"),
                        rs.getString("last_name"),
                        rs.getString("address"),
                        rs.getString("city"),
                        rs.getString("state"),
                        rs.getString("zip"),
                        rs.getString("phone"),
                        rs.getString("email"),
                        rs.getDate("date_added").toLocalDate()
                );

                contacts.add(contact);
            }

        } catch (Exception e) {

            System.out.println("Date Range Fetch Error: " + e.getMessage());
        }

        return contacts;
    }
}
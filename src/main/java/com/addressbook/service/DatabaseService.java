package com.addressbook.service;

import com.addressbook.model.Contact;
import java.sql.Date;
import java.sql.*;
import java.util.*;

public class DatabaseService {

    private static final String URL =
            "jdbc:mysql://localhost:3306/addressbook";

    private static final String USER = "root";

    private static final String PASSWORD = "root";

    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }


    // UC16
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


    // UC17
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


    // UC17
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


    // UC19
    public Map<String, Integer> getContactCountByCity() {

        Map<String, Integer> cityCount = new HashMap<>();

        String query = "SELECT city, COUNT(*) AS total FROM contacts GROUP BY city";

        try (Connection connection = getConnection();
             Statement statement = connection.createStatement()) {

            ResultSet rs = statement.executeQuery(query);

            while (rs.next()) {

                cityCount.put(
                        rs.getString("city"),
                        rs.getInt("total")
                );
            }

        } catch (Exception e) {
            System.out.println("City Count Error: " + e.getMessage());
        }

        return cityCount;
    }


    // UC19
    public Map<String, Integer> getContactCountByState() {

        Map<String, Integer> stateCount = new HashMap<>();

        String query = "SELECT state, COUNT(*) AS total FROM contacts GROUP BY state";

        try (Connection connection = getConnection();
             Statement statement = connection.createStatement()) {

            ResultSet rs = statement.executeQuery(query);

            while (rs.next()) {

                stateCount.put(
                        rs.getString("state"),
                        rs.getInt("total")
                );
            }

        } catch (Exception e) {
            System.out.println("State Count Error: " + e.getMessage());
        }

        return stateCount;
    }


    // UC20 - Add new contact using DB Transaction
    public boolean addContact(Contact contact) {

        String query = "INSERT INTO contacts " +
                "(first_name,last_name,address,city,state,zip,phone,email,date_added) " +
                "VALUES (?,?,?,?,?,?,?,?,?)";

        try (Connection connection = getConnection();
             PreparedStatement ps = connection.prepareStatement(query)) {

            connection.setAutoCommit(false);

            ps.setString(1, contact.getFirstName());
            ps.setString(2, contact.getLastName());
            ps.setString(3, contact.getAddress());
            ps.setString(4, contact.getCity());
            ps.setString(5, contact.getState());
            ps.setString(6, contact.getZip());
            ps.setString(7, contact.getPhoneNumber());
            ps.setString(8, contact.getEmail());
            ps.setDate(9, Date.valueOf(contact.getDateAdded()));

            ps.executeUpdate();

            connection.commit();

            return true;

        } catch (Exception e) {

            System.out.println("Insert Error: " + e.getMessage());
        }

        return false;
    }
}
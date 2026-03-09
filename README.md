# Address Book Application
---
---

## 📇 UC1 – Create Contact in Address Book

## Description  
This use case implements the ability to create a contact in the Address Book using object-oriented programming principles.

## Objective  
To create a `Contact` object containing:
- First Name
- Last Name
- Address
- City
- State
- Zip
- Phone Number
- Email

## Implementation Flow  
1. Spring Boot application starts  
2. `AddressBookMain.start()` method is executed  
3. A `Contact` object is created using the constructor  
4. Contact details are displayed using the overridden `toString()` method  

## Key Concepts  
- Object-Oriented Programming (OOP)  
- Encapsulation using private fields  
- Constructor-based object creation  
- Overriding `toString()` for readable output  
- Clean project structure and naming conventions  

🔗 _Code Link:_  
👉 [UC1 – Create Contact](https://github.com/Prathamkacher/AddressBookApp/tree/feature/UC1-create-contact)

---

## 📇 UC2 – Add Contact Using Console Input

## Description  
This use case implements the ability to add a new contact to the Address Book using console input and object-oriented design.

## Objective  
To allow the user to enter contact details through the console and create a `ContactPerson` object that is stored in the Address Book.

## Implementation Flow  
1. Spring Boot application starts  
2. `AddressBookMain.start()` method is executed  
3. User enters contact details using the console  
4. A `ContactPerson` object is created using the provided details  
5. The contact is added to the Address Book using the service class  
6. Contact details are displayed using `toString()`

## Key Concepts  
- Object-Oriented Programming (OOP)  
- Relationship between `AddressBook` and `ContactPerson`  
- Console input using `Scanner`  
- Separation of layers (Model, Service, Main)  
- Clean code structure and naming conventions  

🔗 _Code Link:_  
👉 [UC2 – Add Contact](https://github.com/Prathamkacher/AddressBookApp/tree/feature/UC2-add-contact)

---

## 📇 UC3 – Edit Existing Contact Using Name

## Description  
This use case implements the ability to edit the details of an existing contact in the Address Book using the contact's name.

## Objective  
To allow the user to search for an existing contact by name and update their details through console input.

## Implementation Flow  
1. Spring Boot application starts  
2. `AddressBookMain.start()` method is executed  
3. User enters the name of the contact to edit  
4. The Address Book searches for the matching contact  
5. If the contact is found, the user updates the required details through the console  
6. The updated contact information is saved and displayed  

## Key Concepts  
- Object-Oriented Programming (OOP)  
- Searching contacts using name  
- Updating object data  
- Console input using `Scanner`  
- Separation of layers (Model, Service, Main)

🔗 _Code Link:_  
👉 [UC3 – Edit Contact](https://github.com/Prathamkacher/AddressBookApp/tree/feature/UC3-edit-contact)

---

## 📇 UC4 – Delete Contact Using Name

## Description  
This use case implements the ability to delete an existing contact from the Address Book using the contact's name.

## Objective  
To allow the user to search for a contact by name and remove that contact from the Address Book through console input.

## Implementation Flow  
1. Spring Boot application starts  
2. `AddressBookMain.start()` method is executed  
3. User enters the name of the contact to delete  
4. The Address Book searches for the contact in the contact list  
5. If the contact is found, it is removed from the Address Book  
6. The updated contact list is displayed  

## Key Concepts  
- Object-Oriented Programming (OOP)  
- Searching objects in a collection  
- Removing objects from a list  
- Console input using `Scanner`  
- Separation of layers (Model, Service, Main)

🔗 _Code Link:_  
👉 [UC4 – Delete Contact](https://github.com/Prathamkacher/AddressBookApp/tree/feature/UC4-delete-contact)

---
## 📇 UC5 – Add Multiple Contacts to Address Book

## Description  
This use case implements the ability to add multiple contacts to the Address Book using console input. Each contact is added one at a time and stored using a collection.

## Objective  
To allow the user to repeatedly enter contact details and store multiple contacts in the Address Book using a collection class.

## Implementation Flow  
1. Spring Boot application starts  
2. `AddressBookMain.start()` method is executed  
3. User enters contact details through the console  
4. A `Contact` object is created using the provided details  
5. The contact is added to the Address Book collection  
6. The process repeats to allow adding multiple contacts  
7. All stored contacts are displayed

## Key Concepts  
- Object-Oriented Programming (OOP)  
- Managing multiple objects using a collection (`ArrayList`)  
- Looping to accept multiple inputs  
- Console input using `Scanner`  
- Separation of layers (Model, Service, Main)

🔗 _Code Link:_  
👉 [UC5 – Add Multiple Contacts](https://github.com/Prathamkacher/AddressBookApp/tree/feature/UC5-add-multiple-contacts)

---
## 📇 UC6 – Add Multiple Address Books

## Description  
This use case refactors the system to support multiple Address Books. Each Address Book is identified by a unique name and managed within the system using a dictionary structure.

## Objective  
To allow the user to create multiple Address Books and store them in a dictionary where the Address Book name acts as the key.

## Implementation Flow  
1. Spring Boot application starts  
2. `AddressBookMain.start()` method is executed  
3. User enters a name for a new Address Book through the console  
4. A new Address Book is created  
5. The Address Book is stored in a dictionary using its name as the key  
6. Multiple Address Books can be added and managed in the system

## Key Concepts  
- Object-Oriented Programming (OOP)  
- Managing multiple Address Books  
- Dictionary data structure using `HashMap`  
- Key-value mapping (`AddressBookName → AddressBook`)  
- Console input using `Scanner`

🔗 _Code Link:_  
👉 [UC6 – Multiple Address Books](https://github.com/Prathamkacher/AddressBookApp/tree/feature/UC6-multiple-adressbooks)

---

## 📇 UC7 – Prevent Duplicate Contact Entries

## Description  
This use case ensures that duplicate entries of the same person are not allowed within a particular Address Book. Before adding a new contact, the system checks whether a contact with the same name already exists.

## Objective  
To validate new contact entries and prevent duplicate contacts from being added to the Address Book.

## Implementation Flow  
1. Spring Boot application starts  
2. `AddressBookMain.start()` method is executed  
3. User enters contact details through the console  
4. The Address Book checks if a contact with the same name already exists  
5. If the contact exists, the system displays a duplicate entry message  
6. If the contact does not exist, the new contact is added to the Address Book  

## Key Concepts  
- Object-Oriented Programming (OOP)  
- Data validation before insertion  
- Searching objects within a collection  
- Preventing duplicate entries  
- Console input using `Scanner`

🔗 _Code Link:_  
👉 [UC7 – Prevent Duplicate Contact](https://github.com/Prathamkacher/AddressBookApp/tree/feature/UC7-prevent-duplicate-contact)

---
## 📇 UC8 – Search Person by City or State Across Multiple Address Books

## Description  
This use case allows searching for a person in a specific city or state across multiple Address Books. The search operation utilizes Java Streams to efficiently filter contacts.

## Objective  
To enable users to search for contacts based on city or state and display all matching persons from multiple Address Books.

## Implementation Flow  
1. Spring Boot application starts  
2. `AddressBookMain.start()` method is executed  
3. User enters the city or state to search for  
4. The system retrieves all Address Books stored in the dictionary  
5. Java Streams are used to filter contacts matching the given city or state  
6. All matching persons are displayed as search results  

## Key Concepts  
- Java Streams API  
- Filtering collections using `stream().filter()`  
- Managing multiple Address Books using `HashMap`  
- Searching across nested collections  
- Console input using `Scanner`

🔗 _Code Link:_  
👉 [UC8 – Search Person by City or State](https://github.com/Prathamkacher/AddressBookApp/tree/feature/UC8-search-person-by-city-or-state)

---

## 📇 UC9 – View Persons by City or State

## Description  
This use case allows viewing persons grouped by city or state. The system maintains a dictionary mapping city and state to persons and uses Java Streams to retrieve and display contacts.

## Objective  
To organize contacts based on city and state and allow users to view all persons belonging to a particular city or state.

## Implementation Flow  
1. Spring Boot application starts  
2. `AddressBookMain.start()` method is executed  
3. Contacts are added to Address Books  
4. Dictionaries are maintained for:
   - City → Person
   - State → Person  
5. Java Streams are used to filter and retrieve persons belonging to a given city or state  
6. All matching persons are displayed

## Key Concepts  
- Java Streams API  
- Using `HashMap` as a dictionary  
- Mapping City → List<Person> and State → List<Person>  
- Filtering and collecting data using streams  
- Managing collections efficiently

🔗 _Code Link:_  
👉 [UC9 – View Persons by City or State](https://github.com/Prathamkacher/AddressBookApp/tree/feature/UC9-view-persons-by-city-or-state)

---

## 📇 UC10 – Count Contacts by City or State

## Description  
This use case allows counting the number of contact persons belonging to a particular city or state across Address Books. The counting operation is performed using Java Streams.

## Objective  
To determine and display the number of contacts available in a specific city or state.

## Implementation Flow  
1. Spring Boot application starts  
2. `AddressBookMain.start()` method is executed  
3. User enters the city or state to search  
4. The system retrieves contacts from the Address Books  
5. Java Streams are used to filter contacts based on city or state  
6. The total number of matching contacts is counted and displayed  

## Key Concepts  
- Java Streams API  
- Counting elements using `stream().count()`  
- Filtering collections using `filter()`  
- Managing contacts using collections  
- Efficient data processing using streams  

🔗 _Code Link:_  
👉 [UC10 – Count Contacts by City or State](https://github.com/Prathamkacher/AddressBookApp/tree/feature/UC10-count-contacts-by-city-or-state)

---

## 📇 UC11 – Sort Contacts Alphabetically by Name

## Description  
This use case implements the ability to sort contact entries in the Address Book alphabetically based on the person's name. The sorting is performed using the Java Collection Library and Java Streams.

## Objective  
To display contact details sorted alphabetically by the person's name using console output.

## Implementation Flow  
1. Spring Boot application starts  
2. `AddressBookMain.start()` method is executed  
3. Contacts are retrieved from the Address Book collection  
4. Java Streams are used to sort contacts alphabetically by name  
5. The sorted contact list is displayed in the console using the overridden `toString()` method  

## Key Concepts  
- Java Streams API  
- Sorting collections using `sorted()`  
- Comparator for alphabetical sorting  
- Overriding `toString()` for formatted output  
- Console output for displaying sorted results  

🔗 _Code Link:_  
👉 [UC11 – Sort Contacts by Name](https://github.com/Prathamkacher/AddressBookApp/tree/feature/UC11-sort-contacts-by-name)

---
## 📇 UC12 – Sort Contacts by City, State, or Zip

## Description  
This use case provides the ability to sort contact entries in the Address Book based on City, State, or Zip. The sorting is implemented using the Java Collection Library and Java Streams.

## Objective  
To allow users to view contacts sorted by City, State, or Zip using console output.

## Implementation Flow  
1. Spring Boot application starts  
2. `AddressBookMain.start()` method is executed  
3. Contacts are retrieved from the Address Book collection  
4. Sorting functions are used to arrange contacts by City, State, or Zip  
5. Java Streams are used to perform sorting operations  
6. The sorted contact list is displayed in the console  

## Key Concepts  
- Java Streams API  
- Sorting collections using `sorted()`  
- Comparator for sorting by City, State, and Zip  
- Use of Collection Library for data management  
- Console output for displaying sorted results  

🔗 _Code Link:_  
👉 [UC12 – Sort Contacts by City, State, or Zip](https://github.com/Prathamkacher/AddressBookApp/tree/feature/UC12-sort-contacts-by-city-state-zip)

---

## 📇 UC13 – Read and Write Address Book to File

## Description  
This use case enables the Address Book application to store and retrieve contact details using file operations. The system writes contact information to a file and reads the stored data using Java File I/O.

## Objective  
To persist Address Book contacts by writing them to a file and reading them back when required.

## Implementation Flow  
1. Spring Boot application starts  
2. `AddressBookMain.start()` method is executed  
3. Contacts are retrieved from the Address Book collection  
4. Contact details are written to a file using Java File I/O  
5. The file can be read to retrieve stored contact information  
6. The retrieved contacts are displayed in the console  

## Key Concepts  
- Java File I/O  
- Writing data using `FileWriter` / `BufferedWriter`  
- Reading data using `FileReader` / `BufferedReader`  
- Persistent storage of contacts  
- Handling file operations in Java  

🔗 _Code Link:_  
👉 [UC13 – Address Book File IO](https://github.com/Prathamkacher/AddressBookApp/tree/feature/UC13-read-write-addressbook-file-io)

---

## 📇 UC14 – Read and Write Address Book as CSV File

## Description  
This use case enables the Address Book application to store and retrieve contact details in CSV format. The system uses the OpenCSV library to write contact information to a CSV file and read it back when required.

## Objective  
To persist Address Book contacts in a CSV file format using the OpenCSV library.

## Implementation Flow  
1. Spring Boot application starts  
2. `AddressBookMain.start()` method is executed  
3. Contacts are retrieved from the Address Book collection  
4. Contact details are written to a CSV file using the OpenCSV library  
5. The CSV file can be read to retrieve stored contact information  
6. The retrieved contacts are displayed in the console  

## Key Concepts  
- CSV file handling in Java  
- Using the OpenCSV library  
- Writing data using `CSVWriter`  
- Reading data using `CSVReader`  
- Managing structured data in CSV format  

🔗 _Code Link:_  
👉 [UC14 – Address Book CSV IO](https://github.com/Prathamkacher/AddressBookApp/tree/feature/UC14-read-write-addressbook-csv/src)

---

## 📇 UC15 – Read and Write Address Book as JSON File

## Description  
This use case enables the Address Book application to store and retrieve contact details in JSON format. The system uses the GSON library to serialize contact objects into JSON and deserialize them back into Java objects.

## Objective  
To persist Address Book contacts in a JSON file using the GSON library.

## Implementation Flow  
1. Spring Boot application starts  
2. `AddressBookMain.start()` method is executed  
3. Contacts are retrieved from the Address Book collection  
4. Contact objects are converted to JSON format using the GSON library  
5. The JSON data is written to a file  
6. The JSON file can be read and converted back into contact objects  
7. The retrieved contacts are displayed in the console  

## Key Concepts  
- JSON data format  
- Object serialization and deserialization  
- Using the GSON library  
- Writing JSON using `Gson.toJson()`  
- Reading JSON using `Gson.fromJson()`  

🔗 _Code Link:_  
👉 [UC15 – Address Book JSON IO](https://github.com/Prathamkacher/AddressBookApp/tree/feature/UC15-read-write-addressbook-json)

---

## 📇 UC16 – Retrieve Address Book Entries from Database

## Description  
This use case enables the Address Book Service to retrieve all contact entries stored in a database. JDBC is used to establish a connection with the database and fetch the records. The retrieved entries are mapped to the Address Book entities defined in the ER model.

## Objective  
To connect the Address Book application to a database using JDBC and retrieve all stored contact records.

## Implementation Flow  
1. Address Book Service establishes a database connection using JDBC  
2. A query is executed to retrieve all contact records from the database  
3. The retrieved data is mapped to Address Book entity objects  
4. The contact list is returned by the Address Book Service  
5. JUnit tests are written following the TDD approach to validate database retrieval  

## Key Concepts  
- JDBC database connectivity  
- SQL queries for data retrieval  
- Mapping database records to Java objects  
- Implementing entities based on ER model  
- Test Driven Development (TDD)  
- Unit testing using JUnit  

🔗 _Code Link:_  
👉 [UC16 – Retrieve Address Book Entries from DB](https://github.com/Prathamkacher/AddressBookApp/tree/feature/UC16-retrieve-contacts-from-database)

---

## 📇 UC17 – Update Contact Information and Sync with Database

## Description  
This use case refactors the Address Book system to support updating contact information stored in the database. The Address Book Service updates a person's contact details using JDBC and ensures that the contact information in memory remains synchronized with the database.

## Objective  
To update a person's contact information in the Address Book and verify through JUnit tests that the updated data in memory is consistent with the data stored in the database.

## Implementation Flow  
1. Address Book Service establishes a database connection using JDBC  
2. User provides the person's name whose contact information needs to be updated  
3. A SQL update query is executed using `PreparedStatement`  
4. The updated contact information is retrieved from the database  
5. The in-memory contact object is synchronized with the updated database record  
6. JUnit tests verify that the in-memory data matches the database data using the overridden `equals()` method  

## Key Concepts  
- JDBC CRUD operations  
- Using `PreparedStatement` for secure database queries  
- Updating records in a relational database  
- Synchronizing in-memory objects with database data  
- Implementing `equals()` for object comparison  
- Test Driven Development (TDD) with JUnit  

🔗 _Code Link:_  
👉 [UC17 – Update Contact and Sync with DB](https://github.com/Prathamkacher/AddressBookApp/tree/feature/UC17-update-contact-and-sync-with-db)

---

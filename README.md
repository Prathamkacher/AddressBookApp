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

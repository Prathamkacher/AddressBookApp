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

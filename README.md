# Transaction Propagation Tutorial

This project is a tutorial on transaction propagation behaviors in Spring Data JPA.

## Technologies Used

- Java
- Spring Boot
- Spring Data JPA
- Maven

## Project Structure

The project is divided into three main packages:

- `com.example.transactionpropagations.controller`: Contains the `TransactionPropagationController` class which exposes endpoints to test different transaction propagation behaviors.
- `com.example.transactionpropagations.service`: Contains the `LibraryService` class which contains methods demonstrating different transaction propagation behaviors.
- `com.example.transactionpropagations.repo`: Contains the `AuthorRepository` and `BookRepository` interfaces for database operations.

## Transaction Propagation Behaviors

The project demonstrates the following transaction propagation behaviors:

- REQUIRED: The method will execute within a transaction if the caller is already in a transaction. Otherwise, a new transaction will be created for the method.
- SUPPORTS: The method will execute within a transaction if the caller is already in a transaction. Otherwise, the method will execute outside of a transaction.
- MANDATORY: The method will execute within a transaction if the caller is already in a transaction. Otherwise, an exception will be thrown.
- REQUIRES_NEW: The method will be executed in a new transaction, regardless of the transactional context of the caller.
- NOT_SUPPORTED: If the caller is already in a transaction, the transaction will be suspended and the method will execute outside of the transaction. Otherwise, the method will execute outside of a transaction.
- NEVER: If the caller is already in a transaction, an exception will be thrown. Otherwise, the method will execute outside of a transaction.
- NESTED: The method will execute within a transaction if the caller is already in a transaction. Otherwise, a new transaction will be created for the method.

## Running the Project

To run the project, use the following command:

```bash
mvn spring-boot:run
```

## Endpoints

The following endpoints are available to test the transaction propagation behaviors:

- `/transaction/propagation/required`
- `/transaction/propagation/supports?withTransaction={true|false}`
- `/transaction/propagation/mandatory?withTransaction={true|false}`
- `/transaction/propagation/requires-new?withTransaction={true|false}`
- `/transaction/propagation/not-supported?withTransaction={true|false}`
- `/transaction/propagation/never?withTransaction={true|false}`
- `/transaction/propagation/nested?withTransaction={true|false}`

Each endpoint corresponds to a method in the `LibraryService` class demonstrating the respective transaction propagation behavior.

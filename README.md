##Barcode Management Project

This project is a Spring Boot 3 application designed to manage barcode records with a focus on Object-Oriented Programming (OOP) principles and Clean Code practices. The application is integrated with a React frontend and uses PostgreSQL as the database.

Features

OOP and Clean Code Principles: The project adheres to OOP concepts, ensuring modularity, readability, and maintainability. The code is organized in a way that promotes clean architecture.
RESTful API with JSON Responses: All responses follow the JSON format standard, allowing for consistent and structured data exchange.
DTO-based Data Transfer: Data is managed using Data Transfer Objects (DTOs) to ensure efficient and secure communication between layers and to keep domain entities separate from exposed API models.
Validation and Security: User inputs are validated using Spring Validation to enforce data integrity and prevent invalid data entries.
Comprehensive Exception Management: The application incorporates structured exception handling to provide meaningful error messages and maintain a smooth user experience.
Technologies Used

Backend: Spring Boot 3
Frontend: React
Database: PostgreSQL
Data Transfer and Validation: DTOs and Spring Validation
Setup Instructions

Clone the repository
Set up the PostgreSQL database and configure it in application.properties.
Run the Spring Boot application with ./mvnw spring-boot:run.
Start the React frontend.

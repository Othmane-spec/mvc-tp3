# MVC TP3 – Product Management Application

A Spring Boot MVC application for managing products with authentication and authorization using Spring Security. The application demonstrates the use of the MVC architecture, Thymeleaf templates, Spring Data JPA, validation, and an in-memory H2 database.

---

## Table of Contents

- [Introduction](#introduction)
- [Features](#features)
- [Technologies Used](#technologies-used)
- [Project Structure](#project-structure)
- [Installation](#installation)
- [Running the Application](#running-the-application)
- [Usage](#usage)
- [Security](#security)
- [Validation Rules](#validation-rules)
- [Database Configuration](#database-configuration)
- [Dependencies](#dependencies)
- [Troubleshooting](#troubleshooting)
- [Contributors](#contributors)
- [License](#license)

---

## Introduction

MVC TP3 is a simple product management system developed using **Spring Boot** following the **Model–View–Controller (MVC)** design pattern.

The application allows users to:

- View products
- Add new products
- Delete products
- Authenticate using Spring Security
- Access different functionalities depending on their roles

This project is intended for educational purposes to demonstrate how Spring technologies work together in a complete web application.

---

## Features

### Product Management

- Display a list of products.
- Add new products.
- Delete existing products.

### Validation

Product data is validated before being saved.

### Security

- User authentication.
- Role-based authorization.
- Custom login page.
- Unauthorized access handling.

### User Interface

- Thymeleaf templates.
- Bootstrap integration.
- Responsive pages.

### Database

- H2 in-memory database.
- JPA/Hibernate persistence.

---

## Technologies Used

| Technology | Version |
|------------|----------|
| Java | 21 |
| Spring Boot | 3.5.15 |
| Spring MVC | Included |
| Spring Data JPA | Included |
| Spring Security | Included |
| Thymeleaf | Included |
| Bootstrap | 5.3.8 |
| H2 Database | Runtime |
| Maven | Wrapper Included |
| Lombok | Included |

---

## Project Structure

```text
mvc-tp3
│
├── src/main/java/net/essaimak/mvctp3
│   ├── entities
│   │   └── Product.java
│   ├── repository
│   │   └── ProductRepository.java
│   ├── sec
│   │   └── SecurityConfig.java
│   ├── web
│   │   └── ProductController.java
│   └── MvcTp3Application.java
│
├── src/main/resources
│   ├── application.properties
│   └── templates
│       ├── layout1.html
│       ├── login.html
│       ├── products.html
│       ├── new-product.html
│       └── notAuthorized.html
│
├── pom.xml
├── mvnw
└── mvnw.cmd
```

---

## Installation

### Prerequisites

Make sure you have installed:

- Java 21
- Maven

Check versions:

```bash
java -version
mvn -version
```

---

## Running the Application

### Clone the repository

```bash
git clone https://github.com/Othmane-spec/mvc-tp3.git
cd mvc-tp3
```

### Run using Maven Wrapper

Linux/macOS:

```bash
./mvnw spring-boot:run
```

Windows:

```cmd
mvnw.cmd spring-boot:run
```

### Build the project

```bash
./mvnw clean install
```

### Run the generated JAR

```bash
java -jar target/mvc-tp3-0.0.1-SNAPSHOT.jar
```

---

## Usage

After starting the application, open:

```text
http://localhost:8083
```

### Available Routes

| Endpoint | Description |
|-----------|-------------|
| `/` | Redirects to products page |
| `/user/index` | View products |
| `/admin/newProduct` | Product creation form |
| `/admin/saveProduct` | Save a product |
| `/admin/delete?id={id}` | Delete a product |
| `/login` | Login page |
| `/logout` | Logout |
| `/notAuthorized` | Unauthorized page |

---

## Security

Spring Security is configured through:

```text
SecurityConfig.java
```

The application supports:

- Authentication
- Authorization
- Custom login page
- Access restrictions based on user roles

Protected endpoints include administrative operations such as:

- Product creation
- Product deletion

---

## Validation Rules

The `Product` entity applies the following constraints:

### Name

```java
@NotEmpty
@Size(min = 3, max = 50)
```

Requirements:

- Cannot be empty.
- Must contain between 3 and 50 characters.

### Price

```java
@Min(0)
```

Requirements:

- Must be greater than or equal to 0.

### Quantity

```java
@Min(1)
```

Requirements:

- Must be at least 1.

---

## Database Configuration

Current configuration:

```properties
spring.datasource.url=jdbc:h2:mem:products-db
spring.datasource.username=sa
spring.datasource.password=
spring.jpa.hibernate.ddl-auto=update
spring.h2.console.enabled=true
server.port=8083
```

### Access H2 Console

Open:

```text
http://localhost:8083/h2-console
```

Use:

```text
JDBC URL : jdbc:h2:mem:products-db
User     : sa
Password :
```

---

## Dependencies

Main dependencies used:

- spring-boot-starter-web
- spring-boot-starter-data-jpa
- spring-boot-starter-security
- spring-boot-starter-thymeleaf
- spring-boot-starter-validation
- thymeleaf-layout-dialect
- thymeleaf-extras-springsecurity6
- H2 Database
- MySQL Connector/J
- Lombok
- Bootstrap WebJar
- Spring Boot Test
- Spring Security Test

---

## Troubleshooting

### Port Already in Use

If port `8083` is occupied:

Change:

```properties
server.port=8083
```

to another available port.

---

### H2 Console Not Accessible

Ensure:

```properties
spring.h2.console.enabled=true
```

is enabled.

---

### Validation Errors

Verify that:

- Product name contains at least 3 characters.
- Price is not negative.
- Quantity is greater than or equal to 1.

---

## Contributors

Developed as part of an MVC practical assignment (TP3).

Repository owner:

- Othmane-spec

---

## License

This project currently does not specify a license.

If you intend to distribute or reuse this project, consider adding a `LICENSE` file such as MIT, Apache 2.0, or GPL.

---

## Educational Objectives

This project demonstrates:

- Spring Boot application setup
- MVC architecture implementation
- CRUD operations with Spring Data JPA
- Form validation using Jakarta Validation
- Authentication and authorization using Spring Security
- Server-side rendering with Thymeleaf
- Integration of Bootstrap for the user interface
- Usage of an H2 in-memory database for development

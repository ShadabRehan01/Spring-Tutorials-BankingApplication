# 📘 This Project Belongs to Spring Boot Tutorials

Welcome to the official project repository for **Spring-Tutorials-BankingApplication**.  
This project is created for learning purposes under the **Spring Boot Tutorials** series.

---

# 💰 Spring-Tutorials-BankingApplication

A simple and clean **Spring Boot MVC-based Banking Application** that demonstrates core concepts like layered architecture, REST APIs, DTO usage, exception handling, and database integration.

---

## 👨‍💻 Author

**Shadab Rehan**  
🔗 LinkedIn Profile - (https://www.linkedin.com/in/shadabrehan) <!-- Replace with your actual LinkedIn URL -->

---

## 📌 Features

- ✅ Create New Bank Account
- 🔍 Get Account By ID
- 💵 Deposit Amount
- 💸 Withdraw Amount
- 📋 Get All Accounts
- ❌ Delete Account By ID
- ⚠️ Custom Exception Handling
- 📦 DTO Pattern and Clean Architecture

---

## 🗂️ Project Structure

com.Banking_App.BankingApplication
├── controllers # REST Controllers
├── services # Business Logic Layer
├── repositories # JPA Repositories
├── entities # JPA Entity Classes
├── dto # Data Transfer Objects
├── exceptions # Custom Exceptions
├── advices # Global Exception Handler
├── config # Configuration (if any)
└── BankingApplication.java # Main Spring Boot Application


---

## 🔗 REST API Endpoints

| Method | Endpoint                     | Description            |
|--------|------------------------------|------------------------|
| POST   | `/api/accounts`              | Create a new account   |
| GET    | `/api/accounts/{id}`         | Get account by ID      |
| PUT    | `/api/accounts/{id}/deposit` | Deposit into account   |
| PUT    | `/api/accounts/{id}/withdraw`| Withdraw from account  |
| GET    | `/api/accounts`              | List all accounts      |
| DELETE | `/api/accounts/{id}`         | Delete account by ID   |

---

## 🛠️ Tech Stack

- **Java 17+**
- **Spring Boot**
- **Spring MVC**
- **Spring Data JPA**
- **Lombok**
- **Hibernate**
- **MySQL / H2**
- **Maven**

---

## ⚠️ Exception Handling

- `AccountNotFoundException`
- `InvalidTransactionException`
- Global handling with `@ControllerAdvice` and `ApiError`

---

## 🚀 Getting Started

### 1. Clone the Repository

```bash
git clone https://github.com/your-username/spring-tutorials-banking-app.git
cd spring-tutorials-banking-app

2. Configure Database
Update application.properties:

spring.datasource.url=jdbc:mysql://localhost:3306/banking_db
spring.datasource.username=root
spring.datasource.password=your_password
spring.jpa.hibernate.ddl-auto=update

You can also use H2 for testing.

3. Run the Application
mvn spring-boot:run
Open: http://localhost:8080

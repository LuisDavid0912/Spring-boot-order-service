# 🧾 Order Management Service API

### Overview  
This project is a **RESTful API** for managing e-commerce orders, built with **Spring Boot** and **Java 17**.  
It was developed as part of the **Digital NAO “Spring and Spring Boot in Java for Web Applications”** challenge.

The API provides a complete set of endpoints to perform **CRUD (Create, Read, Update, Delete)** operations on orders, using an in-memory **H2 database** for development purposes.

---

## 🚀 Key Features

- **CRUD Operations:** Full support for creating, reading, updating, and deleting orders.  
- **In-Memory Database:** Uses H2 database, automatically configured and launched with the application.  
- **RESTful Architecture:** Follows clean design practices for scalable web APIs.  
- **Organized Structure:** Follows a layered pattern — *Controller → Service → Repository → Model* — for better maintainability.

---

## 🧰 Technologies Used

| Technology | Purpose |
|-------------|----------|
| **Java 17** | Core programming language |
| **Spring Boot 3** | Framework for rapid API development |
| **Spring Data JPA** | Simplified database access |
| **H2 Database** | In-memory database for testing |
| **Maven** | Build and dependency management |
| **Lombok** | Reduces boilerplate code |

---

## ⚙️ Prerequisites

Before you begin, make sure you have:

- ☕ **JDK 17 (Java Development Kit)**  
- 🧩 **Apache Maven**  
- 🌀 **Git**  
- 📬 **Postman** (or any API client)

---

## ▶️ How to Run the Project

### 1️⃣ Clone the Repository

```bash
git clone https://github.com/LuisDavid0912/Spring-boot-order-service.git
cd order-management
```

2️⃣ Build and Run the Application

This project uses the Maven Wrapper (mvnw), so you don’t need a global Maven installation.

🖥️ On macOS/Linux:

```bash
./mvnw spring-boot:run
```

💻 On Windows:

```bash
.\mvnw.cmd spring-boot:run
```

When it starts successfully, the server runs at:
👉 http://localhost:8080

## 📡 Using the API

You can test all endpoints using the provided Postman collection file:
Order Service API.postman_collection.json

🔗 Endpoints
Method	Endpoint	Description
POST	/api/orders	Create a new order
GET	/api/orders	Retrieve all orders
GET	/api/orders/{id}	Get an order by ID
PUT	/api/orders/{id}	Update an existing order
DELETE	/api/orders/{id}	Delete an order


## 🗃️ H2 Database Console
Item	Value
URL	http://localhost:8080/h2-console

JDBC URL	jdbc:h2:mem:testdb
Username	sa
Password	password


## 🧠 Sprint 1 Team Decisions


### 🧩 Technology Stack

Used Spring Boot 3 with Java 17 as required by the challenge — modern, efficient, and well-supported for enterprise-grade web apps.

### 🗄️ Database

Selected H2 as the in-memory database for Sprint 1 to simplify setup and accelerate development.
In Sprint 2, the goal is to integrate PostgreSQL via environment profiles for a production-ready setup.

### 🧱 Architecture

Implemented a layered architecture (Controller → Service → Repository) for clarity, scalability, and maintainability.
This separation of concerns makes it easier to add new features or switch databases later.


POST

<img width="1077" height="436" alt="Screenshot 2025-10-16 at 8 48 19 p m" src="https://github.com/user-attachments/assets/973a4829-5248-4b54-baa7-8820fa4e29d1" />

POSTED
<img width="724" height="834" alt="Screenshot 2025-10-16 at 12 01 42 p m" src="https://github.com/user-attachments/assets/9192f1d6-a5fa-4f57-a0bb-a1a67a2a1065" />

PUT
<img width="729" height="796" alt="Screenshot 2025-10-16 at 12 02 22 p m" src="https://github.com/user-attachments/assets/9059ea50-c077-45cb-a5bc-e0687f877ece" />

GET
<img width="716" height="772" alt="Screenshot 2025-10-16 at 12 06 21 p m" src="https://github.com/user-attachments/assets/bd54ef27-9b52-4a35-bf2e-d475acd542a8" />

DELETE
<img width="718" height="632" alt="Screenshot 2025-10-16 at 12 07 33 p m" src="https://github.com/user-attachments/assets/4d3e625d-2478-4d16-bb64-b84b224b3e93" />


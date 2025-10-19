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

## 📄 Professional Services Proposal


This project serves as a clear example of the professional, high-quality software solutions I provide. Below is a sample proposal outlining how I can help your business build a similar robust and scalable backend system.

Luis David Martínez Gutiérrez

Data Engineer & Software Developer

Contact: luisdavidmtz3@gmail.com | Location: Monterrey, N.L., Mexico

Date: October 17, 2025

1. Introduction
My objective is to deliver robust and scalable software solutions that solve critical needs in e-commerce operations. I guarantee high-quality development, on-time delivery, and a great cost-benefit ratio for your company.

2. Project Scope: "Custom Order Management API"
This service includes the design, development, and deployment of a central RESTful API for order management, enabling your system to process transactions reliably, securely, and at scale.

Key Activities:

Activity 1: Design and Development of the Core API with Spring Boot, including CRUD operations (Create, Read, Update, Delete).

Activity 2: Implementation of environment profiles (development, production) to ensure secure operations and prevent production misconfigurations.

Activity 3: Security configuration for sensitive data (e.g., database credentials) using environment variables, avoiding exposure of critical information in the codebase.

Activity 4: Development of a full suite of automated tests (unit and integration) to ensure long-term software quality and stability.

3. Deliverables
Upon project completion, you will receive:

✅ Full Source Code: Hosted in a private Git repository (GitHub/GitLab) with full access for your team.

✅ Interactive API Documentation (Swagger): A self-documented web portal for your developers to easily view and test every API endpoint.

✅ Postman Collection: A ready-to-use file for easily testing all service endpoints.

✅ Technical Handover Session: A meeting to explain the project's architecture and deployment process to your technical team.

4. Estimated Timeline
Phase

Estimated Duration

Phase 1 – Analysis & Architecture Design

1 Week

Phase 2 – Core API Development (CRUD)

2 Weeks

Phase 3 – Environment Setup & Testing

2 Weeks

Phase 4 – Final Delivery & Documentation

1 Week

Total Estimated Time:

6 Weeks

5. Economic Investment
Below are flexible pricing options designed to fit different project needs and budgets. Rates are competitive, reflecting my profile as a recently graduated engineer ready to deliver high-impact solutions.

Option

Description

Price (MXN)

Price (USD)

A: Fixed Project

A flat rate for the entire project scope described above. Ideal for clear, defined budgets.

$65,000

$3,600

B: Hourly Rate

Maximum flexibility. Billed weekly based on hours invested. Perfect for evolving projects.

$300 / hr

$18 / hr

C: Project Plus

Includes the Fixed Project scope plus a 3-month basic support package (up to 5 hours/month).

$68,000

$3,800

Prices shown are for professional services only and do not include IVA, infrastructure costs (servers, domains), or third-party licenses.

6. Payment Conditions
40% advance payment upon proposal acceptance to begin the project.

30% payment upon completion of Phase 2 (Core API Development).

30% final payment upon project delivery.

This quote is valid for 30 days from the date listed above.

7. Client Benefits
Scalable Solution: An architecture designed to grow with your business needs.

Secure Operations: Separation of configurations and secrets management prevents critical failures and protects your data.

High-Quality Software: Automated testing reduces bugs and simplifies future maintenance.

Technical Independence: Comprehensive documentation empowers your in-house team to maintain and evolve the system with ease.

🧠 Sprint 2 Team Decisions
<details>
<summary><strong>Click to expand Sprint 2 decisions and learnings</strong></summary>

🛡️ Implementing Environment Profiles for Security and Flexibility
The primary goal of Sprint 2 was to mature the application's configuration, moving from a single setup to a professional, multi-environment structure. This directly addresses the core problem presented in the challenge narrative, where a misconfiguration in a production environment caused critical failures.

Key Decisions:

Adoption of YAML Configuration (.yml):

Decision: Migrated from a single .properties file to multiple .yml files.

Justification: YAML's hierarchical structure is far superior for managing complex configurations and defining multiple profiles within a single, readable format. It makes the distinction between environments clean and intuitive.

Creation of dev and prod Profiles:

Decision: Created two distinct profiles: application-dev.yml for local development and application-prod.yml for a production-ready setup.

Justification: This separation is crucial. The dev profile is optimized for speed and ease of use (H2 in-memory database, H2 console enabled), while the prod profile is configured for robustness and security (PostgreSQL connection, secrets managed separately). This prevents development tools from ever being active in a production environment.

Securing Credentials with Environment Variables:

Decision: The production database password is not hardcoded. Instead, it is loaded from an environment variable (${DB_PASSWORD}).

Justification: This is the most critical security decision of this sprint. Hardcoding secrets in source code is a major security vulnerability. By using environment variables, the application's code remains secure and can be safely stored in any repository. The actual secrets are managed on the server, completely separate from the codebase, following industry best practices.

</details>

<details>
<summary><strong>Sprint 2: Running with Environment Profiles</strong></summary>

This application is configured with Environment Profiles to separate development (dev) settings from production (prod) settings.

dev profile (default): Uses an in-memory H2 database and enables the H2 console. Perfect for local development.

prod profile: Configured for a PostgreSQL database and secures the database password using an environment variable.

Running with the Production Profile
To run the application using the prod profile, you first need to set the required environment variable and then specify the profile during launch.

1. Set the Environment Variable
This variable holds the database password securely, preventing it from being stored in the source code.

On macOS/Linux:

export DB_PASSWORD="your_secure_password_here"

On Windows:

set DB_PASSWORD="your_secure_password_here"

2. Run the Application with the prod Profile
Use the -Dspring-boot.run.profiles flag to specify the active profile:

On macOS/Linux:

./mvnw spring-boot:run -Dspring-boot.run.profiles=prod

On Windows:

.\mvnw.cmd spring-boot:run -Dspring-boot.run.profiles=prod

The application will now start on port 8081 and attempt to connect to a PostgreSQL database using the credentials you provided.

</details>


# Technical Talks & Interview Code

Packages: `com.talks`, `com.talks.barclays`

Code written live during technical interviews and company talks.

---

## Tricentis Interview Challenge
**File:** `Tricentis.java`

A coding challenge from a Tricentis technical interview:

1. Read a sequence of integers from input
2. Compute and print the **sum** and **average**
3. Print the numbers back in **reverse order**

Demonstrates basic I/O handling, array traversal, and simple arithmetic in Java.

---

## Barclays — Spring Boot Demo Application

Package: `com.talks.barclays`

A minimal **Spring Boot** REST + JPA application skeleton built during a Barclays technical interview. Showcases the standard layered architecture.

### Architecture

```
BankController  (REST layer)
     │
BankService     (Business logic layer)
     │
BankJPA         (Data access layer — Spring Data JPA)
     │
Message         (JPA Entity)
```

### Files

#### `BankSpringbootApp.java`
Main entry point annotated with `@SpringBootApplication`. Bootstraps the embedded server and enables component scanning.

```java
@SpringBootApplication
public class BankSpringbootApp {
    public static void main(String[] args) {
        SpringApplication.run(BankSpringbootApp.class, args);
    }
}
```

---

#### `BankController.java`
REST controller (`@RestController`) exposing bank operation endpoints.

---

#### `Message.java`
JPA entity (`@Entity`) representing a bank message with:

| Field | Type | Description |
|-------|------|-------------|
| `id` | `Long` | Auto-generated primary key |
| `message` | `String` | Message content |
| `requesterId` | `String` | ID of the requesting user |

---

#### `BankJPA.java`
Repository interface extending `JpaRepository<Message, Long>`. Provides standard CRUD operations out of the box — no implementation needed.

---

#### `BankService.java`
`@Service` class containing business logic, injected into the controller via constructor injection.

---

### Tech Stack

| Layer | Technology |
|-------|-----------|
| Framework | Spring Boot |
| REST | Spring MVC (`@RestController`) |
| Persistence | Spring Data JPA + Hibernate |
| Database | Configurable (H2 for dev, any RDBMS for prod) |

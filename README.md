

# 🎸 Band Management System

### Java • Object-Oriented Design • Database Architecture • NLP Integration
Requirements to run:
Java (JDK 23 / Java SE 8+)

NetBeans IDE 21

Microsoft Access 2019

## Overview

The **Band Management System** is a Java-based desktop application designed to model and manage the administrative operations of a music band.

Rather than focusing only on interface design, this project explores:

* Structured object-oriented architecture
* Relational database design
* Data validation and integrity
* Separation of concerns in software systems
* Basic Natural Language Processing (NLP) integration

The system supports full CRUD (Create, Read, Update, Delete) operations for members, applicants, and events, with persistent storage through a relational database.

---

## Motivation

This project was built to explore how real-world administrative systems can be translated into structured and scalable software architecture.

Managing a band involves interconnected entities — people, applications, and scheduled events. Designing a system to model these relationships required deliberate decisions about:

* Class hierarchy
* Data abstraction
* Database normalization
* Controller-to-database interaction
* Error handling and validation

The goal was not just functionality, but thoughtful design.

---

## Technical Architecture

### Object-Oriented Structure

Core domain objects:

* `BandObj`
* `ApplicantObj` (inherits from `BandObj`)
* `EventObj`

Manager classes mediate between the GUI and database:

* `MemberManager`
* `ApplicantManager`
* `EventManager`

A dedicated `Connect` class abstracts database communication, isolating SQL logic from business logic and reinforcing separation of concerns.

---

### Database Design

The system uses a relational database (`Database11.accdb`) with three primary tables:

* **Members**
* **Applicants**
* **Events**

Application objects mirror their corresponding database schema.
Data is retrieved and updated dynamically through JDBC (UCanAccess), ensuring real-time persistence and consistency.

---

### NLP Chatbot Integration

To extend beyond basic CRUD functionality, a rule-based chatbot was implemented using Apache OpenNLP for tokenization.

The chatbot:

* Breaks user input into tokens
* Detects contextual keywords
* Provides operational guidance
* Returns fallback responses when input is not recognized

This introduced practical experience integrating external NLP models into a structured Java application.

---

## Testing & Validation

The system was tested by three independent users across all screens and core operations.

Testing included:

* **Standard Inputs** (valid data)
* **Extreme Inputs** (boundary values and long strings)
* **Abnormal Inputs** (invalid or blank data)

The validation layer correctly accepted valid inputs and rejected invalid ones, ensuring database integrity.

---

## Evaluation

### Strengths

* Clear separation between UI, logic, and database layers
* Proper use of inheritance and encapsulation
* Object-to-database structural alignment
* Consistent validation and error handling
* Stable CRUD operations

### Limitations

* Chatbot is rule-based and non-adaptive
* No relational mapping between members and events
* Update operations require full-field completion

---

## Future Development

If expanded further, I would:

* Introduce relational mapping between members and events
* Migrate to a scalable database system (e.g., PostgreSQL or MySQL)
* Implement authentication and role-based access
* Develop a more adaptive NLP model
* Enable partial updates for improved usability

---

## What This Project Demonstrates

This project reflects my ability to:

* Translate real-world requirements into structured software systems
* Design relational databases and object hierarchies
* Apply object-oriented principles meaningfully
* Separate data access from business logic
* Critically evaluate limitations and propose improvements

More than a CRUD application, this project represents an exploration of system architecture, data modeling, and deliberate software design.


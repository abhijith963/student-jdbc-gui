# Student Management System (Java Swing + JDBC + MySQL)

## About the project

This is a simple desktop application built using Java Swing and JDBC.
The purpose of this project was to understand how a Java application interacts with a database and how a basic GUI can be used to perform operations.

The application allows users to add student details and view them directly from a MySQL (MariaDB) database.

---

## Features

* Add student details (name, age, course)
* View all stored students
* Simple graphical user interface using Swing
* Database connectivity using JDBC

---

## Tech stack

* Java (Core Java + Swing)
* JDBC
* MySQL / MariaDB
* Linux (Arch)

---

## Project structure

```
StudentSwingApp/
│
├── DBConnection.java      # Handles database connection
├── StudentGUI.java        # Main GUI application
├── lib/                   # JDBC driver
└── .gitignore
```

---

## Database setup

Run the following SQL commands in your database:

```sql
CREATE DATABASE studentdb;

USE studentdb;

CREATE TABLE students (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(50),
    age INT,
    course VARCHAR(50)
);
```

---

## Configuration

Update database credentials in `DBConnection.java`:

```java
DriverManager.getConnection(
    "jdbc:mariadb://localhost:3306/studentdb",
    "root",
    "your_password"
);
```

---

## How to run (Linux / Arch)

### Compile

```
javac -cp "lib/mariadb-java-client.jar:." *.java
```

### Run

```
java -cp "lib/mariadb-java-client.jar:." StudentGUI
```

---

## Sample workflow

1. Launch the application
2. Enter student details
3. Click "Add Student"
4. Click "View Students" to display records

---

## What I learned

* How to connect Java with a database using JDBC
* Using PreparedStatement for safe queries
* Building a basic GUI using Swing
* Managing database operations from a desktop application

---

## Future improvements

* Add update and delete functionality
* Improve UI layout and styling
* Add input validation
* Convert to a web-based application

---

## Author

Abhijith

---

This project is part of my learning journey in backend and Java application development.

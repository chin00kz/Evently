## Wedding Event Management System – Evently

## Overview
**Evently** is a web-based wedding event management platform developed as a university group project. It enables users to book weddings, manage bookings, and view services, while administrators can manage all event-related data such as adding, editing, or removing events and service providers.

## Features
- User registration and authentication
- Wedding event booking system
- Admin panel for full control over events and services
- CRUD operations for managing event data
- Manage service providers (catering, DJ, decorations, etc.)
- Dynamic form handling for event updates
- Built using Java Servlets, JSP, and MySQL

## Technology Stack
- **Frontend**: HTML, CSS, JSP
- **Backend**: Java (Servlets)
- **Database**: MySQL
- **Architecture**: MVC (Model-View-Controller)

## How to Run Locally

### Prerequisites
- Java 8+
- Apache Tomcat
- MySQL
- IDE (e.g., Eclipse or IntelliJ)
- Git

### Setup Instructions

1. **Clone the repository**:
    ```bash
    git clone https://github.com/your-username/evently.git
    cd evently
    ```

2. **Set up the database**:
   - Open MySQL Workbench and create a new database named `evently`.
   - Import the provided SQL script (`evently.sql`) to set up the tables and seed data.

3. **Configure the database connection**:
   - Edit `DBConnect.java`:
     ```java
     public class DBConnect {
         private static String url = "jdbc:mysql://localhost:3306/evently";
         private static String user = "root";
         private static String password = "your-password";
     }
     ```

4. **Run the application**:
   - Deploy the project to Apache Tomcat.
   - Visit `http://localhost:8080/Evently` in your browser.

## Folder Structure
- `/src`: Java source files (servlets, models, utilities)
- `/WebContent`: JSP pages, CSS, and JS files
- `/sql`: SQL schema and data files

## Contributors
- **ChanukaW** – Full-stack development
- **RomeshCG** – Full-stack development
- **Prasad** – Full-stack development
- **SunethH** – Full-stack development 

## License
This project is licensed under the [MIT License](LICENSE).

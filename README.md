# Wedding Event Management System

## Overview
The **Event Management System** is a web-based application designed to facilitate the booking, management, and administration of  events. This system allows users to book weddings, view details of their bookings, and make updates, while admins can manage all event data including creating, updating, and deleting events and services.

## Features
- User registration and login
- Event booking system
- Admin panel for managing events
- CRUD (Create, Read, Update, Delete) functionalities for events
- View and manage service providers (e.g., catering, DJ, etc.)
- Dynamic forms for event updates
- Built using Java Servlets, JSP, and MySQL database

## Technology Stack
- **Frontend**: HTML, CSS, JSP
- **Backend**: Java (Servlets)
- **Database**: MySQL
- **Architecture**: MVC (Model-View-Controller)

## How to Run Locally

### Prerequisites
- Java 8+
- Apache Tomcat server
- MySQL
- IDE (e.g., Eclipse)
- Git

### Setup Instructions

1. **Clone the repository**:
    ```bash
    git clone https://github.com/romeshcg/evently.git
    cd Evently
    ```

2. **Set up the database**:
   - Open MySQL Workbench and create a new database named `Evently`.
   - Import the provided SQL script (`evently.sql`) located in the repository to set up the necessary tables.

3. **Configure the project**:
   - Open the project in Eclipse or your preferred IDE.
   - Set up the database connection in `DBConnect.java`:
     ```java
     public class DBConnect {
         private static String url = "jdbc:mysql://localhost:3306/wedding_events_db";
         private static String user = "root";
         private static String password = "123456";
     }
     ```

4. **Deploy the application**:
   - Run the application on an Apache Tomcat server.
   - Access the system by opening your browser and navigating to `http://localhost:8080/Evently` (or your configured Tomcat port).

## Folder Structure
- **/src**: Contains the source code including servlets, utility classes, and models.
- **/WebContent**: Contains the JSP files and static resources (CSS, JS).
- **/sql**: SQL scripts to set up the database schema.

## Contributors
- **RomeshCG** -- Full-stack developer
- **Prasad** -- Full-stack developer
- **SunethH** -- Full-stack developer

## License
This project is licensed under the MIT License.

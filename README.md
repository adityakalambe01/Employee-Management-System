# Employee Management System

## Overview

The Employee Management System is a comprehensive and modular solution for organizations seeking an efficient way to manage their workforce. Designed to streamline HR processes, this system provides tools for employee information management, performance evaluation, leave tracking, training and development, and more.

## Technologies Used

- [**Java :**](https://www.java.com) Core programming language for development.

- [**Hibernate :**](https://hibernate.org) Object-relational mapping for simplified database interactions.

- [**Spring :**](https://spring.io) Infrastructure support for managing components and implementing business logic.

- [**Spring Boot :**](https://spring.io/projects/spring-boot) Streamlined development of production-ready applications.

- [**REST API :**](https://restfulapi.net) Enables standardized and scalable communication between components.

- [**Postman :**](https://www.postman.com) Used for testing and documenting the REST API.

These technologies collectively contribute to a robust and efficient Employee Management System.

## Features

- **Employee Information Management:** Maintain detailed profiles, ensuring accurate and up-to-date employee data.

- **Team Hierarchy and Management:** Define team structures, assign managers, and track team members.

- **Department and Position Management:** Organize employees based on departments, job titles, and responsibilities.

- **Performance Appraisal:** Conduct regular performance evaluations, set goals, and track achievements.

- **Leave Management:** Simplify leave requests, approvals, and attendance tracking.

- **Training and Development:** Plan and track employee training programs, fostering skill development.

- **Salary and Compensation:** Manage salary structures, bonuses, and benefits with precision.

- **HR and Compliance:** Facilitate HR tasks such as recruitment, onboarding, and ensure compliance with policies.

- **Communication and Record Keeping:** Foster effective communication with an integrated messaging system and maintain comprehensive employee records.

## Getting Started

To get started with the Employee Management System, follow these steps:

1. Clone the repository:
   ```bash
   git clone https://github.com/adityakalambe01/Employee-Management-System.git
   ```

2. Install MySQL Server 8.0.33+:
   ```bash
   https://dev.mysql.com/downloads/mysql/
   ```

3. Configure the database and application properties.
    ```
   server.port=9090
   spring.mvc.view.prefix=/pages/
   spring.mvc.view.suffix=.jsp
   spring.datasource.url=jdbc:mysql://localhost:{your MySQL Port}/{your database name}
   spring.datasource.username=MySQLUsername
   spring.datasource.password=MySQLPassword
   spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
   #spring.jpa.database-platform=org.hibernate.dialect.MySQL8Dialect
   spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQL8Dialect
   spring.jpa.hibernate.ddl-auto=update
   spring.jpa.show-sql=true
   #spring.jpa.generate-ddl=true
   spring.jackson.serialization.fail-on-empty-beans=false
   ```

4. Run the application:
   ```bash
    EmployeeManagemntApplication.java
   ```

## Contributing

We welcome contributions! If you'd like to contribute to the project, feel free to fork the repository and submit pull requests for new features, enhancements, or bug fixes.

[//]: # ()
[//]: # (## License)

[//]: # ()
[//]: # (This project is licensed under the [MIT License]&#40;LICENSE&#41;.)

## Author

Aditya Kalambe

[//]: # (## Acknowledgments)

[//]: # ()
[//]: # (- Special thanks to [Contributor Names] for their valuable contributions.)


---

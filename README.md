# Employee Management System

This is a Spring Boot-based Employee Management System that allows users to create, read, update, and delete employee records. The application uses Thymeleaf for rendering views on the front end and MySQL as the database to store employee data.

## Technologies Used
- **Backend**: Spring Boot, Spring Data JPA
- **Frontend**: Thymeleaf, Bootstrap
- **Database**: MySQL
- **Others**: Java, Maven

## Features
- List all employees.
- Add new employees.
- Edit employee details.
- Delete employee records.

## Project Setup

### 1. Clone the Repository

Clone this repository to your local machine:

```bash
git clone https://github.com/your-username/employee-management-system.git
```
### 2. Set Up the MySQL Database
- Install MySQL and create a new database (if not already done).
- Create a database named employee_management_system or update the application.properties file to use your existing database.
- Make sure you have the following MySQL table structure:

````SQL
CREATE TABLE employees (
  employee_id BIGINT AUTO_INCREMENT PRIMARY KEY,
  name VARCHAR(255) NOT NULL,
  role VARCHAR(255) NOT NULL,
  email VARCHAR(255) NOT NULL,
  salary DECIMAL(10, 2) NOT NULL
);
````
### 3. Update application.properties
- Inside src/main/resources/application.properties,update the MySQL database connection properties as follows:

````properties
spring.datasource.url=jdbc:mysql://localhost:3306/employee_management_system
spring.datasource.username=root
spring.datasource.password=yourpassword
spring.jpa.hibernate.ddl-auto=update
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQL8Dialect
````
### 4. Build the Project
- Use Maven to build the project:
````bash
mvn clean install
````

### 5. Run the Application
- Run the application using the following command:
````bash
mvn spring-boot:run
````
- Alternatively, you can run it from your IDE (e.g., IntelliJ or Eclipse) by executing the EmployeeManagementSystemApplication.java class.

6. Access the Application
- Once the application is running, you can access it by navigating to the following URL in your browser:
````bash
http://localhost:8080/employees
````
### API Endpoints
#### 1. GET /employees
- Returns the list of all employees.
#### 2. GET /employees/create
- Shows the form to add a new employee.
#### 3. POST /employees
- Submits the form to create a new employee.
#### 4. GET /employees/{id}/edit
- Shows the form to edit an employee by ID.
#### 5. POST /employees/{id}
- Updates the employee details by ID.
#### 6. GET /employees/{id}/delete
- Deletes the employee by ID.
### Contribution Guidelines
- Feel free to fork the repository and submit pull requests for improvements or bug fixes.

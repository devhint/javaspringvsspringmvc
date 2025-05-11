# Toy Store Spring MVC

This is a simple toy store application built using Spring MVC. The application allows users to view a list of toys and their details.

## Project Structure

```
toy-store-springmvc
├── src
│   ├── main
│   │   ├── java
│   │   │   └── com
│   │   │       └── example
│   │   │           └── toystoremvc
│   │   │               ├── ToyStoreSpringMvcApplication.java
│   │   │               ├── controller
│   │   │               │   └── ToyController.java
│   │   │               ├── model
│   │   │               │   └── Toy.java
│   │   │               └── service
│   │   │                   └── ToyService.java
│   │   └── resources
│   │       ├── templates
│   │       │   └── index.html
│   │       └── application.properties
├── pom.xml
└── README.md
```

## Prerequisites

- Java 17
- Maven

## Setup

1. Clone the repository or download the project files.
2. Navigate to the project directory.
3. Build the project using Maven:

   ```
   mvn clean install
   ```

## Running the Application

To run the application, execute the following command:

```
mvn spring-boot:run
```

The application will start on the default port (8080). You can access it by navigating to `http://localhost:8080` in your web browser.

## Features

- View a list of toys
- View details of a specific toy

## License

This project is licensed under the MIT License.
# Toy Store Application

This is a simple Spring Boot application for a toy store. It provides basic functionality to manage toys, including retrieving a list of toys and adding new toys.

## Features

- Retrieve all toys
- Add a new toy

## Project Structure

```
toy-store
├── src
│   ├── main
│   │   ├── java
│   │   │   └── com
│   │   │       └── example
│   │   │           └── toystore
│   │   │               ├── ToyStoreApplication.java
│   │   │               ├── controller
│   │   │               │   └── ToyController.java
│   │   │               ├── model
│   │   │               │   └── Toy.java
│   │   │               └── service
│   │   │                   └── ToyService.java
│   │   └── resources
│   │       ├── application.properties
│   │       └── static
│   │       └── templates
│   └── test
│       └── java
│           └── com
│               └── example
│                   └── toystore
│                       └── ToyStoreApplicationTests.java
├── pom.xml
└── README.md
```

## Getting Started

### Prerequisites

- Java 11 or higher
- Maven

### Running the Application

1. Clone the repository:
   ```
   git clone <repository-url>
   ```
2. Navigate to the project directory:
   ```
   cd toy-store
   ```
3. Build the project using Maven:
   ```
   mvn clean install
   ```
4. Run the application:
   ```
   mvn spring-boot:run
   ```

### Accessing the Application

Once the application is running, you can access it at `http://localhost:8080`.

## License

This project is licensed under the MIT License.
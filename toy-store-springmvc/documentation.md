# Toy Store Spring MVC Application Documentation

---

## Overview

The `toy-store-springmvc` application is a simple Java Spring MVC project that simulates a basic toy store. It provides functionality to manage a collection of toys, allowing users to:
1. View a list of available toys.
2. Add new toys to the store.
3. Retrieve details of a specific toy by its ID.

This application is built using the **Spring MVC** framework, which is part of the larger Spring Framework. Spring MVC provides a robust model-view-controller architecture for building web applications.

---

## Functionality

### 1. View All Toys
- **Endpoint**: `GET /toys`
- **Description**: Returns a list of all toys available in the store.
- **Implementation**: Uses a `ToyService` to fetch the list of toys and displays it on a Thymeleaf template.

### 2. Add a New Toy
- **Endpoint**: `POST /toys`
- **Description**: Adds a new toy to the store.
- **Request Body**: Form data containing the toy's details (e.g., name, price, and description).
- **Implementation**: The `ToyController` receives the request, validates the input, and delegates the creation of the toy to the `ToyService`.

### 3. Get Toy by ID
- **Endpoint**: `GET /toys/{id}`
- **Description**: Fetches details of a specific toy by its unique ID.
- **Implementation**: The `ToyController` retrieves the toy by ID using the `ToyService` and displays it on a Thymeleaf template.

---

## Code Implementation

### 1. `Toy` Model
The `Toy` class represents the data structure for a toy in the store.

```java
package com.example.toystoremvc.model;

public class Toy {
    private Long id;
    private String name;
    private String description;
    private double price;

    // Constructors, Getters, and Setters
    public Toy(Long id, String name, String description, double price) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
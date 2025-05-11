# Comparison: Spring Boot vs Spring MVC Implementation of Toy Store

This document compares the implementation of the same functionality in the `toy-store` (Spring Boot) and `toy-store-springmvc` (Spring MVC) projects. Both projects provide the same features but use different frameworks and approaches.

---

## **1. Project Setup**

### **Spring Boot (toy-store)**
- Uses **Spring Boot Starter** dependencies to simplify configuration.
- Embedded Tomcat server is included by default.
- Minimal configuration required in `application.properties`.

### **Spring MVC (toy-store-springmvc)**
- Requires explicit configuration of dependencies like `spring-webmvc` and `thymeleaf`.
- No embedded server; requires external server setup or configuration.
- Uses `web.xml` or Java-based configuration for DispatcherServlet setup.

---

## **2. Controller Implementation**

### **Spring Boot (toy-store)**

- Uses `@RestController` to handle RESTful APIs.
- Returns JSON responses directly.
- Example:
    ```java
    @RestController
    @RequestMapping("/toys")
    public class ToyController {
        @GetMapping
        public List<Toy> getAllToys() {
            return toyService.getAllToys();
        }
    }
    ```

### **Spring MVC (toy-store-springmvc)**

- Uses `@Controller` to handle web requests.
- Returns views (HTML templates) rendered by Thymeleaf.
- Example:
    ```java
    @Controller
    @RequestMapping("/toys")
    public class ToyController {
        @GetMapping
        public String getAllToys(Model model) {
            model.addAttribute("toys", toyService.getAllToys());
            return "toys";
        }
    }
    ```

**Key Difference**:
- Spring Boot focuses on REST APIs and JSON responses.
- Spring MVC focuses on rendering HTML views.

---

## **3. View Layer**

### **Spring Boot (toy-store)**
- No view layer is used.
- Data is returned as JSON, suitable for API-based applications.

### **Spring MVC (toy-store-springmvc)**
- Uses Thymeleaf templates to render HTML views.
- Example:
    ```html
    <ul>
        <li th:each="toy : ${toys}">
            <a th:href="@{/toys/{id}(id=${toy.id})}" th:text="${toy.name}"></a>
        </li>
    </ul>
    ```

**Key Difference**:
- Spring Boot skips the view layer, focusing on APIs.
- Spring MVC uses a view layer for rendering HTML.

---

## **4. Dependency Injection**

### **Spring Boot (toy-store)**
- Uses `@Service` and `@RestController` annotations for dependency injection.
- Example:
    ```java
    @RestController
    public class ToyController {
        private final ToyService toyService;

        public ToyController(ToyService toyService) {
            this.toyService = toyService;
        }
    }
    ```

### **Spring MVC (toy-store-springmvc)**
- Uses `@Service` and `@Controller` annotations for dependency injection.
- Example:
    ```java
    @Controller
    public class ToyController {
        private final ToyService toyService;

        public ToyController(ToyService toyService) {
            this.toyService = toyService;
        }
    }
    ```

**Key Similarity**:
- Both frameworks use Spring's dependency injection mechanism.

---

## **5. Configuration**

### **Spring Boot (toy-store)**
- Minimal configuration in `application.properties`.
- Example:
    ```properties
    server.port=8080
    spring.application.name=toy-store
    ```

### **Spring MVC (toy-store-springmvc)**
- Requires more configuration for DispatcherServlet and view resolvers.
- Example:
    ```java
    @Configuration
    @EnableWebMvc
    public class WebConfig implements WebMvcConfigurer {
        @Bean
        public InternalResourceViewResolver viewResolver() {
            InternalResourceViewResolver resolver = new InternalResourceViewResolver();
            resolver.setPrefix("/WEB-INF/views/");
            resolver.setSuffix(".jsp");
            return resolver;
        }
    }
    ```

**Key Difference**:
- Spring Boot simplifies configuration with auto-configuration.
- Spring MVC requires explicit configuration.

---

## **6. API Documentation**

### **Spring Boot (toy-store)**
- API endpoints return JSON responses.
- Example:
    - **Endpoint**: `GET /toys`
    - **Response**:
        ```json
        [
            {
                "id": 1,
                "name": "Teddy Bear",
                "description": "A soft and cuddly teddy bear.",
                "price": 19.99
            }
        ]
        ```

### **Spring MVC (toy-store-springmvc)**
- API endpoints render HTML views.
- Example:
    - **Endpoint**: `GET /toys`
    - **Response**: Renders `toys.html` with a list of toys.

**Key Difference**:
- Spring Boot is API-focused.
- Spring MVC is view-focused.

---

## **7. Framework Tools**

### **Spring Boot (toy-store)**
- **Spring Boot Starter Web**: Provides dependencies for building web applications.
- **Embedded Tomcat**: Runs the application without external server setup.
- **Auto-Configuration**: Reduces boilerplate code.

### **Spring MVC (toy-store-springmvc)**
- **DispatcherServlet**: Acts as the front controller for routing requests.
- **Thymeleaf**: Used for rendering dynamic HTML views.
- **Explicit Configuration**: Requires manual setup of components like view resolvers.

---

## **Summary**

| Feature                  | Spring Boot (toy-store)         | Spring MVC (toy-store-springmvc) |
|--------------------------|----------------------------------|----------------------------------|
| **Focus**                | REST APIs and JSON responses    | HTML views and web applications |
| **Controller**           | `@RestController`              | `@Controller`                  |
| **View Layer**           | None (JSON responses)          | Thymeleaf templates             |
| **Configuration**        | Minimal (auto-configured)       | Explicit (manual setup)         |
| **Server**               | Embedded Tomcat                | External server required        |
| **Use Case**             | API-based applications         | Web applications with views     |

---

This comparison highlights the differences and similarities between Spring Boot and Spring MVC implementations of the toy store application. Each framework is suited for different use cases, with Spring Boot being ideal for API-driven applications and Spring MVC excelling in traditional web applications with dynamic views.
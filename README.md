# JSONPlaceholder REST API

This project is a Spring Boot REST API that simulates the functionality of the popular JSONPlaceholder service. It provides endpoints for managing posts, mimicking a simple blogging platform.

## Features
- CRUD operations for posts (Create, Read, Update, Delete)
- RESTful API design
- Swagger/OpenAPI documentation
- In-memory data storage 

## Technologies Used
- Java
- Spring Boot
- Maven
- Swagger (OpenAPI)

## Getting Started

### Prerequisites
- Java 17 or higher
- Maven

### Running the Application

1. Clone the repository:
   ```sh
   git clone <repository-url>
   ```
2. Navigate to the project directory:
   ```sh
   cd jsonplaceholder
   ```
3. Build and run the application:
   ```sh
   ./mvnw spring-boot:run
   ```
   Or on Windows:
   ```sh
   mvnw.cmd spring-boot:run
   ```

The API will be available at `http://localhost:8080/posts`.

### API Documentation
Swagger UI is available at:
```
http://localhost:8080/swagger-ui/index.html
```

## Example Endpoints
- `GET /posts` - List all posts
- `GET /posts/{id}` - Get a post by ID
- `POST /posts` - Create a new post
- `PUT /posts/{id}` - Update a post
- `DELETE /posts/{id}` - Delete a post

## Project Structure
- `controller/` - REST controllers
- `service/` - Business logic
- `model/` - Data models
- `config/` - Configuration (e.g., Swagger)

## License
This project is for educational and demonstration purposes only.

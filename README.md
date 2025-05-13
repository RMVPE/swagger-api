# InteropCare API Documentation

![Spring Boot](https://img.shields.io/badge/Spring_Boot-3.4.5-brightgreen)
![Java](https://img.shields.io/badge/Java-22-orange)
![OpenAPI](https://img.shields.io/badge/OpenAPI-3.0-blue)

## Table of Contents
- [API Documentation](#api-documentation)
- [API Endpoints](#api-endpoints)
- [Configuration](#configuration)
- [Testing](#testing)
- [Troubleshooting](#troubleshooting)
- [Technology Stack](#technology-stack)

## API Documentation

## API Endpoints

| Endpoint                | Method | Description               | Status Codes |
|-------------------------|--------|---------------------------|--------------|
| `/api/products`         | GET    | List all products         | 200          |
| `/api/products/{id}`    | GET    | Get product details       | 200, 404     |
| `/api/products`         | POST   | Create new product        | 201, 400     |

## ⚙️ Configuration

### Essential Properties (`application.properties`)

# Server Configuration
server.port=8080
server.servlet.context-path=/api

# SpringDoc OpenAPI (Swagger)
springdoc.swagger-ui.path=/swagger-ui.html
springdoc.api-docs.path=/v3/api-docs
springdoc.swagger-ui.tagsSorter=alpha

### Interactive Documentation
Access Swagger UI at:  
`http://localhost:8080/swagger-ui.html`

### OpenAPI Specification
`http://localhost:8080/v3/api-docs`

## 📦 Dependencies

### Core Dependencies
<!-- Spring Boot Starters -->
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-web</artifactId>
</dependency>

<!-- OpenAPI Documentation -->
<dependency>
    <groupId>org.springdoc</groupId>
    <artifactId>springdoc-openapi-starter-webmvc-ui</artifactId>
    <version>2.5.0</version>
</dependency>


### Environment Variables
## 🌐 Environment Variables

| Variable               | Required | Default Value          | Description                          |
|------------------------|----------|------------------------|--------------------------------------|
| `SERVER_PORT`          | No       | `8080`                 | HTTP server port                    |
| `DB_URL`               | Yes      | -                      | Database connection URL             |
| `API_RATE_LIMIT`       | Yes      | `1000`                 | Max requests per minute             |
| `CACHE_ENABLED`        | No       | `true`                 | Enable response caching             |

## 🧪 Test Dependencies

### Core Testing
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-test</artifactId>
    <scope>test</scope>
</dependency>

### Example Product Model
{
  "id": 1,
  "name": "Laptop",
  "price": 999.99,
  "description": "High-performance device"
}


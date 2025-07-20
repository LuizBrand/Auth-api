# AuthRoles API


Java • Spring Boot • Spring Security • PostgreSQL (Docker) • JWT • Flyway

An authentication and authorization API built with Java 21, Spring Boot, Spring Security, PostgreSQL (via Docker), Flyway migrations, and JWT-based security.  
This project demonstrates how to implement secure user registration, login, and role-based access control using Spring Security and JWT.

## Table of Contents

- [Features](#features)
- [Tech Stack](#tech-stack)
- [Installation](#installation)
- [Usage](#usage)
- [API Endpoints](#api-endpoints)
- [Authentication & Roles](#authentication--roles)
- [Database](#database)
- [Contributing](#contributing)

## Features

- User registration and login with JWT authentication
- Role-based access control (USER, ADMIN)
- Secure endpoints with Spring Security
- Database migrations with Flyway
- PostgreSQL integration (Docker)
- Clean code structure with DTOs, services, mappers, and controllers

## Tech Stack

- Java 21+
- Spring Boot
- Spring Security
- JWT (JSON Web Token)
- PostgreSQL
- Flyway

## Installation

### 1. Clone the repository

```bash
git clone https://github.com/LuizBrand/Auth-api.git
cd Auth-api
```
### 2. Start PostgreSQL with Docker
If you don't have PostgreSQL installed, you can easily run it with Docker:

```bash
docker run --name authroles -e POSTGRES_DB=authroles -e POSTGRES_USER=postgres -e POSTGRES_PASSWORD=postgres -p 5432:5432 -d postgres
```
**Note: The database, user, and password should match your application.yaml.**

## Usage

1.Start the application with Maven\
2.The API will be accessible at http://localhost:8080

## API Endpoints

The API provides the following EndPoints:
- `POST /auth/register` - Register a new user  
    ```json
  {
        "username": "user",
        "password": "password"
  }
  ```
- `POST /auth/login` - Login and receive JWT
    ```json
  {
        "username": "user",
        "password": "password"
  }
  ```
- Login Response
    ```json
  {
        "token": "jwt-token"
  }
  ```
- Users\
  `GET /user` - List all users (USER and ADMIN, JWT required)\
  `GET /user/{id}` - Get user by ID (ADMIN only, JWT required)

## Authentication & Roles

- **USER**: Default role for registered users.
- **ADMIN**: Can manage users and access admin endpoints.

To access protected endpoints, send the JWT in the `Authorization` header.

## Database

- PostgreSQL (can be run via Docker)
- Automatic migrations with Flyway (`db/migration`)

## Contributing

Contributions are welcome!  
If you find any issues or have suggestions for improvements, please open an issue or submit a pull request.

When contributing, please follow the existing code style, commit conventions, and submit your changes in a separate branch.
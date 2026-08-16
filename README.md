# Secure Weather API

A secure RESTful Weather API built with Spring Boot. The application provides weather information, user authentication with JWT, weather history, and monthly weather data.

## Features

- User registration
- User login
- JWT-based authentication
- Spring Security
- Protected weather endpoints
- Current weather information
- Temperature lookup
- Monthly weather data
- Weather history
- MySQL database
- Spring Data JPA / Hibernate
- Request validation
- RESTful API design

## Tech Stack

- Java
- Spring Boot
- Spring Security
- JWT
- Spring Data JPA
- Hibernate
- MySQL
- Maven
- Lombok
- REST API

## Project Structure

```text
src/main/java/idk/example/demo/

├── Configuration/
├── controller/
├── dto/
├── entity/
├── enums/
├── repo/
├── security/
└── service/


The application follows a layered structure separating controllers, services, repositories, entities, DTOs, and security components.

API Endpoints
Authentication
Register
POST /auth/register

Creates a new user account.

Login
POST /auth/login

Authenticates a user and returns a JWT token.

Weather
Get Weather
GET /weather?city={city}

Returns weather information for a specified city.

Example:

GET /weather?city=Delhi
Get Temperature
GET /weather/temperature?city={city}

Returns the temperature for a specified city.

Example:

GET /weather/temperature?city=Delhi
Get Monthly Weather
GET /weather/monthly?city={city}&month={month}

Returns monthly weather information for the specified city and month.

Example:

GET /weather/monthly?city=Delhi&month=7
Get Weather History
GET /weather/history

Returns recent weather history.

Authentication

The application uses Spring Security and JWT for authentication.

The authentication flow is:

Register
   ↓
Login
   ↓
JWT Token
   ↓
Authenticated Request
   ↓
Protected Endpoint

After logging in, the JWT token should be included in authenticated requests using the Bearer authentication scheme.

Authorization: Bearer <your-jwt-token>
Database

The application uses MySQL for persistent data storage.

Spring Data JPA and Hibernate are used for database access and entity management.

Configuration

The application requires database configuration and a Weather API key.

Do not commit real credentials or API keys to the repository.

Use environment variables for sensitive values.

Example:

weather.api.key=${WEATHER_API_KEY}

Set the required environment variable on your local machine before running the application.

Running the Application
Prerequisites
Java 25
MySQL
Maven
Clone the repository
git clone https://github.com/kasier191406-jpg/WeatherApi.git
Enter the project directory
cd WeatherApi
Configure MySQL

Create a MySQL database and configure the database connection in your local application configuration.

Configure the Weather API key

Set:

WEATHER_API_KEY

in your environment.

Run the application

On Windows:

mvnw.cmd spring-boot:run

On Linux/macOS:

./mvnw spring-boot:run
Testing

Run the test suite with:

Windows
mvnw.cmd test
Linux/macOS
./mvnw test
Security

The application uses:

Spring Security
JWT authentication
BCrypt password hashing
Stateless authentication

Sensitive credentials should always be kept outside the source code.

Future Improvements
Role-based authorization
Global exception handling
More comprehensive unit and integration tests
Swagger / OpenAPI documentation
Docker support
Cloud deployment
Improved API response DTOs
Author

Kasier

GitHub:
https://github.com/kasier191406-jpg

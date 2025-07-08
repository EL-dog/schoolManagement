
# School Management System – Spring Boot Backend

A secure, role-based backend system built with Spring Boot for managing schools, students, teachers, and academic data. Supports JWT-based authentication, full CRUD for admins, and read/write access based on roles.

## Features

### Admin
- Full CRUD operations on:
  - Students
  - Teachers
- Assign students to teachers/classrooms
- Manage school-wide data

### Teacher
- View list of assigned students
- Push updates:
  - Student marks
  - Attendance
  - Performance reviews

### Student
- View-only access to:
  - Their own profile
  - Marks, attendance, and reviews provided by teachers/admin

## Tech Stack

Language: Java 17  
Framework: Spring Boot 3.x  
Security: Spring Security + JWT  
API Docs: Springdoc OpenAPI (Swagger UI)  
ORM: Spring Data JPA (Hibernate)  
DB: H2 (dev) / PostgreSQL (prod)  
DTO Mapping: MapStruct  
Others: Lombok, Validation API

## Authentication & Security

- Stateless JWT authentication
- Role-based endpoint authorization (ADMIN, TEACHER, STUDENT)
- Swagger UI integrated with token-based access

## API Documentation

Swagger UI is available at:

http://localhost:8080/swagger-ui.html

Raw OpenAPI spec:

http://localhost:8080/v3/api-docs

Make sure you're logged in via /auth/login and include the token as Bearer <your-token> when testing secured endpoints.

## Project Structure

src/
 └── main/
     ├── java/
     │   └── com.easySchool.schoolManagement/
     │       ├── controller/
     │       ├── service/
     │       ├── dto/
     │       ├── model/
     │       ├── repository/
     │       ├── config/         <-- SecurityConfig, OpenAPIConfig
     │       └── security/       <-- JWT Filter, Token Utils
     └── resources/
         └── application.yml

## Running the App Locally

### Prerequisites

- Java 17+
- Maven or Gradle

### Steps

Clone the repo and run the app:

```
git clone https://github.com/EL-dog/schoolManagement.git
cd schoolManagement
./mvnw spring-boot:run
```

### Access Local Resources

- Swagger UI: http://localhost:8080/swagger-ui.html
- H2 Console: http://localhost:8080/h2-console
- Login Endpoint: POST /auth/login

## Key API Endpoints

All endpoints follow RESTful naming and require JWT authentication unless marked otherwise.

### Student Management

Method | Endpoint | Description
-------|----------|------------
POST | /school/student/create | Register new student (ADMIN only)
GET | /school/student/all | Get all students
GET | /school/student/{id} | Get a student by ID

### Teacher Management

Method | Endpoint | Description
-------|----------|------------
POST | /school/teacher/create | Register new teacher (ADMIN only)
GET | /school/teacher/all | Get all teachers

### Auth Endpoints

Method | Endpoint | Description
-------|----------|------------
POST | /auth/register | Register user (admin/student/teacher)
POST | /auth/login | Login and receive JWT token

## Authentication Flow

1. Call /auth/login with credentials:

```
curl -X POST http://localhost:8080/auth/login  -H "Content-Type: application/json"  -d '{"username": "admin", "password": "admin123"}'
```

2. Use the returned token for authorized endpoints:

```
curl http://localhost:8080/school/student/all  -H "Authorization: Bearer <your-token>"
```

## Sample Request/Response Schemas

### Register Teacher Request (TeacherDto)

```
{
  "teacherName": "Mr. Sharma",
  "teacherAge": "35",
  "teacherGender": "Male",
  "teacherPhone": "9876543210"
}
```

### API Standard Response (ApiResponse)

```
{
  "success": true,
  "message": "Teacher created successfully",
  "data": "Teacher registered",
  "error": null
}
```

### Login Response

```
{
  "success": true,
  "message": "Login successful",
  "data": {
    "token": "eyJhbGciOiJIUzI1NiIs...",
    "username": "admin"
  },
  "error": null
}
```

## Defined Schemas in OpenAPI

Schema Name | Used In
------------|--------
TeacherDto | Create teacher
StudenDto | Create student
RegisterRequest | Auth register
LoginRequest | Auth login
ApiResponseString | Response with a string payload
ApiResponseListStudenDto | Response with list of students
ApiResponseStudenDto | Response with one student
LoginResponse | JWT + username

## License

MIT License

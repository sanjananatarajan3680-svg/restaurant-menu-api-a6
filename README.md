# Restaurant Menu API – Set A6

## Project Description

A REST API for managing restaurant menu dishes, developed using Java and Spring Boot.

## Technologies Used

- Java
- Spring Boot
- Maven
- REST API
- In-memory data storage (no database)

## Requirements

- Java JDK compatible with the project's `pom.xml`
- Internet connection for the first Maven dependency download

## How to Run

1. Clone this repository.
2. Open the project folder in VS Code or another Java IDE.
3. Open a terminal in the folder containing `pom.xml`.
4. Run the following command on Windows:

```powershell
.\mvnw.cmd spring-boot:run
```

5. The application starts at:

```text
http://localhost:8080
```

## API Endpoints

| Method | Endpoint | Description |
|---|---|---|
| POST | `/api/dishes` | Add a dish |
| GET | `/api/dishes` | Get dishes |
| GET | `/api/dishes/{id}` | Get a dish by ID |
| PUT | `/api/dishes/{id}` | Replace a dish |
| PATCH | `/api/dishes/{id}` | Partially update a dish |
| DELETE | `/api/dishes/{id}` | Delete a dish |

## Data Storage

Dish records are stored in memory. Data is reset when the application restarts.

## Assessment

Set A6 – Restaurant Menu API.
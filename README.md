## Getting Started

This is a simple Spring based POC implementation of a job seeker application.

Live demo: https://jobseeker-poc.herokuapp.com/

### Prerequisites

- Java 11 JDK, you can download it from [here](https://adoptium.net/temurin/releases/?version=11).

### Installation

building the project with maven:

```powershell
> .\mvnw clean install
```

running the project locally:

```powershell
> java -jar .\jobseeker-0.0.1-SNAPSHOT.jar
```

## Usage

You can access the console at the following URL: http://localhost:8080/h2-ui/login.jsp

- JDBC URL: jdbc:h2:mem:jobseeker_db
- User Name: user
- Password: user

### Client registration

Body of the POST request:

```json
{
    "name": "client",
    "email": "client@email.com"
}
```

Response body:

```json
{
    "API Key": "29883b98-e127-4748-b370-7eca54973410"
}
```

![client registration](https://raw.githubusercontent.com/peterpalfi/jobseeker/main/usage/client%20registration.png "client registration")

### Create position

Body of the POST request:

```json
{
    "name": "example job",
    "location": "Budapest",
    "apiKey": "43d23d6e-3b53-43b0-bdbe-2fc3b0e932db"
}
```

Response body:

```json
{
    "URL": "http://localhost:8080/position/6"
}
```

![create position](https://raw.githubusercontent.com/peterpalfi/jobseeker/main/usage/create%20position.png "create position")

### Search position

Body of the GET request:

```json
{
    "keyword": "job",
    "location": "Budapest",
    "apiKey": "43d23d6e-3b53-43b0-bdbe-2fc3b0e932db"
}
```

Response body:

```json
{
    "searchResults": [
        "http://localhost:8080/position/4",
        "http://localhost:8080/position/6"
    ]
}
```

![search position](https://raw.githubusercontent.com/peterpalfi/jobseeker/main/usage/search%20position.png "search position")

### Get position

Request URL: http://localhost:8080/position/6

Response body:

```json
{
    "id": 6,
    "name": "example job",
    "location": "Budapest"
}
```

![get position](https://raw.githubusercontent.com/peterpalfi/jobseeker/main/usage/get%20position.png "get position")

## Possible errors

### Request format error

![request format error](https://raw.githubusercontent.com/peterpalfi/jobseeker/main/usage/format%20error.png "request format error")

### Invalid API key

![invalid api key](https://raw.githubusercontent.com/peterpalfi/jobseeker/main/usage/invalid%20api%20key.png "invalid api key")

### Invalid API key: incorrect format

![api key incorrect format](https://raw.githubusercontent.com/peterpalfi/jobseeker/main/usage/incorrect%20api%20key.png "api key incorrect format")

### Registration already exists

![registration already exists](https://raw.githubusercontent.com/peterpalfi/jobseeker/main/usage/registration%20already%20exists.png "registration already exists")

## Swagger UI



## Possibilities for further development

- changing to a persistent database
- providing better exception handling and adding custom exceptions
- improving the error response
- using the AuthenticationFailureHandler for API key authentication
- implementing testing methodologies (unit tests, integration tests)
- adding spring's [production-ready features](https://docs.spring.io/spring-boot/docs/2.2.x/reference/html/production-ready-features.html)
- [enabling https](https://docs.spring.io/spring-cloud-skipper/docs/1.0.0.BUILD-SNAPSHOT/reference/html/configuration-security-enabling-https.html)

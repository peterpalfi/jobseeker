## Getting Started

This is a simple Spring based POC implementation of a job seeker application.

### Try it out

- [Live Demo](https://jobseeker-poc.herokuapp.com/)
- [Swagger UI Documentation](https://jobseeker-poc.herokuapp.com/swagger-ui/index.html)

### Prerequisites

- Java 11 JDK, you can download it from [here](https://adoptium.net/temurin/releases/?version=11).

### Installation

Building the project with maven:


```powershell
project's root directory> .\mvnw clean install
```

Running the project locally:

```powershell
project's root directory\target> java -jar .\jobseeker-0.0.1-SNAPSHOT.jar
```

## Usage

You can access the H2 database console at the following URL: http://localhost:8080/h2-ui/login.jsp

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

## Possibilities for further development

- Using a persistent database
- Providing better exception handling and adding custom exceptions
- Improving the error response
- Using the AuthenticationFailureHandler for API key authentication
- Implementing testing methodologies (unit tests, integration tests)
- Adding spring's [production-ready features](https://docs.spring.io/spring-boot/docs/2.2.x/reference/html/production-ready-features.html)
- [Enabling https](https://docs.spring.io/spring-cloud-skipper/docs/1.0.0.BUILD-SNAPSHOT/reference/html/configuration-security-enabling-https.html)

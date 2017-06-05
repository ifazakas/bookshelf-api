# BOOKSHELF-API

*Playground for Spring Boot, Hexagonal Architecture, TDD, DDD.*

To run the application:

```
./gradlew clean bootRun
```

To run the tests and code analysis

```
./gradlew clean check
```

## API

### VOLUMES

**Reqest Object**


| Parameter | Required | Type |
| -------- | -------- | -------- |
| author   | yes   | string |
| title   | yes   | string |
| publication_year   | yes   | unsigned int |   
   
   
**POST**  /volumes

```{
  "author": "Martin Fowler",
  "title": "Refactoring",
  "publication_year": 1999
}```

**Response:**  
201 Created

```{
  "volume_id": "0c70153e-3e27-11e7-a919-92ebcb67fe33"
  "author": "Martin Fowler",
  "title": "Refactoring",
  "publication_year": 1999
}```

400 Bad Request   
Required parameter is missing or validation error.

**Example:**

```
POST /volumes HTTP/1.1
Host: localhost:8080
Content-Type: application/json

{
  "author": "Martin Fowler",
  "title": "Refactoring",
  "publication_year": 1999
}
```


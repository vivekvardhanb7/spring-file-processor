# Spring File Processor

## Overview
Spring File Processor is a Spring Boot application that handles file uploads, processes XML files, and converts them to JSON format.

## Features
- Upload XML and CSV files via REST API.
- Convert XML files to JSON.
- Process CSV files starting from a specified row.
- Built using Spring Boot.

## Prerequisites
Ensure you have the following installed:
- **Java 17** or later
- **Apache Maven**
- **Git**

## Installation
### 1. Clone the Repository
```sh
git clone https://github.com/yourusername/spring-file-processor.git
cd spring-file-processor
```

### 2. Build the Project
```sh
mvn clean install
```

### 3. Run the Application
```sh
mvn spring-boot:run
```
The application will start on `http://localhost:8080`

## API Endpoints

### Upload XML File
**Endpoint:** `/xml/upload`  
**Method:** `POST`
```sh
curl -X POST "http://localhost:8080/xml/upload" -F "file=@sample.xml"
```

### Upload CSV File
**Endpoint:** `/file/upload`  
**Method:** `POST`
```sh
curl -X POST "http://localhost:8080/file/upload" -F "file=@sample.csv" -F "startRow=1"
```

## Directory Structure
```
|-- src
|   |-- main
|   |   |-- java/com/example/spring/
|   |   |   |-- controller/
|   |   |   |-- service/
|   |   |-- resources/
|-- test-files/ (Place your test XML and CSV files here)
|-- pom.xml
|-- README.md
```

## Deployment
You can build a JAR file and run it manually:
```sh
mvn package
java -jar target/spring-file-processor.jar
```

## Contributing
1. Fork the repository.
2. Create a new branch (`feature-branch`).
3. Commit your changes.
4. Push to your branch and create a Pull Request.

## License
This project is licensed under the MIT License.


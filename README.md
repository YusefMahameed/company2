# company
  This project is developed using java, spring-boot frame work was used with maven. The project aims to implement the bussiness logic of small company that contains customers and products, the customer orderes some product and that order is stored

## Getting Started

### Prerequisite
* Git
* JDK 8 or later
* Maven 3.0 or later

### Clone
To get started you can simply clone this repository using git:
```
git clone https://github.com/YusefMahameed/company
cd company
```

### Configuration
In order to get your chatbot working you have to provide the following settings:
```
spring.jpa.hibernate.ddl-auto = update
spring.datasource.url=jdbc:mysql://localhost:3306/company
spring.datasource.username=root
spring.datasource.password=
```
The configuration is located in `src/main/resources/application.properties`.

in order to use the database import the file ```company.sql``` to your database system

### Build an executable JAR
You can run the application from the command line using:
```
mvn spring-boot:run
```
Or you can build a single executable JAR file that contains all the necessary dependencies, classes, and resources with:
```
mvn clean package
```
Then you can run the JAR file with:
```
java -jar target/*.jar
```

### Test your new project
download postman for API testing, and enter the URL ```http://localhost:8080/company``` followed by each method URL and you will start sending requests and recive responces

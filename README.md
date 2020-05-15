# doc


# Instructions

Install JDK 1.8, Mysql 8+ and Tomcat 8+

Run the Sale_20140817.sql file from MySQL client

Change the MySQL username/password for Datasouce as per your local setup in product-service/src/main/resources/application.properties

Build product-service (mvn clean install)

Run the Spring-boot application 
    - Run Applicaiton.java from IDE
    - mvn spring-boot:run from CLI

Access from Postman:   

GET: http://localhost:8082/doc/appdata

GET: http://localhost:8082/doc/products

POST: http://localhost:8082/doc/products

Sample Request:
{
	"priceRange": "10-100",
	"pageIndex": 0,
	"pageSize": 20,
	"sortBy": "price",
	"searchKey": "Guess"
}

GET: http://localhost:8082/doc/login

GET: http://localhost:8082/doc/logout
 

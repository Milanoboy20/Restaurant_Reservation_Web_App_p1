# Restaurant_Reservation_Web_App_p1

## Project Description

Restaurant Reservation Web App allows users to make table reservations to have family dinners/party, dates, bussiness dinner etc
They do not need to have/create an account to be able to do so
## Technologies Used

* Java 8
* JUnit 5
* Apache Maven
* Custom ORM Framework
* Apache Tomcat 8.5.75
* PostGreSQL deployed on AWS RDS
* Java EE Servlet API (v4.0+)
* GSON Library
* Postman
* Git SCM (on GitHub)

## Features

* Customers can create new reservations without have to create login accounts
* Customers can add multiple reservations under thier name
* Customers can delete their reservations
* Customers can view their reservations
* Customers can update their reservations

To-do/Future Implementation:
* Create a UI for Users to interact with the application
* Deploy and host the Web App on an EC2 instance

## Getting Started

To be able to run the Application, you need:
* Maven: https://maven.apache.org/download.cgi
* Postman: https://www.postman.com/downloads/
* Tomcat 8: https://tomcat.apache.org/download-80.cgi download and unpack the zip file
   
Clone the repository https://github.com/Milanoboy20/Restaurant_Reservation_Web_App_p1.git

## Usage
> In the cloned folder 

- Open a cmd terminal and type in: mvn package
- Open the target folder in your cloned repository, look for a file RestaurantApp.war
- Copy the war file to your tomcat webapps folder
- Open the bin folder in your tomcat folder and look for startup file
- Select the appropriate startup for your OS, windows batch file or shell script
- Run the startup file and open your Postman
- You can only send 'GET', 'POST', 'PUT' and 'DELETE' Requests
- Goto: http://localhost:8080/RestaurantApp
- Append the endpoints below:
-     /customers         -> to gel all customers list
-     /tables            -> get all tables list
-     /customers/2       -> get customers by specific id numbers
-     /tables/2          -> get tables by id
-     /view/2            -> view a customers reservation


## Contributors

* Abdul Samad Sadat:  https://github.com/Milanoboy20   
* Micheal Ord:  https://github.com/1bubbainpa



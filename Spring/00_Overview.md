## Programming Language vs Technology vs Framework

### What is Programming Language?
* Programming Language contains set of instructions / set of commands.
* Every Programming Language will follow set of Syntax / Rules.
* Using programming language we can develop:
    * Applications
    * Tools
    * Softwares
    * Technologies
    * Frameworks

### What is Technology?
* Technology is a software which is developed by using Programming Language.
* Technologies are used to simplify our task.
* By using Technologies we can develop several types of applications.
* Example:
    * Servlets
    * JSP
    * JDBC

### What is Framework?
* Framework is a semi developed software.
* Framework provides common logics required for application development.
* Framework provides re-usable components.
* To avoid duplicate code / common logic implementation Frameworks came into picture.
    * Project = Business Logics + Common Logics
* Frameworks provides common logics required for the project so that we can focus only on Business Logic Development.
* Framework will improve developers productivity (we cna do more work in less time).
* Example:
    * Java -> Hibernate, Struts, Spring
    * .Net -> WCF
    * Python -> DJango, Flask
    * Salesforce -> Lightening

`Note`: Frameworks will be developed using Programing Languages only.

### Boiler Plate Code / Redundant Code?
* If we are  writing same code fo multiple times then it is called as Boiler Plate / Redundent Code.

### Application Architecture?
1. Monolith AArchitecture
2. Microservices Architecture

### Monolith Architecture
* Developing all requirements as one application.
* Maintenance will become difficult.
* For small change, whole project re-deploy.
* Single point of failure.

### Microservice Architecture
* It is an architectural design pattern to develop applications.
* Loosely coupled APIs
* Easy Maintenance
* Easy Deployments
* No single point of failure

### Spring Framework
* Spring Framework is called as application development framework.
* By using spring framework we can develop end to end application.
* Spring is free and open source.
* Spring Framework is developed in modular fashion.
* Note: Spring Framework means collection of modules.
* Spring is loosely coupled framework.
* Spring is very flexible framework. It will not force to use all modules.
* Spring is versatile framework
    * Can be integrated with any other framework available in the market.
    * Compatible with other frameworks.
* Spring Framework is licensed under VM Ware.

### Spring Modules
1. Spring Core
2. Spring Context
3. Spring JDBC
4. Spring ORM
5. Spring AOP
6. Spring Web MVC
7. Spring Security
8. Spring Social
9. Spring Batch
10. Spring Data JPA
11. Spring REST

### 1. Spring Core
* It is base module in Spring Framework.
* Spring Core Module provides fundamental concepts of Spring Framework
    1. IOC Container (Inversion of Control)
    2. Dependency Injection
    3. Bean Life Cycle
    4. Bean Scopes
    5. Autowiring

### 2. Spring Context
* It will deal with configurations required for our Spring Application.

### 3. Spring AOP
* Aspect Oriented Programming.
* APO is used to business logic and secondary logic in the project.
    * Secondary logics like
        * Security
        * Logging
        * Transaction
        * Auditing
        * Exception Handling
* Note: If we combine business logics & secondary logics then we will face maintenance issues of our project.

### 4. Spring JDBC
* Spring JDBC is used to simplify Database Communication logic.
* In java jdbc we need to write the boilerplate code (repeated code)
    * Load Driver
    * Get Connection
    * Create Statement
    * Execute Query
    * Close Connection
* Using Spring JDBC we can directly execute the query.
* Boilerplate code is taken care by Spring JDBC.

### 5. Spring Web MVC
* It is used to develop both Web Applications and Distributed Applications.
    * Web Applications (C 2 B)
        * Gmail, Facebook, 
    * Distributed Application
        * IRCTC <---> MakeMyTrip
        * Passport <---> Aadhar App

### 6. Spring ORM
* Object Relational Mapping.
* Spring Framework having integration with ORM frameworks
    * Example: Spring ORM, Spring Data JPA etc
* Note: JDBC represents the data in text formate, where as Hibernate ORM represents the data in Object formate.

### 7. Spring Security
* Security is very crucial for every application.
* Using Spring Security we can implement Authentication & Authorization.
* Spring Security with
    * OAuth2.0
    * JWT

### 8. Spring Batch
* Batch mean bulk operation
    * Reading data from Excel and store it into database table
    * Sending Monthly statements to customers in email
    * Sending Remainders to customers as bulk SMS

### 9. Spring Cloud
* It provides some common tools to quickly build distributed systems.
* It provide
    * Service Registry to register all our microservices at one place.
    * API Gateway to have single entry point for all our APIs.
    * Loadbalancer
    * Monitoring
    * Circuit Breaker (Fault Tolerant / Resilience Systems)
    * Distributed Messaging
    * Routing

### 10. Spring Test
* It provides Unit Test Framework.

### 11. Spring REST
* It is used to create RESTfull APIs.
# Spring Boot
* Spring Boot is one approach to develop Spring based Applications with less configuration.
    * Spring Boot = Spring Framework - XML Configuration
* Spring Boot is not replacement for Spring Framework. Boot developed on top of Spring Framework.
* `Note`: All Spring Framework concepts can be used in Spring Boot also.
* Spring Boot makes it easy to create stand-alone, production-grade, Spring based Applications that you can "just run".

### Spring Boot Advantages
* Less Configuration
* Pom Starters
    * Example: web-starter, jpa-starter, security-starter, mail-starter
* Auto Configuration
* Embedded Servers
    * Example: Tomcat, Jetty, Netty
* Actuators (Production Ready Features)

### Spring Boot Application Creation
* We can create boot application in two ways:
    1. Initializr website
    2. Spring Starter Project in IDE
* `Note`: If we try to create boot application using IDE then internally IDE will communicate with Initializr website to create the project.
* `Note`: Internet connection is mandatory for system to create Spring Boot Application.

#### Options to choose while creating boot application
* Build Tool: Maven / Gradle
* Language: Java / Groovy / Kotlin
* groupId: It represent company name / project name
    * in.ashokit
* artifactId: It represent project name / module name
* version: 0.0.1-SNAPSHOT
    * SNAPSHOT: Project under development
    * RELEASE/FINAL: Project Development Completed
* packageName: It represent base package in project
    * in.ashokit.passport
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

### Spring Boot Application Folder Structure
* `src/main/java`: To keep our project source code
    * `Application.java`: It is start class of the spring boot (Main Class)
* `src/main/resources`: To keep project configuration files
    * `application.properties` / `application.yml`
* `src/test/java`: To keep unit test code (junit)
    * `ApplicationTest.java`
* `src/test/resources`: Unit testing related config files goes here
* `Maven Dependencies`: Downloaded jars will be available here
* `pom.xml`: Maven configuration file (dependencies)


### Spring Boot Start Class
```java
@SpringBootApplication
public class Application {
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}
```

* It is entry point for boot application execution.
* **`@SpringBootApplication`** is equal to below three annotations
    * `@SpringBootConfiguration`
    * `@EnableAutoConfiguration`
    * `@ComponentScan`

* Spring Boot start class will act as a Configuration class because of `@SpringBootConfiguration` annotation.
* In Spring Boot application auto configuration feature will be available because of `@EnableAutoCOnfiguration` annotation.
* Component Scan wil be performed in Spring Boot because of `@ComponentScan` annotation.


### What is `SpringApplication.run()` method?
* Spring Boot start class main method() will call SpringApplication.run() method.
* `SpringApplication.run()` is entry point for boot application execution.
* This `run()` method will return reference of IoC.
* The return type of run() is `ConfigurableApplicationContext`.

#### **`SpringApplication`** class
* **`SpringApplication`** is a predefined class and it will identify what type of application we have created based on the dependencies added in pom.xml file.
    * standalone (spring-boot-starter)
        * For standalone app, It wil use `AnnotationConfigApplicationContext` class to start IoC container.
    * web app    (spring-boot-starter-web)
        * For web applications, it will use `AnnotationConfigServletWebServerApplicationContext` class to start IoC container.
    * reactive   (spring-boot-webflux-starter)
        * For reactive app, `AnnotationConfigReactiveWebServerApplicationContext` class will be used to start IoC container.
* Note: If all the three dependencies are used at the same time then the preference will be given to `spring-boot-starter-web` and `AnnotationConfigServletWebServerApplicationContext` will be used to create IoC container.

#### **`run()`** method
* run() method will print the banner on the console.
* run() method will start IoC container.
* rin() method will load the properties.
* run() method will call runners.
* run() method will return context of IoC container.
* run() method will register the listeners.

#### What is **Banner** in Spring Boot?
* When we run Spring Boot Application, it will print the Spring logo on the console that is called as Banner in Spring Boot.
    ```
    .   ____          _            __ _ _
    /\\ / ___'_ __ _ _(_)_ __  __ _ \ \ \ \
    ( ( )\___ | '_ | '_| | '_ \/ _` | \ \ \ \
    \\/  ___)| |_)| | | | | || (_| |  ) ) ) )
    '  |____| .__|_| |_|_| |_\__, | / / / /
    =========|_|==============|___/=/_/_/_/
    ```
* Spring Boot Banner have three modes:  
    * Off
    * Log
    * Console (default)
* We can set banner mode using below property in "application.properties" file
    * `spring.main.banner-mode=off`
* We can customize banner text in Spring Boot Application.
    * By creating "banner.txt" file in src/main/resources folder.


### Runners in Spring Boot
* Runners are used to execute the logic only once the boot application is started.
* SpringApplication.run() method will call the Runners.
* In Spring Boot we have two types of RUnners:
    1. ApplicationRunner (I)
    2. CommandLineRunner (I)
* Code Example:
    * ApplicationRunner: `run(ApplicationArguments args)`
        ```java
        @Component
        public class MyAppRunner implements ApplicationRunner {
            @Override
            public void run(ApplicationArguments args) throws Exception {
                System.out.println("AppRunner :: run() method executed...");
            }
        }
        ```
    * CommandLineRunner: `String... args`
        ```java
        @Component
        public class MyCmdRunner implements CommandLineRunner {
            @Override
            public void run(String... args) throws Exception {
                System.out.println("CmdRunner :: run() method executed...");
            }
        }
        ```
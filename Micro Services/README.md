### What is Distributed Application?
* If one application is communicating with another application then it is called as Distributed Application.


### Distributed Technologies
1. CORBA
2. RMI
3. EJB
4. SOAP-Based Webservices
5. RESTful Services


### What is Interoperability?
* Irrespective of language and platform if applications are communicating then they are called as Interoperable applications
	* Java <---> Python
    * Python <---> .Net
    * .Net <---> PHP
* By using RESTFul services, we can develop Interoperable applications.

---

### XML
* XML stands for Extensible Markup Language
* XML Governed by w3c org
* XML is platform independent and language independent
* XML is used to exchange data between application
* XML represent data in tags format
     * `<id>101</id>`
     * `<name>Himanshu</name>`
* In XML wa can use two types of tags:
	1. Simple Element
    2. Compound Element
* **Simple Element**: The element which represents the data directly is called a Simple Element.
* **Compound Element**: The element which represents child element is called a Compound Element.


#### JAX-B API
* JAX-B stands for Java Architecture for XML binding.
* Using JAX-B API we can convert xml data to java object and java object to xml object.
    * Marshalling: Convert a Java object to XML data
    * Un-Marshalling: Convert XML to a Java object
* To perform Marshalling and Un-marshalling, we need to create Binding Classes.
* Binding class means the class which represents XML structure.
* NOTE:
    * Up to JDK 1.8 JAX-B was part of JDK Software
    * From JDK 1.9 version JAX-B removed from JDK
    * To use JDK in our project, which is using java 1.9 or above version, should have jax-b dependency

---

### JSON
* JSON stands for Java Script Object Notation.
* JSON represents data in key-value format.
* JSON is lightweight.
* JSON is interoperable (Platform & Language Independent)
* We can use JSON structure to exchange data from one application to another application.
* NOTE: When compared to XML, JSON will take less memory
* To work with JSON, java directly does not have API, we have to use below third party APIs:
    1. Jackson (It is default in Spring Boot)
    2. Gson (Given by Google)
    3. JSON-B (Jakarta EE standard)
    4. Moshi (by Square, modern & safe)
    5. Fastjson2 (by Alibaba, very fast)
* Using above APIs we can convert Java Object to JSON and JSON to Java Object.
    * Serialization: Convert Java Object to JSON
    * De-Serialization: Convert JSON data to Java Object

#### Jackson API
* Dependency:
    ```xml
    <dependency>
        <groupId>com.fasterxml.jackson.core</groupId>
        <artifactId>jackson-databind</artifactId>
    </dependency>
    ```
* Marshalling:
    ```java
    ObjectMapper objectMapper = new ObjectMapper();
    objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
    try {
        objectMapper.writeValue(new File("./src/main/resources/passenger.json"), passenger);
        String passengerJson = objectMapper.writeValueAsString(passenger);
        System.out.println(passenger);
        System.out.println(passengerJson);
    } catch (IOException e) {
        throw new RuntimeException(e);
    }
    ```
* Un-marshalling
    ```java
    ObjectMapper objectMapper = new ObjectMapper();
        try {
            Passenger passenger = objectMapper.readValue(new File("./src/main/resources/passenger.json"), Passenger.class);
            System.out.println(passenger);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    ```

#### Gson API
* Dependency:
    ```xml
    <dependency>
        <groupId>com.google.code.gson</groupId>
        <artifactId>gson</artifactId>
    </dependency>
    ```
* Serialization:
    ```java
    // Gson gson = new Gson();
    Gson gson = new GsonBuilder().setPrettyPrinting().create();
    String passengerJson = gson.toJson(passenger);
    ```
* De-serialization:
    ```java
    Gson gson = new Gson();
    Passenger passenger = gson.fromJson(new FileReader("./src/main/resources/passenger.json"), Passenger.class);
    System.out.println(passenger);
    ```

---

### HTTP Protocol
* Hypertext Transfer Protocol
* HTTP acts as a mediator between Client and Server
* HTTP Methods
    * GET
    * POST
    * PUT
    * DELETE
* HTTP Status Codes

#### HTTP Status Codes
* The Server will send HTTP Status code to client in the response.
* HTTP Status Codes will indicate how the Server processed our request.
* Status COdes:
    * 1XX: Informational Status Code
    * 2XX: Success Status (OK)
    * 3XX: Redirectional
    * 4XX: Client Error
    * 5XX: Server Error

#### HTTP Request Packet
1. Request Line
    * HTTP Method + Request URL
    * Example: `GET: www.irctc.com/ticket/1234`
2. Request Header
    * Meta Data of Request
    * Example:
        * `Content-Type=application/json`
        * `Accept=application/json`
3. Request Body
    * Payload
    * Example: XML or JSON Data

#### HTTP Response Packet
1. Response Line
    * HTTP Status Code + Status Message
    * Example: 200 OK
2. Response Header
    * Meta Data
    * Example:
        * `Content-Type: application/json`
        * `Content-Length: 100`
        * `Date: mm/dd/yyyy`
3. Response Body
    * Payload
    * Example: XML or JSON Data

---

### REST API Development
* It is very simple to develop REST API using Spring Boot.
* Spring Boot provided `web-starter` to develop both web and distributed applications.
* `web-starter` will provide Tomcat as default embedded server.

#### Steps to develop REST Application
1. Create Spring-Starter Project with below dependency
    * `spring-boot-starter-web`
2. Create REST Controller class using `@RestController` annotation to handle request & response.
3. Write the required methods & bind them to HTTP Protocol 
4. Run the boot application
5. Test our REST Application using Postman tool.

---

### Media Types
* consumes: It represents in which format REST API can take input.
* produces: It represents in which format REST API can provide output.
* Content-Type: It represents in which format a client sending data to REST API.
* Accept: It represents in which format a client expecting response from REST API.

---

### Swagger
* Need:
    * In distributed applications two actors will be available
        1. Provider
        2. Consumer
    * Provider will be developed by one company.
    * Consumer will be developed by another company.
    * If consumer/client wants to access provider, consumer side dev team should know provider information, like:
        * What is provider API URL?
        * What operations (methods) provider having?
        * Operations are bind to which request type (GET, POST, PUT or DELETE)?
        * What input provider expecting from consumer?
        * What output provider will give to consumer?
        * Which data from provider will support for input and output?
    * NOTE: If consumer/client side dev team having all the above information then only they can start consumer side development.
    * NOTE: Provider side dev team should provide API documentation to consumer side dev team.
* Swagger
    * Swagger is used to generate API documentation.
    * Swagger is a third party library which is used to generate REST API documentation.
    * Integrate Swagger in our App:
        * Dependency:
            ```xml
            <dependency>
                <groupId>org.springdoc</groupId>
                <artifactId>springdoc-openapi-starter-webmvc-ui</artifactId>
                <version>2.6.0</version>
            </dependency>
            ```
        * Config (Optional):
            ```java
            @Configuration
            public class SwaggerConfig {
                @Bean
                public OpenAPI apiInfo() {
                    Info info = new Info();
                    info.title("ERail Service API")
                            .version("v1")
                            .description("REST API documentation for ERail Service");
                    return new OpenAPI().info(info);
                }
            }
            ```

---

### REST Client Development
* The application which is accessing another application is called as REST client.
* In Spring Boot we can develop REST Client in 3 ways:
    1. RestTemplate class (Synchronous)
    2. WebClient interface (Synchronous & Async) (introduced in spring 5.x version)
    3. FeignClient interface (Spring Cloud)

#### WebClient
* WebClient is a predefined interface introduced in Spring 5.x version
* Using WebClient interface, we can develop REST client logics.
* WebClient supports both sync and async communication.
* Sync  : Blocking Thread (After sending request we have to wait for response)
* Async : Non Blocking Thread (After sending request we no need to wait for response)

* RestTemplate (C)    : spring-boot-starter-web
* WebClient (I)       : spring-boot-starter-webflux

---

### Spring Data REST
* It is used to simplify REST API development.
* We don't need to create REST Controllers to perform CRUD operations with DB table.
* To use Data-REST in our project, we need to add below dependency in pom:
	```xml
 	<dependency>
		<groupId>org.springframework.boot</groupId>
		<artifactId>spring-boot-starter-data-rest</artifactId>
	</dependency>
	```

* Below will be the Repository to expose the REST endpoints:
	```java
	@Repository
	@RepositoryRestResource(path = "books")
	public interface BookRepo extends JpaRepository<Book, Integer> {
		List<Book> findByNameContaining(String name);
	}
	```

* Below will be the config to restrict the REST APi exposure:
    ```java
    @Configuration
    public class MyDataRestConfig implements RepositoryRestConfigurer {
        @Override
        public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config, CorsRegistry cors) {
            HttpMethod[] unsupportedMethods = { HttpMethod.PUT, HttpMethod.PUT };
            config.getExposureConfiguration()
                .forDomainType(Book.class)
                .withItemExposure((metadata, http) -> http.disable(unsupportedMethods))
                .withCollectionExposure((metadata, http) -> http.disable(unsupportedMethods));
            RepositoryRestConfigurer.super.configureRepositoryRestConfiguration(config, cors);
        }
    }
    ```

---

### Exception Handling
* Exception means en-expected and unwanted situation.
* Exception will cause abnormal termination of our program.
* To achieve graceful termination, we need to handle exception in our application.
* In Spring Boot, we can handle exception in two ways:
    1. Local Exception Handling
    2. Global Exception Handling

#### Steps to implement Exception Handling
1. Create Spring Boot Project with Web Starter
2. Create REST controller with required methods
3. Create User Defined Exception Class
4. Create Exception Info binding class
5. Create Rest Controller Advice to handle global exceptions in our application

#### Code Snippets
* Response Class
    ```java
    @Data
    @Builder
    public class ExceptionInfo {
        private String code;
        private String message;
        private LocalDateTime timestamp;
    }
    ```
* Custom Exception Class
    ```java
    public class CustomerNotFoundException extends RuntimeException {
        public CustomerNotFoundException() {}
        public CustomerNotFoundException(String message) {
            super(message);
        }
    }
    ```
* Global Exception Handler
    ```java
    @RestControllerAdvice
    public class GlobalExceptionHandler {
        @ExceptionHandler(value = CustomerNotFoundException.class)
        public ResponseEntity<ExceptionInfo> handleCustomerNotFound(CustomerNotFoundException ex) {
            ExceptionInfo response = ExceptionInfo
                    .builder()
                    .code("HN11ZX")
                    .message(ex.getMessage())
                    .timestamp(LocalDateTime.now())
                    .build();
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }
    }
    ```

---

### REST Architecture Principles
* REST: Representation State Transfer

1. Client Server Architecture
2. No State / Session Management
3. Unique Addressability
4. Map REST API endpoints to HTTP Methods
5. MediaType Representation
6. HATEOAS (Hypermedia As The Engine Of Application State)

#### HATEOAS
* It is one of the REST Architecture Principle.
* It is used to send response along with hyperlinks for related data.
* Code Snippet:
    * Dependency
        ```xml
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-hateoas</artifactId>
        </dependency>
        ```
    * Controller:
        ```java
        package com.example.controller;

        import com.example.entity.User;
        import org.springframework.hateoas.EntityModel;
        import org.springframework.hateoas.Link;
        import org.springframework.http.HttpStatus;
        import org.springframework.http.ResponseEntity;
        import org.springframework.web.bind.annotation.GetMapping;
        import org.springframework.web.bind.annotation.RestController;

        import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
        import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

        @RestController
        public class UserRestController {

            @GetMapping("/user")
            public EntityModel<User> getUser() {
                User user = User.builder().id(101).name("Himanshu").email("emailofhim@gmail.com").build();

                return EntityModel.of(user,
                        linkTo(methodOn(UserRestController.class).getUser()).withSelfRel(),
                        linkTo(methodOn(UserRestController.class).getUser()).withRel("close"),
                        linkTo(methodOn(UserRestController.class).getUser()).withRel("assign")
                );
            }
        }
        ```

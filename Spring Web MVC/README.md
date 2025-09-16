# Spring Web MVC

## Intro
* It is one module available in Spring Framework.
* Spring Web MVC is used to develop two types of application:
    1. Web Application
    2. Distributed Application
* Web and Distributed applications development made easy.
* Form Data Binding to Java Objects.
* Flexibility in Form Binding (Type Casting will be done).
* Form Validation (Server side Validation).
* Supports multiple presentation technologies
    * Example: Jsp, Thymeleaf
* Embedded Servers (Default: Tomcat)


### Spring Web MVC Architecture
1. **Dispatcher Servlet**: It acts as a front controller.
2. **HandlerMapper**: It will identify which request should be processed by which controller and which method.
3. **Controller**: It will handle request and decides response to send using ModelAndView object.
4. **ModelAndView**: Model represents data in key-value format, View represents logical file name to display.
5. **View Resolver**: It is used to identify the physical location of the view files.
6. **View**: It is used to render model data on a view file.


### Building First Spring Web MVC Application
1. Create Spring Starter Project
    1. spring-boot-starter-web
    2. tomcat-embed-jasper
    3. spring-boot-devtools
2. Create Controller class using @Controller annotation
3. Write required methods in Controller class and bind them to Http request methods.
4. Create a Presentation file.
5. Configure View Resolver in application.properties file.
6. Run the application and test.
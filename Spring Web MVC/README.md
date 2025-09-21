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


### Query Parameters
* Query Parameters are also called as Request Parameters.
* Query Parameters are used to send the data from Client to Server in URL.
* Query Parameters represents the data in the form of key value pairs.
* Query Parameters should present only at the end of the URL.
* Query Parameters will start with '?' symbol.
* Query Parameters will be separated by '&' symbol.
* Example:
    * www.youtube.com/watch?v=ajdnjf
    * www.ashokit.in?course=sbms&trainer=ashok
* To read the Query Parameters in Spring Controller we will use `@RequestParam` annotation.

### Path Parameters
* Path parameters are also called as URI parameters.
* Path Parameters are used to send the data from Client to Server in URL.
* Path parameters will represent the data directly without key value.
* Example:
    * www.ashokit.in/course/{cname}/trainer/{tname}
* Path Parameters can present anywhere in the URL.
* To read the Path Parameters in Spring Controller we will use `@PathVariable` annotation.


### Form Development
* Forms are an essential part in web application.
* Forms are used to collect data from users to perform business operations

### Form Tag Library
* Spring Web MVC module provided a Form Tag library to simplify form development.
* Available Tags:
    * \<form:form/>
    * \<form:input/>
    * \<form:password/>
    * \<form:radiobutton/>
    * \<form:select/>
    * \<form:checkbox/>

* To use a web mvc form tag library, we have to use the below directive:
    * `<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>`


### Thymeleaf
* Thymeleaf we can use as a presentation technology in Spring Web MVC based application. 
* Thymeleaf is an alternate of JSP.
* JSP files can't be executed in the browser directly, JSP page should be converted into Servlet for execution.
* Thymeleaf is a template engine that can be used in HTML pages directly.
* HTML page will be executed in browser directly.
    * HTML + Thymeleaf = Dynamic Web Pages
* Performance wise Thymeleaf pages are much faster than JSP pages.
* Thymeleaf introduced to overcome the problem of JSP.
* To use Thymeleaf in boot applications, we need to add below starter:
    * `spring-boot-starter-thymeleaf`

#### Application Development with Thymeleaf
1. Create boot app with the below dependencies:
   * web-starter
   * thymeleaf-starter
   * devtools
2. Create Spring Controllers with required methods.
3. Create Thymeleaf templates under `src/main/resources/templates` folder (file extension is `.html`).
4. Add below thymeleaf template in html file:
   * `<html xmlns:th="http://www.thymeleaf.org" lang="en">`
5. Run the application and test it.

### How to configure Jetty as Embedded Server?
* Exclude default embedded tomcat dependency and add jetty starter dependency.
* Code Example:
    ```xml
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-web</artifactId>
        <exclusions>
            <exclusion>
                <groupId>org.springframework.boot</groupId>
                <artifactId>spring-boot-starter-tomcat</artifactId>
            </exclusion>
        </exclusions>
    </dependency>
    ```
    ```xml
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-jetty</artifactId>
    </dependency>
    ```


### What is Interceptor in Spring Web MVC?
* We can use Interceptor to perform pre-processing nad post-processing of every request.
    * Pre-Processing: Before Request Processing by Controller method.
    * Post-Processing: After Request processed by the Controller method.
* Using Interceptor, we can trap each and evry request.
* Use case for Interceptor:
    * Calculate each request processing time
    * Log Request & Response Details
    * Request Authentication
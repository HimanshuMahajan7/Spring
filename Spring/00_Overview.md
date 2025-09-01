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

`Note`: Frameworks will be developed using Programming Languages only.

### Boiler Plate Code / Redundant Code?
* If we are  writing same code fo multiple times then it is called as Boiler Plate / Redundant Code.

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

## Spring Core
* Spring Core Module is all about managing dependencies among the classes with loosely coupling
* In project, we will develop several classes. All those classes can be categorized in 3 types
    * POJO
    * Java Bean
    * Component

#### What is POJO?
* **Plain Old Java Object**
* Any Java class that can be compiled by using only JDK software is called as POJO class.
* Examples:
    * Valid Pojo
        ```java
        class Demo1 {
            int id;
            String name;
        }
        ```
        ```java
        class Demo2 extends Thread {
            int id;
            String name;
        }
        ```
        ```java
        class Demo3 implements Runnable {
            void run() {

            }
        }
        ```

    * Invalid POJO:
        ```java
        class Demo implements Servlet {
            // run method
        }
        ```

#### What is Java Bean?
* Any Java class that follows bean specification rules is called as Java Bean
    1. Class should implement Serializable interface
    2. Class should have private data members (variables)
    3. Every private variable should have a public getter and public setter method
    4. Class should have zero param constructor
* Bean classes are used to write business logic and to store & retrieve the data.

#### What is Component?
* The Java classes that contains business logic are called as Component Classes.
* Example:
    * Controllers: Will have logic to deal with Request & Response
    * Service: Will have business logic of our project
        Example: Generate OTP, Send OTP, Send eMAIL, Encrypt & Decrypt password, etc
    * DAO: Will contain the logic to communicate with Database

#### Way Java classes communicated each other?
* In Java onc class can talk to another class in two ways
    1. Inheritance (IS - A)
    2. Composition (Has - A)

#### What is dependency Injection?
* The process of injecting one class object into another class is called as **Dependency Injection**.
* We can perform dependency injection in 3 ways
    * Setter Injection
    * Constructor Injection
    * Field Injection

#### 1. Setter Injection
* Setter Injection means, injecting dependent object into target object using target class setter method.

    ```java
    class Car {
        private IEngine eng;

        public void setEng(IEngine eng) {
            this.eng = eng;
        }

        public void drive() {
            int start = eng.start();
        }
    }
    ```

#### 2. Constructor Injection
* Constructor Injection means injecting a dependent object into a target object using target class constructor.

    ```java
    class Car {
        private IEngine eng;

        public Car(IEngine eng) {
            this.eng = eng;
        }

        public void drive() {
            int start = eng.start();
        }
    }
    ```

#### 3. Field Injection
* Field injection means injecting the dependent object into target class using target class variable.

    ```java
    class Car {
        private IEngine eng;

        public void drive() {
            int start = eng.start();
        }
    }

    public class Main {
        public static void main(String[] args) {
            Class<?> clz = Class.forName("in.himanshu.Car");
            Object object = clz.newInstance();
            Car carObject = (Car) object;

            Field engField = clz.getDeclaredField("eng");
            engField.setAccessible(true);

            // Injecting value to variable
            engField.set(carObj, new PetrolEngine());

            carObj.drive();
        }
    }
    ```

### IOC Container
* **Inversion Of Control**
* The IoC is responsible for Dependency Injection in Spring Application.
* Dependency Injection means creating and injecting dependent bean objects into target bean classes.
* Note: IoC Container will manage the life cycle of Spring Beans.

#### What is Spring Bean?
* Any Java class whose lifecycle (creation & destruction) is managed by IOC is called as Spring Bean.
* We can represent Java class as Spring Bean in two ways:
    1. XML Approach
        * `<bean id="id1" class="pkg.ClassName"/>`
    2. Annotation Approach (Recommended)
        * @Component, @Service, @Repository, etc
* Note: In Spring, we can use both XML & Annotation approaches. SpringBoot will support only Annotations (no xml).

#### How to start the IoC in Spring?
1. BeanFactory (Outdated/Deprecated)
2. ApplicationContext (recommended)
    * Example: `ApplicationContext context = new ClassPathXmlApplicationContext(String configFIle);`

* Note: Bean Configuration file contains Bean Definitions
    * Target Class, Dependent Class, Dependency Injection Type
* Note: When IoC container starts, it will read the bean definitions from the Bean Configuration File and it will perform Dependency Injection.

#### First Application Development using Spring Core Module
1. Create Maven Project in IDE
2. Add Spring Core Dependency in pom.xml file (www.mvnrepository.com)
3. Create Required Java classes
4. Create Bean Configuration File and configure Bean Definitions
5. Create Main class and start IOC Container to test the application

#### Differences b/w BeanFactory & ApplicationContext?
* BeanFactory interface having `XmlBeanFactory` as implementation class.
    * Example: `BeanFactory beanFactory = new XmlBeanFactory(new ClassPathResource("beans.xml"));`
* ApplicationContext interface having `ClassPathXmlApplicationContext` as implementation class.
    * Example: `ApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");`
* BeanFactory will follow Lazy Loading concept that means when we request then only it will create Bean object.
* ApplicationContext will follow Eager Loading fo Singleton Beans, for Prototype Beans it will follow Lazy Loading
* Note: Spring Bean default scope is Singleton
* `XmlBeanFactory` is deprecated/outdated, it is not available in current versions of Spring.
* It is recommended to create IoC using `ApplicationContext`.

#### Eager Loading & Lazy Loading
* Eager Loading means creating objects for Spring Bean when IoC starts.
* Lazy Loading means creating objects for Spring Bean when we call getBean() method.

#### Setter Injection vs Constructor Injection
* For Setter Injection we need to use `<property/>` tag.
* FOr Constructor Injection we need to use `<constructor-arg>` tag.
* If both we do both the injection, then Setter Injection will override the Constructor Injection.

### Beans Scope
* Scope represents how many objects should be created for a Spring Bean.
* In the Spring Framework, we have below scopes:
    1. Singleton (**default scope)
    2. Prototype
    3. Request
    4. Session
* To represent bean scope, we will use **scope** attribute
    * `<bean id="id" class="package.ClassName" scope="singleton | prototype | request | session" />`

#### Singleton Scope
* `Singleton Scope` means only one object will be created for the class in IoC Container.

#### Prototype Scope
* `Prototype Scope` means every time new object will be created.

##### Note: Request & Session scopes are related to Web MVC module.

#### Why is Spring Bean by default Singleton?
* **To save memory of JVM**
* To save memory of JVM Spring team made singleton as default scope for the spring beans.
* Example: Rest Controllers, Controllers, Services and DAOs will be considered as Singleton in the project

* Example:
    * TicketGenerator class is used to generate Ticket for every Customer
    * TicketGenerator -> Singleton
    * Ticket -> Prototype

---

### Autowiring
* We can inject dependent bean into target bean in two ways
    1. Manual Wiring
    2. AutoWiring

#### 1. Manual Wiring
* Manual Wiring means programmer will inject dependent object into target object using `<property/>` tag or `<constructor-arg/>` tag.
    ```xml
    <bean id="petrolEng" class="org.example.beans.impl.PetrolEngine"/>

    <bean id="car" class="org.example.beans.Car">
        <property name="eng" ref="petrolEng"/>
        <constructor-arg name="eng" ref="dieselEng" />
    </bean>
    ```

#### 2. Autowiring
* Autowiring means IoC Container will identify the dependent bean, and it will inject into target bean.
* We don't need to use any `ref` attribute in bean configuration.
* Autowiring will work on below modes:
    1. byName
    2. byType
    3. constructor
    4. no
* Autowiring will not work by default, we have to enable autowiring on target bean like below
    * `<bean id="id" class="package.ClassName" auto-wire="byName | byType | constructor" />`
* **Note: Autowiring will only work for Reference Type variable (not applicable for Primitive Types)

    #### 1. byName
    * `byName` means IoC will identify the dependent bean object based on `bean id` or `bean name`.
    * Example:
        ```java
        public class Car {
            IEngine eng;

            public Car() {
                System.out.println("Car :: Zero Param Constructor");
            }

            public void setEng(IEngine eng) {
                System.out.println("setEng() method called");
                this.eng = eng;
            }

            public void drive() {
            }
        }
        ```

        ```xml
        <bean id="eng" class="org.example.beans.impl.PetrolEngine"/>
        <bean id="dieselEng" class="org.example.beans.impl.DieselEngine"/>
        <bean id="car" class="org.example.beans.Car" autowire="byName" />
        ```

    * In the above example the Car class variable name `eng` is matched with `PetrolEngine` bean id hence **PetrolEngine** obj is injected into Car class object.

    #### 2. byType
    * `byType` means IoC will identify the dependent bean object based on `data type` of the variable in Target class.
    * If one interface having two implementations then there is a chance of getting an ambiguity problem, to overcome that we need to use *autowire-candidate* attribute.
        * autowire-candidate="true" -> Eligible for Autowiring
        * autowire-candidate="false" -> Not Eligible for Autowiring
    
    * Example:
        ```java
        IEngine eng; // Data TYpe of eng is IEngine, which is an interface
        ```
        ```xml
        <bean id="eng" class="org.example.beans.impl.PetrolEngine" autowire-candidate="true"/>
        <bean id="dieselEng" class="org.example.beans.impl.DieselEngine" autowire-candidate="false"/>

        <bean id="car" class="org.example.beans.Car" autowire="byType" />
        ```

    * **Note: As an alternate for `autowire-candidate="true"`, we can use `primary="true"` to consider bean for Autowiring.
        * Example:
        ```xml
        <bean id="eng" class="org.example.beans.impl.PetrolEngine" primary="true"/>
        <bean id="dieselEng" class="org.example.beans.impl.DieselEngine"/>

        <bean id="car" class="org.example.beans.Car" autowire="byType" />
        ```

    #### 3. constructor
    * It is used to perform Autowiring by calling target class constructor.
    * Example:
        ```java
        public Car(IEngine eng) {
            System.out.println("Car :: Param Constructor");
            this.eng = eng;
        }
        ```
        ```xml
        <bean id="eng" class="org.example.beans.impl.PetrolEngine" autowire-candidate="false"/>
        <bean id="dieselEng" class="org.example.beans.impl.DieselEngine" autowire-candidate="true"/>

        <bean id="car" class="org.example.beans.Car" autowire="constructor" />
        ```
    
    #### 4. no
    * If we don't want autowiring or want to disable the autowiring, then we can go for `autowire="no"` mode.

---

### Spring Bean Life Cycle
* Life cycle means starting to end or birth to death
    * Thread Life Cycle
    * Servlet Life Cycle
    * JSP Life Cycle
    * Spring Bean Life Cycle
* Spring Bean object creation and object destruction will be taken care by IoC Container.
* Spring Bean Life Cycle will be managed by IoC Container.
* We can perform some operations using Bean Life Cycle Methods
    * init()
    * destroy()
* Spring Bean Life Cycle methods we can execute in three ways
    1. XML Approach (Declarative)
    2. Programmatic Approach
    3. Annotation Approach


#### 1. XML Approach
* \<bean id="motor" class="org.example.Motor" `init-method`="start" `destroy-method`="stop" />
* **init-method**: This attribute represents the method which should be called after a bean object is created.
* **destroy-method**: This attribute represents the method which should be called when a bean object is removed from the IoC Container.
* Example:
    ```java
    public class Motor {
        public Motor() {
            System.out.println("Motor :: Constructor");
        }

        public void start() {
            System.out.println("Motor Started...");
        }

        public void doWork() {
            System.out.println("Motor Pulling Water...");
        }

        public void stop() {
            System.out.println("Motor Stopped...");
        }
    }
    ```
    ```xml
    <!-- XML Approach -->
    <bean id="motor" class="org.example.Motor" init-method="start" destroy-method="stop" />
    ```

#### 2. Programmatic Approach
* We need to implement predefined interfaces provided by Spring Framework
    * `InitializingBean`: afterPropertiesSet()
    * `DisposableBean`: destroy()
* Example:
    ```java
    public class MotorProgrammaticApproach implements InitializingBean, DisposableBean {
        public MotorProgrammaticApproach() {
            System.out.println("MotorProgrammaticApproach :: Constructor");
        }

        public void doWork() {
            System.out.println("MotorProgrammaticApproach Pulling Water...");
        }

        @Override
        public void afterPropertiesSet() throws Exception {
            System.out.println("MotorProgrammaticApproach Started ...");
        }

        @Override
        public void destroy() throws Exception {
            System.out.println("MotorProgrammaticApproach Stopped !!!!");
        }
    }
    ```

#### 3. Annotation Approach
* We need to used below annotations to obtain the Spring Bean Lifecycle
    * `@PostConstruct`: It represents init method
    * `@PreDestroy`: It represents destroy method
* Note: This annotations are not available in Spring framework they are from Java and now from Jakarta.
* Code Example:
    ```java
    public class MotorAnnotationApproach {
        public MotorAnnotationApproach() {
            System.out.println("MotorAnnotationApproach :: Constructor");
        }

        public void doWork() {
            System.out.println("MotorAnnotationApproach Pulling Water...");
        }

        @PostConstruct
        public void m1() {
            System.out.println("MotorAnnotationApproach Started...");
        }

        @PreDestroy
        public void m2() {
            System.out.println("MotorAnnotationApproach Stopped...");
        }
    }
    ```
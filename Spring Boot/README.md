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

---

### Spring Data JPA
* Spring Data JPA is used to develop Persistence layer in the application.
* Spring Data JPA provides ready-made methods to perform CRUD operations in DB.
* When we go for Spring Data JPA two interfaces are available:
    1. CrudRepository (I)
    2. JpaRepository (I)
* Note: JpaRepository = CrudRepository + Pagination Methods + Sorting Methods


#### Spring Data JPA Terminology
1. Data Source Object
    * Data Source properties we can configure in application.properties or application.yml
2. Entity Class
    * The class which is mapped with database table
    * Annotations:
        * @Entity
        * @Table
        * @Id
        * @Column
3. Repository Interface:
    * For table, we will create one repository interface to perform CRUD operations
        ```java
        public interface StudentRepository extends CrudRepository<Entity, Id> {

        }
        ```
    * Note: By using StudentRepository we can perform CRUD operations in STUDENT_TBL
    * Note: For our Repository Interface, the implementation will be provided in the runtime using Proxy Class.
4. Repository Methods:
    * Ready-made methods are provided by Data JPA to perform CRUD operations
        1. `save(Entity)`
        2. `saveAll(Iterable<Entity>)`
            * Note: Above, two methods are called as "UPSERT" methods (UPDATE + INSERT).
        3. `findById(Id)`
        4. `findAllById(Iterable<Id>)`
        5. `findAll()`
        6. `count()`
        7. `existById(Id)`
        8. `deleteById(Id)`
        9. `deleteAllById(Iterable<Id>)`
        10. `deleteAll()`

5. ORM Properties
    * To automate database configuration
        1. auto_ddl: Dynamic Schema Generation
        2. show_sql: Display generated queries on the console


#### First Application Development using Spring Data JPA
1. Create Spring Starter Project with the below dependencies
    * spring-boot-starter-data-jpa
    * mysql-connector
2. Create entity class and map with database table using annotations
3. Create Repository Interface
4. Configure Database source properties int application.properties / application.yml
5. Run the application and test the functionality

#### Ways to perform database operation using JPA
1. Using JPA pre-defined methods (Select + Non-Select)
2. Using findByXXX methods (Note: only for select operation)
3. Using Custom Queries (Select + Non-Select)

#### **`findByXXX`** methods in Data JPA
* By using `findByXXX()` methods we can retrieve the data based on the non-primary key columns also.
* When we write `findByXXX()` method, JPA will construct query based on method name.
* Method naming convention is very important for `findByXXX()` methods.
* Using `findByXXX()` methods we can perform select operations only (retrieval). INSERT / UPDATE / DELETE operations we can't do using findBy methods.
* Note: In `findByXXX()` method syntax we will use entity variable names.
* Code Example:
    * Entity Class
        ```java
        @Entity
        @Table(name = "STUDENT")
        public class Student {
            @Id
            private Integer id;
            private String name;
            @Column(name = "student_rank")
            private Long rank;
            private String gender;
        }
        ```
    * Repository Interface
        ```java
        public interface StudentRepository extends CrudRepository<Student, Integer> {
            List<Student> findByGender(String gender);
            List<Student> findByGenderIsNull();
            List<Student> findByRankGreaterThanEqual(int rank);
            List<Student> findByRankLessThanEqual(int rank);
            List<Student> findByGenderAndRankGreaterThanEqual(String gender, int rank);
        }
        ```

#### Custom Queries
* We can also execute Custom Queries in JPA.
* To execute custom queries, we need to use `@Query` annotation
* `@Query` will support for executing both HQL queries and Native SQL queries also.
    * **HQL**: Hibernate Query Language (Database Independent Queries)
        * In HQL, we will use Entity class name and Entity class variable to write a query.
        * HQL queries will convert to SQL queries by **Dialect** class
        * If we change app from one DB to another DB, then no need to change any query because Dialect class will take care of the query conversion.
        * Performance wise, HQL query will give poor performance because of query conversion.
    * **SQL**: Structured Query Language (Database Dependent Queries)
        * In SQL, we will use table name and column name to write the queries.
        * SQL queries will directly execute in database.
        * If we change the app from one DB on another DB then all queries may not execute.
        * Performance wise, SQL query will give better performance than HQL.

#### Selection and Projection
* **Selection**:
    * Retrieving specific rows from the table. We can achieve by this using `where` keyword in the query.
    * Example: `select * from student where gender = "Male";`

* **Projection**:
    * Retrieving specific columns from the table is called as Projection.
    * We can achieve by using column names in a query
    * Example: `select name, rank, gender from student;`

* `Note`: We can combine selection and projection in a single query.


#### `JpaRepository`
* It is a predefined interface provided by Spring Data JPA
* JpaRepository provided several methods to perform CRUD operations with database.
* JpaRepository provided few additional methods to perform operations.
    * JpaRepository = CrudRepository + PagingAndSorting + QueryByExample
* Code Example:
    ```java
    public interface StudentJpaRepository extends JpaRepository<Student, Integer> {
    }
    ```
    ```java
    @SpringBootApplication
    public class Application {
        public static void main(String[] args) {
            StudentJpaRepository studentJpaRepository = context.getBean(StudentJpaRepository.class);
            List<Student> allStudentsWithJpaRepo = studentJpaRepository.findAll();
            allStudentsWithJpaRepo.forEach(System.out::println);
        }
    }
    ```

##### Pagination
* Displaying table records in multiple pages is called as Pagination.
* Code Example:
    ```java
    @SpringBootApplication
    public class Application {
        public static void main(String[] args) {
            StudentJpaRepository studentJpaRepository = context.getBean(StudentJpaRepository.class);
            
            PageRequest pageRequest = PageRequest.of(0, 3);
            Page<Student> findAll = studentJpaRepository.findAll(pageRequest);
            List<Student> findAllContent = findAll.getContent();
            findAllContent.forEach(System.out::println);
        }
    }
    ```

##### Sorting
* Sorting based on a filed
* Code Example:
    ```java
    @SpringBootApplication
    public class Application {
        public static void main(String[] args) {
            StudentJpaRepository studentJpaRepository = context.getBean(StudentJpaRepository.class);
            
            List<Student> allStudentsSorted = studentJpaRepository.findAll(Sort.by("gender"));
		    allStudentsSorted.forEach(System.out::println);
        }
    }
    ```

##### `QueryByExample`
* QueryByExample is used to construct select query dynamically based on given entity object data.
* QueryByExample is used with AND operation
* Code Example:
    ```java
    @SpringBootApplication
    public class Application {
        public static void main(String[] args) {
            StudentJpaRepository studentJpaRepository = context.getBean(StudentJpaRepository.class);
            
            Student studentExample = new Student();
            studentExample.setGender("Male");
            Example<Student> example = Example.of(studentExample);
            List<Student> studentsByExample = studentJpaRepository.findAll(example);
            studentsByExample.forEach(System.out::println);
        }
    }
    ```

#### DML Operations: Non Select Operation
* Insert, Update and Delete are non-select operation
* If we want to perform Non-Select Operation using Data JPA custom query then we should use below 2 annotations at our method.
    1. `@Modifying`
    2. `@Transactional`
* Note: The above annotations are not required for select operations
* Code Example:
    ```java
    public interface StudentJpaRepository extends JpaRepository<Student, Integer> {
    
        @Modifying
        @Transactional
        @Query("delete from Student where id = :studentId")
        void deleteStudent(Integer studentId);
    
        @Modifying
        @Transactional
        @Query("update Student set gender = :gender where id = :studentId")
        void updateStudent(Integer studentId, String gender);
    
        /* Inserting using HQL is not possible in Data JPA */
        /*
        @Modifying
        @Transactional
        @Query("insert into Student(id, name, gender, student_rank) values(:id, :name, :gender, :rank)")
        void insertStudent(Integer id, String name, String gender, Long rank);
        */
    
        @Modifying
        @Transactional
        @Query(value = "INSERT INTO STUDENT(id, name, gender, student_rank) values(:id, :name, :gender, :rank);", nativeQuery = true)
        void insertStudent(Integer id, String name, String gender, Long rank);
    }
    ```
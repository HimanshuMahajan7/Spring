# Spring Batch

## Batch Processing
* Batch Processing is the processing of large amount of data without human intervantion
* This data is finite in nature (finite amount of data)
* A typical batch job does the following -
    1. Reads the data from a data source
    2. Process the data in some way
    3. Write the processed data to a data target

### Use cases of Batch Processing
* Generation of Monthly Bank Statements
* Generation of Monthly Electricty Bills
* Producing Daily Sales report for an e-commerce site

## Spring Batch Intro
* Spring Batch is a light weight, open source framework for building java based batch applications
* It is built on top of Spring Framework

## Features of Spring Batch
* State Management
* Error Handling
* Scalability
* Built in Readers and Writers
* Transaction Management

## Concepts of Spring Batch
* Job
* Step

### Job
* A job represent the entire flow that we are goin to execute in our batch process
* It can have one or more steps that execute in an order

### Step
* A unit of work
* It represent indipendent phase in a bacth job
* As we know a job can have multiple steps, and this steps could be logically related to each other
* Example: Generate Report Job > Collect Data > Generate Report > Send Email
* Two types of steps -
    1. Tasklet step
    2. Chunk Based Step

## JobLauncher
* A JobLauncher is used to start the execution of a job
* JobLauncher can be invoked using -
    1. Scheduler
    2. REST API
    3. Spring Boot

## JobRepository
* A JobRepository is used to store metadata about a job
* It stores metadata in a database

## Annotations
* @EnableBatchProcessing

## Job FLow
1. Sequential Flow
2. Conditional Flow

## Status
1. Batch Status (STATUS)
2. Exit Status (EXIT_CODE)

### Bacth Status
* Batch Status represent the overall status of a job or step
* Specified in enum
* List of Batch status
    1. COMPLETED
    2. STARTING
    3. STARTED
    4. STOPPING
    5. STOPPED
    6. FAILED
    7. ABANDONED
    8. UNKNOWN

### Exit Status
* Exit Status represent the status of a job or step after it finishes execution
* We can also create our won Exit Status
* List of Exit Status
    1. COMPLETED
    2. STOPPED
    3. FAILED
    4. EXECUTING
    5. UNKNOWN
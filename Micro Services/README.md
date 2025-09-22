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

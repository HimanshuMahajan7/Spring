package com.example.marshall;

import com.example.binding.Person;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Unmarshaller;

import java.io.File;

public class UnmarshallDemo {
    public static void main(String[] args) {
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(Person.class);
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
            Person person = (Person) unmarshaller.unmarshal(new File("./src/main/resources/person.xml"));
            System.out.println(person);
        } catch (JAXBException e) {
            throw new RuntimeException(e);
        }
    }
}

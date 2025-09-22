package com.example.marshall;

import com.example.binding.Address;
import com.example.binding.Person;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;

import java.io.File;

public class MarshallDemo {
    public static void main(String[] args) {
        try {
            Address address = new Address();
            address.setCity("Pithampur");
            address.setState("Dhar");
            address.setCountry("India");

            Person person = new Person();
            person.setId(101);
            person.setName("Himanshu");
            person.setGender("Male");
            person.setEmail("himanshu@emial.in");
            person.setAddress(address);

            JAXBContext jaxbContext = JAXBContext.newInstance(Person.class);
            Marshaller marshaller = jaxbContext.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            marshaller.marshal(person, System.out);
            marshaller.marshal(person, new File("./src/main/resources/person.xml"));
        } catch (JAXBException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
}

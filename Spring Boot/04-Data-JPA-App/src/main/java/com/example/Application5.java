package com.example;

import com.example.entity.Address;
import com.example.entity.Employee;
import com.example.repository.AddressRepository;
import com.example.repository.EmployeeRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.List;

@SpringBootApplication
public class Application5 {
    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(Application5.class);
        EmployeeRepository employeeRepository = context.getBean(EmployeeRepository.class);
        AddressRepository addressRepository = context.getBean(AddressRepository.class);

        Employee employee = new Employee();
        employee.setEmpName("Himanshu");
        employee.setEmpSalary(70000000.00);

        Address address1 = new Address();
        address1.setCity("Indore");
        address1.setState("MP");
        address1.setCountry("India");
        address1.setEmp(employee);

        Address address2 = new Address();
        address2.setCity("Bangalore");
        address2.setState("KA");
        address2.setCountry("India");
        address2.setEmp(employee);

        employee.setAddresses(List.of(address1, address2));

        System.out.println("\n********** 1. Association Save (Entity & Mapping) **********");
        employeeRepository.save(employee);

        System.out.println("\n********** 2. Association Find (Entity & Mapping) **********");
        employeeRepository.findById(1);

        System.out.println("\n********** 3. Association Delete (Entity & Mapping) **********");
        employeeRepository.deleteById(1);

        Employee employee1 = new Employee();
        employee1.setEmpName("Himanshu");
        employee1.setEmpSalary(70000000.00);

        Address address11 = new Address();
        address11.setCity("Indore");
        address11.setState("MP");
        address11.setCountry("India");
        address11.setEmp(employee1);

        employee1.setAddresses(List.of(address11));

        System.out.println("\n********** 4. Association Find Child (Entity & Mapping) **********");
        employeeRepository.save(employee1);
        addressRepository.findById(3);
    }
}

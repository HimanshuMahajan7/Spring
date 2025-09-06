package com.example;

import com.example.entity.Student;
import com.example.repository.StudentRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.Optional;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(Application.class, args);
		StudentRepository studentRepository = context.getBean(StudentRepository.class);
		System.out.println(studentRepository.getClass().getName());

		Student student = new Student();
		student.setId(101);
		student.setName("Gayatri Mahajan");
		student.setGender("Female");
		student.setRank(1234l);

		studentRepository.save(student);
		System.out.println("Record Inserted!!!");

		Optional<Student> studentFromDb = studentRepository.findById(100);
		System.out.println(studentFromDb);
	}

}

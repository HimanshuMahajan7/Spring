package com.example;

import com.example.entity.Student;
import com.example.repository.StudentRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.List;
import java.util.Optional;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(Application.class, args);
		StudentRepository studentRepository = context.getBean(StudentRepository.class);
		System.out.println(studentRepository.getClass().getName());

		Student student1 = new Student(101, "Himanshu", 1234L, "Male");
		Student student2 = new Student(102, "Gayatri", 1234L, "Female");
		Student student3 = new Student(103, "Himanshu Mahajan", 1234L, "Male");
		Student student4 = new Student(104, "Gayatri Mahajan", 1234L, "Female");

		System.out.println("1. save(Entity)");
		studentRepository.save(student1);
		System.out.println("Record Inserted!!!");

		System.out.println("2. saveAll(Iterable<Entity>)");
		studentRepository.saveAll(List.of(student1, student2, student3, student4));
		System.out.println("ALl records Inserted!!!");

		System.out.println("3. findById(Id)");
		Optional<Student> studentFromDb = studentRepository.findById(100);
		System.out.println(studentFromDb);

		System.out.println("4. findAllById(Iterable<Id>)");
		Iterable<Student> students = studentRepository.findAllById(List.of(101, 102, 103));
		students.forEach(System.out::println);

		System.out.println("5. findAll()");
		Iterable<Student> allStudents = studentRepository.findAll();
		allStudents.forEach(System.out::println);

		System.out.println("6. count()");
		long count = studentRepository.count();
		System.out.println("Students: " + count);

		System.out.println("7. existById(Id)");
		boolean exists = studentRepository.existsById(100);
		boolean nonExists = studentRepository.existsById(999);
		System.out.println("Is Student with id 100 exists: " + exists);
		System.out.println("Is Student with id 999 exists: " + nonExists);

		System.out.println("8. deleteById(Id)");
		studentRepository.deleteById(104);
		System.out.println("Student with id 104 deleted");

		System.out.println("9. deleteAllById(Iterable<Id>)");
		studentRepository.deleteAllById(List.of(102, 103));
		System.out.println("Students with ids 102, 103 deleted");

		System.out.println("10. deleteAll()");
		studentRepository.deleteAll();
		System.out.println("All student deleted");
	}

}

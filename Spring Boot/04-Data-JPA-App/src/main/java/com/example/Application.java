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

		Student student1 = new Student(101, "Himanshu", 100L, "Male");
		Student student2 = new Student(102, "Gayatri", 101L, "Female");
		Student student3 = new Student(103, "Himanshu Mahajan", 80L, "Male");
		Student student4 = new Student(104, "Gayatri Mahajan", 89L, "Female");
		Student student5 = new Student(105, "Gayatri Mahajan", 89L, null);

		System.out.println("\n********** 1. save(Entity) **********");
		studentRepository.save(student1);
		System.out.println("Record Inserted!!!");

		System.out.println("\n********** 2. saveAll(Iterable<Entity>) **********");
		studentRepository.saveAll(List.of(student1, student2, student3, student4));
		System.out.println("ALl records Inserted!!!");

		System.out.println("\n********** 3. findById(Id) **********");
		Optional<Student> studentFromDb = studentRepository.findById(100);
		System.out.println(studentFromDb);

		System.out.println("\n********** 4. findAllById(Iterable<Id>) **********");
		Iterable<Student> students = studentRepository.findAllById(List.of(101, 102, 103));
		students.forEach(System.out::println);

		System.out.println("\n********** 5. findAll() **********");
		Iterable<Student> allStudents = studentRepository.findAll();
		allStudents.forEach(System.out::println);

		System.out.println("\n********** 6. count() **********");
		long count = studentRepository.count();
		System.out.println("Students: " + count);

		System.out.println("\n********** 7. existById(Id) **********");
		boolean exists = studentRepository.existsById(100);
		boolean nonExists = studentRepository.existsById(999);
		System.out.println("Is Student with id 100 exists: " + exists);
		System.out.println("Is Student with id 999 exists: " + nonExists);

		System.out.println("\n********** 8. deleteById(Id) **********");
		studentRepository.deleteById(104);
		System.out.println("Student with id 104 deleted");

		System.out.println("\n********** 9. deleteAllById(Iterable<Id>) **********");
		studentRepository.deleteAllById(List.of(102, 103));
		System.out.println("Students with ids 102, 103 deleted");

		System.out.println("\n********** 10. deleteAll() **********");
		studentRepository.deleteAll();
		System.out.println("All student deleted");

		System.out.println("--------------------------------------------------");
		System.out.println("findByXXXX");
		System.out.println("Saving all Students");
		studentRepository.saveAll(List.of(student1, student2, student3, student4, student5));

		System.out.println("\n********** 11. findByGender(String gender) **********");
		List<Student> male = studentRepository.findByGender("Male");
		male.forEach(System.out::println);

		System.out.println("\n********** 12. findByGender(String gender) **********");
		List<Student> genderIsNull = studentRepository.findByGenderIsNull();
		genderIsNull.forEach(System.out::println);

		System.out.println("\n********** 13. findByRankGreaterThanEqual(int rank) **********");
		List<Student> byRankGreaterThanEqual = studentRepository.findByRankGreaterThanEqual(100);
		byRankGreaterThanEqual.forEach(System.out::println);

		System.out.println("\n********** 14. findByRankLessThanEqual(int rank) **********");
		List<Student> byRankLessThanEqual = studentRepository.findByRankLessThanEqual(100);
		byRankLessThanEqual.forEach(System.out::println);

		System.out.println("\n********** 15. findByGenderAndRankGreaterThanEqual(String gender, int rank) **********");
		List<Student> byGenderAndRankGreaterThanEqual = studentRepository.findByGenderAndRankGreaterThanEqual("Female", 100);
		byGenderAndRankGreaterThanEqual.forEach(System.out::println);

		System.out.println("--------------------------------------------------");
		System.out.println("Custom Queries");
		System.out.println("\n********** HQL, Get all Students **********");
		List<Student> studentsHql = studentRepository.getStudents();
		studentsHql.forEach(System.out::println);

		System.out.println("\n********** SQL, Get all Students **********");
		List<Student> studentsSql = studentRepository.getAllStudents();
		studentsSql.forEach(System.out::println);

		System.out.println("\n********** HQL, Get by gender **********");
		List<Student> studentByGender = studentRepository.getStudentByGender("Male");
		studentByGender.forEach(System.out::println);

		System.out.println("\n********** HQL, Get where gender is null **********");
		List<Student> studentsWhereGenderIsNull = studentRepository.getStudentsWhereGenderIsNull();
		studentsWhereGenderIsNull.forEach(System.out::println);

		System.out.println("\n********** HQL, Get where rank is greater than **********");
		List<Student> studentsWhereRankIsGreaterThan = studentRepository.getStudentsWhereRankIsGreaterThan(100);
		studentsWhereRankIsGreaterThan.forEach(System.out::println);

		System.out.println("\n********** HQL, Get where rank is less than **********");
		List<Student> studentsWhereRankIsLessThan = studentRepository.getStudentsWhereRankIsLessThan(100);
		studentsWhereRankIsLessThan.forEach(System.out::println);

		System.out.println("\n********** HQL, Get where gender is and rank is greater than **********");
		List<Student> studentsWhereGenderIsAndRankGreaterThan = studentRepository.getStudentsWhereGenderIsAndRankGreaterThan("Female", 100);
		studentsWhereGenderIsAndRankGreaterThan.forEach(System.out::println);

//		System.out.println("\n********** HQL, Get rank and gender **********");
//		List<Student> rankAndGender = studentRepository.getRankAndGender();
//		rankAndGender.forEach(System.out::println);

		System.out.println("\n\n");
	}

}

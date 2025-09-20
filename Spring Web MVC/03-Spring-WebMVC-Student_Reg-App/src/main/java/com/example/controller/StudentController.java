package com.example.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.bindings.Student;
import com.example.entity.StudentEntity;
import com.example.repo.StudentRepo;

@Controller
public class StudentController {
	
	private static final List<String> courses = List.of("Java", "DevOps", "Python", "AWS");
	private static final List<String> timings = List.of("Morning", "Afternoon", "Evening");
	
	@Autowired
	StudentRepo repo;

	@GetMapping("/")
	public String loadForm(Model model) {
		loadFormData(model);
		return "index";
	}
	
	@PostMapping("/register")
	public String registerStudent(Student student, Model model) {
		System.out.println(student);
		
		StudentEntity studentEntity = new StudentEntity();
		BeanUtils.copyProperties(student, studentEntity);
		studentEntity.setTimings(Arrays.toString(student.getTimings()));
		repo.save(studentEntity);
		
		loadFormData(model);
		model.addAttribute("msg", "Student Saved");
		return "index";
	}
	
	public void loadFormData(Model model) {
		Student student = new Student();
		model.addAttribute("courses", courses);
		model.addAttribute("timings", timings);
		model.addAttribute("student", student);
	}
	
	@GetMapping("/viewStudents")
	public String getStudentsData(Model model) {
		List<StudentEntity> students = repo.findAll();
		model.addAttribute("students", students);
		return "data";
	}
}

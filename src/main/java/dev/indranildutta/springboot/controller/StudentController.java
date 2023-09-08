package dev.indranildutta.springboot.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.indranildutta.springboot.bean.Student;

@RestController
public class StudentController {
	
	
	@GetMapping("student")
	public Student getStudent() {
		Student student = new Student(1, "Indranil", "Dutta");
		
	return student;
	}
	
	@GetMapping("students")
	public List<Student> getStudents(){
		List<Student> students = new ArrayList<>();
		students.add(new Student(1, "Sanjay", "Dutta"));
		students.add(new Student(2, "Gablu", "Dutta"));
		students.add(new Student(3, "Madhabi", "Dutta"));
		students.add(new Student(4, "Sibu", "Dutta"));

		return students;
	}
	
}

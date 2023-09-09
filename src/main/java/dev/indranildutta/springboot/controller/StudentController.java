package dev.indranildutta.springboot.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import dev.indranildutta.springboot.bean.Student;

@RestController
@RequestMapping("students")
public class StudentController {
	
	
	@GetMapping("student")
	public ResponseEntity<Student> getStudent() {
		Student student = new Student(1, "Indranil", "Dutta");
		
//	return new ResponseEntity<>(student, HttpStatus.OK);
		return ResponseEntity.ok()
				.header("custom-header", "indra")
				.body(student);
	}
	
	@GetMapping
	public ResponseEntity<List<Student>> getStudents(){
		List<Student> students = new ArrayList<>();
		students.add(new Student(1, "Sanjay", "Dutta"));
		students.add(new Student(2, "Gablu", "Dutta"));
		students.add(new Student(3, "Madhabi", "Dutta"));
		students.add(new Student(4, "Sibu", "Dutta"));

		return ResponseEntity.ok(students);
	}
	
	// Spring Boot REST API with Path Variable
	@GetMapping("{id}")
	public Student studentPathVariable(@PathVariable int id) {
		return new Student(id, "indra", "nil");
	}
	
	//Spring Boot REST API with Request Param
	@GetMapping("query")
	public Student studentRequestVariable(@RequestParam int id) {
		return new Student(id, "Indranil", "Dutta");
	}
	
	
	// Spring Boot REST API that handles HTTP POST Request - creating new resource
	@PostMapping("create")
	@ResponseStatus(HttpStatus.CREATED)
	public Student createStudent(@RequestBody Student student) {
		System.out.println(student.getId());
		System.out.println(student.getFirstName());
		System.out.println(student.getLastName());

		return student;
	}
	
	// Spring Boot REST API that handles HTTP PUT Request -  updating existing resource 
	
	@PutMapping("{id}/update")
	public Student updateStudent(@RequestBody Student student, @PathVariable("id") int studentId) {
		System.out.println(student.getFirstName());
		System.out.println(student.getLastName());
		return student;
	}
	
	
	
	// Spring boot REST API that handles HTTP DELETE Request
	@DeleteMapping("{id}/delete")
	public String deleteStudent(@PathVariable("id") int studentId) {
		System.out.println(studentId);
		return "Student deleted successfully";
	}
}







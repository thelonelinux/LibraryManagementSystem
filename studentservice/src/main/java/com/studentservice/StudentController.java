package com.studentservice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class StudentController {
	
	@Autowired
	StudentSevice studentService;
	
	@GetMapping("/students")
	public List<Student> getAllStudents() {
		return studentService.getAllStudents();
	}
	
	@GetMapping("/student/{id}")
	public Student getStudentById(@PathVariable Integer id) {
		return studentService.getStudentById(id);
	}
	
	@PostMapping("/student")
	public Student createStudent(@RequestBody Student student) {
		return studentService.addStudent(student);
	}
	
	@DeleteMapping("/deleteStudent/{student}")
	public Student deleteStudent(@RequestBody Student student) {
		studentService.deleteStudent(student);
		return student;
	}
	
	@DeleteMapping("/deleteById/{id}") //Need to test case for this in mockito, check how to do
	public Student deleteStudent(@PathVariable Integer id) {
		Student student = studentService.getStudentById(id);
		studentService.deleteStudentById(id);
		return student;
	}
	
	@GetMapping("/studentsByFirstAndLastName/{firstName}/{lastName}")
	public List<Student> getStudentByFirstAndLastName(@PathVariable String firstName, 
			@PathVariable String lastName) {
		return studentService.getStudentsByFirstNameAndLastName(firstName, lastName);
	}
	
	@GetMapping("/studentsByFirstOrLastName/{firstName}/{lastName}")
	public List<Student> getStudentByFirstOrLastName(@PathVariable String firstName, 
			@PathVariable String lastName) {
		return studentService.getStudentsByFirstNameOrLastName(firstName, lastName);
	}
	
	@GetMapping("/studentsByFirstName/{firstName}")
	public List<Student> getStudentsByFirstName(@PathVariable String firstName){
		return studentService.getStudentsByFirstName(firstName);
	}
	
	//This is our user defined method
	@GetMapping("/idAndEmailByFirstAndLastName/{firstName}/{lastName}")
	public List<StudentDTO> getIdAndEmailByFirstAndLastName(@PathVariable String firstName,
			@PathVariable String lastName){
		return studentService.getIdAndEmailByFirstAndLastName(firstName, lastName);
	}
	
	@GetMapping("/studentsByPage/{offset}/{limit}")
	public List<Student> getStudents(@PathVariable int offset, @PathVariable int limit) {
		return studentService.getAllStudents(offset, limit);
	}
	

}

package com.studentservice;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

/**
@Controller =>calls=> @Service =>calls=> @Repository =>This will connect to DB=> Database
@Controller : Contains Url Mapping, takes request gives response. (Url Apis mapping of that method)
@Service : This contains the business logic, handles transactions and business logic (Method implementation)
@Repository : This contains JDBC, Hibernate code and Db Operations (Method definition only).
**/

@Service
public class StudentSevice {
	
	@Autowired
	StudentRepository studentRepository;
	
	public List<Student> getAllStudents() {
		//this will get all the records from the student table and create a list of
		//student objects
		return studentRepository.findAll();
	}
	
	//Since mockito junit test was failing so this method
	//was getting some exception on running the test cases
	//so commented this and used other way to get id
	//check below method other way, which ran fine in testing
	//in mockito
	
//	public Student getStudentById(int id) {
//		return studentRepository.findById(id).get();
//	}
	
	
	public Student getStudentById(int id) {
		List<Student> students=studentRepository.findAll();
		Student student = null;
		
		for(Student stu:students) {
			if(stu.getId()==id) {
				student=stu;
			}
		}
		return student;
	}
	
	public Student addStudent(Student student) {
		return studentRepository.save(student);
	}
	
	public List<Student> getStudentsByFirstNameAndLastName(String firstName, String lastName) {
		return studentRepository.findByFirstNameAndLastName(firstName, lastName);
	}
	
	public List<Student> getStudentsByFirstNameOrLastName(String firstName, String lastName) {
		return studentRepository.findByFirstNameOrLastName(firstName, lastName);
	}
	
	public List<Student> getStudentsByFirstName(String firstName) {
		return studentRepository.findByFirstName(firstName);
	}
	
	public void deleteStudent(Student student) {
		 studentRepository.delete(student);
	}
	
	public void deleteStudentById(int id) {
		 studentRepository.deleteById(id);;
	}
	
	public List<StudentDTO> getIdAndEmailByFirstAndLastName(String firstName, String lastName) {
		List<Object[]> studentData = studentRepository.getIdAndEmailByFirstAndLastName(firstName, lastName);
		List<StudentDTO> students = new ArrayList<>();
		for(int i=0;i<studentData.size();i++) {
			Object[] studentAttributesData = studentData.get(i);
			int id = (Integer)studentAttributesData[0];
			String email = (String)studentAttributesData[1];
			StudentDTO studentDTO = new StudentDTO();
			studentDTO.setId(id);
			studentDTO.setEmail(email);
			students.add(studentDTO);
		}
		return students;
	}
	
	public List<Student> getAllStudents(int offset, int limit) {
		Pageable pageable = PageRequest.of(offset, limit);
		return studentRepository.findAll(pageable).getContent();
	}
	
	//Normal method just for testing purpoes
	public int add(int a, int b) {
		return a+ b;
	}

}

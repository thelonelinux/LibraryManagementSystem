package com.studentservice;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.repository.CrudRepository;

//No separate dependency to be use for mockito, as they are already
//present in test dependency which we get during creating of this 
//spring boot project.

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)  //this helps to run tests in order specified below
@SpringBootTest(classes= {ServiceMockitoTests.class})  //just save it, the errors will be gone
public class ServiceMockitoTests {
	
	@Mock
	StudentRepository studentRep;
	
	
	@InjectMocks
	StudentSevice studentService; //when giving error, just hover over it, and then from the resolution, scroll down and then import
	
	public List<Student> myStudentList;
	
	//Now we will test all the methods in service class
	//check all the methods, and what it is internally calling
	//you will see internally they are all using repository methods only.
	//so at the end that only we have to test here. 
	@Test
	@Order(1) //Here order will help us to run this in order, firstly this test will run
	public void test_getAllStudents() {
		//This method internally calls findAll(),
		//so to test this method is working fine or not
		//we have to test findAll() method only for this
		
		
		//let's populate dummy list, to be used by findAll(), to call this dummy list, rather than from Db
		List<Student> myStudentList = new ArrayList<Student>();
		myStudentList.add(new Student(1, "Vicky", "Prasad", "vicky@gmail.com"));
		myStudentList.add(new Student(2, "Ramesh", "Sharma", "Ramesh@gmail.com"));
		
		when(studentRep.findAll()).thenReturn(myStudentList); //Mocking : Here we have done mocking of our repo crud method findAll().
		//so now our findAll() method will return the above list rather than from DB
		
		assertEquals(2, studentService.getAllStudents().size());

	}
	
	
	@Test
	@Order(2)
	public void test_getStudentById() {
		List<Student> myStudentList = new ArrayList<Student>();
		myStudentList.add(new Student(1, "Vicky", "Prasad", "vicky@gmail.com"));
		myStudentList.add(new Student(2, "Ramesh", "Sharma", "Ramesh@gmail.com"));
		
		int studentId=1;
		
		when(studentRep.findAll()).thenReturn(myStudentList); //Mocking : Here we have done mocking of our repo crud method findAll().
		//so now our findAll() method will return the above list rather than from DB
		
		//when(studentRep.findById(studentId).get()).thenReturn(myStudentList.get(studentId)); //Mock
		//we getting mock data, so this will be there internally
		
		assertEquals(studentId, studentService.getStudentById(studentId).getId());
	}
	
	//Similar test done for get StudentByName, but they are using
	// to get findAll(), and then traversing and then only finding, 
	//like above get by id. but our methods are different.
	//we are directly using findStudentByName()
	//so check how to do this mockito test
	//Check this youtube video : https://www.youtube.com/watch?v=_2fs_qjc0RQ&list=PLUDwpEzHYYLtg-RO06RVFsauoAv241TNE&index=10&ab_channel=SDET-QA

	@Test
	@Order(3)
	public void test_addStudent() {
		Student student = new Student(1, "Vicky", "Prasad", "vicky@gmail.com");
		
		when(studentRep.save(student)).thenReturn(student);
		
		assertEquals(student, studentService.addStudent(student));
	}
	
	@Test
	@Order(4)
	public void test_deleteStudent() {
		Student student = new Student(1, "Vicky", "Prasad", "vicky@gmail.com");
		
		//Since this method is not returning anything for us.
		//so here we can't use when and then
		//Instead we will check if this method is hitting delete(studnet) repo method
		//or not. so to do that we will set time check, of when it was hit.
		studentService.deleteStudent(student);
		
		verify(studentRep, times(1)).delete(student); //This itself is mocking
		//this is used in case of void methods, which are not returning anything.
		//this will check if delete method was hit one time or not
	}
	
	//This is just simple test of adding
	@Test
	@Order(5)
	public void test_add() {
		int a=5;
		int b=6;
				
		assertEquals(11,studentService.add(a, b));
	}
	
}

package com.studentservice;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


//Running this will first start the spring boot project and then only this test will run
//which is not in case of mockito. there we not need to start spring boot project to run the tests.


@SpringBootTest
class StudentserviceApplicationTests {
	
	@Autowired
	StudentSevice studentService;

	@Test
	void test_Add() {
		int a=5;
		int b=6;
				
		assertEquals(11,studentService.add(a, b));
	}

}

package com.studentservice;

import java.util.List;

import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

//Here jpaRepository will have all the build in query methods, Student is table name, and integer is primary key data type
//This class will be called by the service class
//Here we will do method definition, implementation will be done in service class.
public interface StudentRepository extends JpaRepository<Student,Integer> {
	
	//whenever method starts with findBy, JPA Repository will query the
	//data based on properties specified after findBy name in the method
	//this will internally generate an sql query to select by first_name and last_name columns
	public List<Student> findByFirstNameAndLastName(String firstName, String lastName);
	
	//query based on firstName or Last Name
	public List<Student> findByFirstNameOrLastName(String firstName, String lastName);
	
	
	public List<Student> findByFirstName(String firstName);
	
	//this will select id and email when firstName and lastName are given
	//this is jpql/hql(hibernate query language) where this is associated with entity classnames and property name
	@Query("SELECT s.id,s.email FROM Student s where firstName=?1 and lastName=?2")
	public List<Object[]> getIdAndEmailByFirstAndLastName(String firstName, String lastName);
	
	@Query("FROM Student")
	public List<Student> findAll(Pageable pageable);

}

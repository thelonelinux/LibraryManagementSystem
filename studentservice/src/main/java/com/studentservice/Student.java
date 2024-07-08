package com.studentservice;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

// This is mapped entity by using Spring DATA JPA Dependency only.
//here is no use of sql connector dependency.
//This is all annotation of entity and table due to Spring DATA JPA, as you can see above import.
// To find the url connection of mysql db with port number  to add in settings file
//SELECT user(); 
//SELECT system_user(); // --
//SELECT @@port;
//SELECT @@hostname;//

@Entity
@Table(name="student")
public class Student {
	//the @Id indicates this property is mapped to primary key column
		@Id
		@Column(name="id")
		private int id;
		//@Column maps the property to the table column
		@Column(name="first_name")
		private String firstName;
		
		@Column(name="last_name")
		private String lastName;
		
		@Column(name="email")
		private String email;
		
		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public String getFirstName() {
			return firstName;
		}

		public void setFirstName(String firstName) {
			this.firstName = firstName;
		}

		public String getLastName() {
			return lastName;
		}

		public void setLastName(String lastName) {
			this.lastName = lastName;
		}

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}


}

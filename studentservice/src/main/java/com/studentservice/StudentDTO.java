package com.studentservice;


//This class was created to map with our data output,
//When we created the user defined function to get email and id when the first name and last name is given
//then there we will written back each row data as an StudentDTO object.
//We can't return them as Student table class only so we need this.
public class StudentDTO {
	
	private int id;
	private String email;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	
	

}

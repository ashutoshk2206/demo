package com.ashutoshk.bean;

import java.io.Serializable;

import com.ashutoshk.test.Loggable;

@Loggable
public class Person implements Serializable{

	/**
	 * 
	 */
	//private static final long serialVersionUID = 7727984215616640496L;
	//private static final long serialVersionUID = 1L;
	
	
	public String firstName;
	private String lastName;

	//private int age;
	
	private String gender;
	
	private Person() {
		// TODO Auto-generated constructor stub
	}
	
	public Person(String firstName,
			String lastName) {
		// TODO Auto-generated constructor stub
		this.firstName = firstName;
		this.lastName = lastName;
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

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

//	public int getAge() {
//		return age;
//	}
//
//	public void setAge(int age) {
//		this.age = age;
//	}
	
	
	
	
}

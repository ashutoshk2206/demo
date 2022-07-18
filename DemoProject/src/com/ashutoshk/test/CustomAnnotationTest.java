package com.ashutoshk.test;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;

import com.ashutoshk.bean.Person;

public class CustomAnnotationTest {

	public static void main(String[] args) throws NoSuchFieldException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		// TODO Auto-generated method stub
		
		Person person = new Person("ashutosh", "kumar");
		//person.setFirstName("ashutosh");
		
//		person.getClass().getField("firstName").setAccessible(true);
//		
//		System.out.println(person.getClass().getField("firstName"));
		
		if(person.getClass().isAnnotationPresent(Loggable.class)) {
			System.out.println("annotation present");
		}
		Person newPerson = null;
		for (Constructor constructor : Person.class.getDeclaredConstructors()) {
			if (constructor.getParameterCount() > 0) 
				continue;
			constructor.setAccessible(true);
			newPerson = (Person)constructor.newInstance();
			newPerson.setFirstName("Ashutosh");
		}	

		System.out.println(newPerson.getFirstName());
		//newPerson.getClass().
	}

}

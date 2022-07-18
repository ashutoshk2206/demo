package com.ashutoshk.test;

import java.util.List;
import java.util.function.Function;

import com.ashutoshk.bean.Person;
import com.ashutoshk.util.Comparator;

public class ComparatorTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Person ashutosh = new Person("ashutosh", "kumar");
		Person joey = new Person("joey", null);
		Person chandler = new Person(null, "kumar");

		Function<Person, String> getLastName = Person::getLastName;
		Function<Person, String> getFirstName = Person::getFirstName;
		
		Comparator<Person> comparator = Comparator.comparing(getLastName)
				.thenComparing(getFirstName)
				.nullsLast();
		
		//System.out.println(comparator.compare(chandler, ashutosh));
		
		//test(null);
		
		int[] arr1 = {2, 4, 6};
		int[] arr2 = fix(arr1);
		System.out.println(arr1[0]);
		System.out.println(arr2[0]);
	}
	
	static void test (Object ob) {
		System.out.println("ob");
	}
	
	static void test (List str) {
		System.out.println("list");
	}
	
	static void test (String str) {
		System.out.println("str");
	}
	
	static int[] fix(int[] arr) {
		arr[0] = 8;
		return arr;
	}

}

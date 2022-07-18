package com.ashutoshk.newtest;

import java.util.List;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		new Test().abc(null);
		
		String str1 = new String("ashutosh");
		String str2 = new String("ashutosh");
		
		System.out.println(str1 == str2);
		System.out.println(str1.equals(str2));
		System.out.println("hello world!");
	}
	
//	void abc(String str) {
//		System.out.println("String");
//	}
	
	void abc(List list) {
		System.out.println("List");
	}
	
	void abc(Object obj) {
		System.out.println("obj");
	}

}

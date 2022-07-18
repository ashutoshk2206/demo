package com.ashutoshk.util;

import java.util.function.Predicate;

public class PlayWithPredicates {

	public static void main(String[] args) {
		
		Predicate<String> p1 = s -> s.length() == 4;
		Predicate<String> p2 = s -> s.startsWith("J");
		
		//xOR - gives a true output when the number of true inputs is odd
//		Predicate<String> p3 = s -> {
//			if (p1.and(p2).test(s)) {
//				return false;
//			}
//			return p1.or(p2).test(s);
//		};
		
		Predicate<String> p3 = s -> p1.test(s) ^ p2.test(s);
		
		System.out.println(p1.test("true"));
		System.out.println(p2.test("Julia"));
		System.out.println(p3.test("June"));
		
		System.out.println(-Integer.MIN_VALUE);
	}

}

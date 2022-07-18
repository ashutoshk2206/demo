package com.ashutoshk.test;

import java.util.List;
import java.util.function.IntUnaryOperator;

public class FunctionCombinationTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		List<IntUnaryOperator> operators = List.of(
				i -> i + 1, i -> i * 2, i -> i + 3
		);
		
		IntUnaryOperator combinedOperator = operators.stream()
				.reduce(IntUnaryOperator.identity(), IntUnaryOperator::andThen);
		
		System.out.println(combinedOperator.applyAsInt(5));

	}
	
}

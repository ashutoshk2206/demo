package com.ashutoshk.newtest;

import java.util.Arrays;

public class NewTest {

	public static void main(String[] args) {

		int[] arr = {4,6,3,5,1,2,8,9};

		partition(arr, 0, arr.length-1);
		System.out.println(Arrays.toString(arr));
		
		try {
			Class.forName("com.ashutoshk.test.Test");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private static void partition(int[] arr, int start, int end) {
		
		if (start >= end)
			return;
		
		int partIndex = partitionIndex(arr, start, end);
		partition(arr, start, partIndex-1);
		partition(arr, partIndex+1, end);
		
	}

	private static int partitionIndex(int[] arr, int start, int end) {
		
		int partIndex = start;
		int pivot = arr[end];
		
		
		for (int i = start ; i< end ; i++) {
			
			if (arr[i] <= pivot) {
				swapElements(arr, i, partIndex);
				partIndex++;
			}
		}
		
		swapElements(arr, partIndex, end);
		
		return partIndex;
	}
	
	private static void swapElements(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
	

}

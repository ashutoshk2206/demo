/**
 * 
 */
package com.ashutoshk.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author ashutoshk
 *
 */
public class Test {
	
	static {
		System.out.println("Inside static");
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		System.out.println("Hello Mojave");
		
		int[] arr = {4,6,3,5,1,2,8,9};
		
		mergeSort(arr);
		System.out.println(Arrays.toString(arr));
		
		List<String> list = new ArrayList<>();
		list.add("ashutosh");
		list.add("kumar");
		modify(List.copyOf(list));
		System.out.println(list);
	}
	
	private static void modify(List<String> list) {
		list.add("ashu");
	}

	private static void mergeSort(int[] arr) {

		if (arr.length == 1)
			return;
		int l = arr.length;
		
		int[] arrL = new int[l/2];
		int[] arrR = new int[l-l/2];
		
		for (int i=0; i<l/2; i++) {
			arrL[i] = arr[i];
		}
		
		for (int i=0; i<l-l/2; i++) {
			arrR[i] = arr[l/2+i];
		}
		
		mergeSort(arrL);
		mergeSort(arrR);
		
		merge(arrL, arrR, arr);
		
	}

	private static void merge(int[] arrL, int[] arrR, int[] arr) {
		
		int i=0, j=0, k=0;
		int nL = arrL.length, rL = arrR.length;
		
		while (i<nL && j <rL) {
			if (arrL[i] < arrR[j]) {
				arr[k] = arrL[i];
				i++;
			} else {
				arr[k] = arrR[j];
				j++;
			}
			k++;
		}
		
		while (i<nL) {
			arr[k] = arrL[i];
			i++;
			k++;
		}
		
		while (j<rL) {
			arr[k] = arrR[j];
			j++;
			k++;
		}
	}

}

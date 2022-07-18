package com.ashutoshk.newtest;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class TestSet {
		
	private static TreeSet<String> subStringSet = new TreeSet<>();
    private static int subStringIndex = 0;
    
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	
		Map<String, String> map = new HashMap<>();
		//map.c
		
		//System.out.println(compute("banana"));
		String s = "abc";
		char[] charArr = s.toCharArray();
		
		System.out.println(charArr.toString());
		for (char c : charArr) {
			char x = c;
			System.out.println(x == 'a');
			x-=1;
			s=s+x;
			System.out.println(x);
		}
		
		
		System.out.println(s);

	}
    /*
     * Complete the 'compute' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts STRING s as parameter.
     */

    public static String compute(String s) {
    // Write your code here
        
        //for (String str: subStringSet) {

        //}
    	collectSubStrings(s);
    	System.out.println(subStringSet);
        return subStringSet.last();
        //return "";
    }

    private static void collectSubStrings(String s) {
        if (s.length() == subStringIndex) {
            return ;
        }
        for (int i=1; i <= s.length(); i++) {
            if (subStringIndex < i) {
                subStringSet.add(s.substring(subStringIndex, i));
                //System.out.println(subStringSet);
            }
        }
        subStringIndex++;
        collectSubStrings(s);
    }

}

package com.ashutoshk.test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

public class FlatMapTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		List<String> spanish = List.of(
				"me gusta el espanol",
				"aprendo espanol todos los dias",
				"once doce trece catorce quince",
				"a jose le gusta java",
				"abre la puerta"
				);
		
		List<String> spanishWords = spanish.stream()
			.flatMap(spanishLine -> Arrays.stream(spanishLine.split(" ")))
			.collect(Collectors.toList());
		
		//System.out.println(spanishWords);
		
		//Collectors.toMap
		Map<String, String> lineMap = spanish.stream()
			.collect(Collectors.toMap(
					line -> line.substring(0,1), 
					line -> line, 
					(line1, line2) -> line1 + System.lineSeparator() + line2));

		//System.out.println(lineMap);
		
		//Collectors.groupingBy
		Map<String, List<String>> firstLetterMap = spanish.stream()
			.collect(Collectors.groupingBy(line -> line.substring(0,1)));
		
		//System.out.println(firstLetterMap);
		
		//Collectors.groupingBy - downstream collector
		//example 1
		Map<String, Long> firstLetterCountMap = spanish.stream()
				.collect(Collectors.groupingBy(line -> line.substring(0,1),
						Collectors.counting()));
		
		//System.out.println(firstLetterCountMap);
		
		//example 2
		Map<String, List<Integer>> firstLetterToLengthMap = spanish.stream()
			.collect(Collectors.groupingBy(line -> line.substring(0,1),
				Collectors.mapping(String::length, Collectors.toList())));
		
		//System.out.println(firstLetterToLengthMap);
		
		//exercise
		Map<String, Set<String>> firstLetterToFirstWordMap = spanish.stream()
				.collect(Collectors.groupingBy(line -> line.substring(0, 1), 
						Collectors.mapping(line -> line.split(" ")[0], Collectors.toSet())));
		
		//System.out.println(firstLetterToFirstWordMap);
		
		//frequency of letters
		Map<String, Long> letterCountMap = spanish.stream() //stream of lines
			.flatMap(line -> expand(line).stream()) // stream of letters
			//.filter(letter -> !letter.equals(" ")) // filter space 
			.collect(Collectors.groupingBy(letter -> letter,
					Collectors.counting()));

		//System.out.println(letterCountMap);
		
		//max occurring word
		Map<String, Long> wordCountMap = spanish.stream()
				.flatMap(line -> Arrays.stream(line.split(" ")))
				.collect(Collectors.groupingBy(word -> word, Collectors.counting()));
						
		System.out.println(wordCountMap);
		
		//fetches only one of the max occurring words
		Entry<String, Long> word = wordCountMap.entrySet().stream()
			.max(Entry.comparingByValue())
			.orElseThrow();
		
		System.out.println(word);
		
		//fetch all the max occurring words
		Map<Long, List<String>> countToWordsMap = wordCountMap.entrySet().stream()
			.collect(Collectors.groupingBy(Entry::getValue,
					Collectors.mapping(Entry::getKey, Collectors.toList())));
		
		System.out.println(countToWordsMap);
		
		Map.Entry<Long, List<String>> mostFrequentwords = countToWordsMap.entrySet().stream()
			.max(Entry.comparingByKey())
			.orElseThrow();
		
		System.out.println(mostFrequentwords);
		
	}
	
	
	static List<String> expand(String s) {
		return s.codePoints()
				.mapToObj(Character::toString)
				.collect(Collectors.toList());
	}

}

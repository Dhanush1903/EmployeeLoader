package com.lcode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Stream;

public class JEightFeatures {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println(
				"Given a list of integers, find out all the even numbers that exist in the list using Stream functions?");
		List<Integer> list = Arrays.asList(10, 15, 8, 49, 25, 98, 32);
		list.stream().filter(n -> n % 2 == 0).forEach(n -> System.out.println(n));

		System.out
				.println("Given a list of integers, find out all the numbers starting with 1 using Stream functions?");
		list.stream().map(n -> n + " ").filter(s -> s.startsWith("1")).forEach(n -> System.out.println(n));

		System.out.println("How to find duplicate elements in a given integers list in java using Stream functions?");
		List<Integer> myList = Arrays.asList(10, 15, 8, 49, 25, 98, 98, 32, 15);
		Set<Integer> set = new HashSet<>();
		myList.stream().filter(n -> !set.add(n)).forEach(s -> System.out.println(s));

		System.out.println("Given the list of integers, find the first element of the list using Stream functions?");
		list.stream().findFirst().ifPresent(System.out::println);

		System.out.println(
				" Given a list of integers, find the total number of elements present in the list using Stream functions?");
		Integer number = (int) list.stream().count();
		System.out.println(number);
		
		System.out.println("Given a list of integers, find the maximum value element present in it using Stream functions?");
		int max=list.stream().max(Integer::compare).get();
		System.out.println(max);
		System.out.println("or");
		Integer ma = Stream.of(1, 2, 3, 4, 5, 6,7)
                .max(Comparator.comparing(Integer::valueOf))
                .get();	
	
	}

}

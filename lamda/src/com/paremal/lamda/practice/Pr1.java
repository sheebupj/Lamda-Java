package com.paremal.lamda.practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Pr1 {

	static public  void   main(String[] args) {
		List<Integer> n1 = Arrays.asList(1, 2, 3,4);
		List<Integer> n2 = Arrays.asList(3, 4,5);
		/* skiping elements*/
		n1.stream().skip(1).forEach(System.out::println);
		/* sorting*/
		n1.stream().sorted(Comparator.reverseOrder()).forEach(System.out::println);
		/* combinations*/
		List<int[]> combinations = n1.stream()
				.flatMap(i -> n2.stream().
						filter(j -> (i + j) % 2 == 0)
						.map(j -> new int[] { i, j }))
						.collect(Collectors.toList());
		for (int[] i : combinations) {
			System.out.println(i[0] + "," + i[1]);
		}
		List<String> words = Arrays.asList("Hello", "world", "warm", "where", "weard","hero", "hectic","horific");
		System.out.println("------");
		words.stream().filter(w-> w.startsWith("h")).forEach(System.out::println);
		System.out.println("------");
		
		/*sorting*/
		words.stream().sorted(Comparator.reverseOrder()).forEach(System.out::println);

		/* avoiding duplicate charachors*/
		List<String> uChars = words.stream()
					.map(w -> w.split(""))
					.flatMap(Arrays::stream)
					.distinct()
					.collect(Collectors.toList());
		uChars.forEach(System.out::println);
	/* sum using reduce */
		Optional<Integer> sum=n1.stream().reduce(Integer::sum);
	
		int sum1= n1.stream().reduce(0, (x,y)->x+y);
		
		List<Integer> list1 = Arrays.asList(1,2,3);
		List<Integer> list2 = Arrays.asList(4,5,6);
		List<Integer> list3 = Arrays.asList(7,8,9);
		 
		List<List<Integer>> listOfLists = Arrays.asList(list1, list2, list3);
		 
		List<Integer> listOfAllIntegers = listOfLists.stream()
		                            .flatMap(x -> x.stream())
		                            .collect(Collectors.toList());
		 
		System.out.println(listOfAllIntegers);    //[1, 2, 3, 4, 5, 6, 7, 8, 9]
		

		
		

	}
																																														
}

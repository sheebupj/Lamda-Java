package com.paremal.lamda.operations;


import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class IntStreamOperations {
	
	
	public static void main(String[] args) {
		
		int [] values= {11,7,9,3,6,4,10,5,2,8,1};
		
		System.out.println("Original values");
		IntStream.of(values).sorted().forEach(value->System.out.printf("%d%n",value));
		
		
		System.out.printf("Count: %d%n",IntStream.of(values).count());
		System.out.printf("sum: %d%n",IntStream.of(values).sum());
		System.out.printf("Minimum: %d%n",IntStream.of(values).min().getAsInt());
		System.out.printf("Maximum: %d%n",IntStream.of(values).max().getAsInt());
		System.out.printf("Average: %.3f%n",IntStream.of(values).average().getAsDouble());
		IntStream.of(values).filter(value-> value % 3 ==0).sorted().forEach(value->System.out.printf("%d%n",value));
		//System.out.println("Sorted values: %s%n",Arrays.stream(values).filter(value-> value>4).collect(Collectors.toList()));
		List<Integer> valuesCollection= IntStream.of(values).boxed().collect(Collectors.toList());
		valuesCollection.forEach(value->System.out.printf("%n%d", value));
		valuesCollection.sort(Comparator.naturalOrder());
		int[] sorted=IntStream.of(values).sorted().toArray();
		System.out.println("Second smallest :"+ sorted[1]+" :"+valuesCollection.get(1));
		valuesCollection.forEach(value->System.out.printf("%n%d", value));
		
		
		System.out.printf("Orignial values: %s%n" , Arrays.stream(values));
		
//		System.out.printf("Orignial values: %s%n" , Arrays.stream(values)
//			.sorted().collect(Collectors.toList()));
		
		
		
		
		
		String[] strings= {"red","orange","green","blue","indigo","Vialet","Yellow","pink"};
		
		System.out.printf("Original Strings: %s%n",Arrays.asList(strings));
		
		
		
		System.out.printf(" Strings in upper case: %s%n",
									Arrays.stream(strings)
									.map(String::toUpperCase)
									.collect(Collectors.toList()));
		System.out.printf(" Strings in upper case sorted: %s%n",
				Arrays.stream(strings)
				.map(String::toUpperCase)
				.sorted()
				.collect(Collectors.toList()));
		System.out.printf(" Strings greater than p sorted ascending: %s%n",
				Arrays.stream(strings)
				.filter(s-> s.compareToIgnoreCase("p")>0)
				.sorted()
				.collect(Collectors.toList()));
		System.out.printf(" Strings greater than p sorted ascending: %s%n",
				Arrays.stream(strings)
				
				.sorted(String.CASE_INSENSITIVE_ORDER)
				.collect(Collectors.toList()));
	}

}

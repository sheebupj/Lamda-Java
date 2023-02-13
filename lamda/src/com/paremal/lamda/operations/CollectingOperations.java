package com.paremal.lamda.operations;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import com.paremal.lamda.util.Utils;

public class CollectingOperations {
	
	static List<Transaction> transactions= Utils.getTransactions();
	static List<Transaction> nulltrans= Utils.getnullTransactions();
	
	public static void main(String[] args) {
		
		
		
		/*
		 * grouping operations with  Collectors with iteration of map
		 */
		Map<String,List<Transaction>> transactionsByCurrencies=transactions.stream()
				.collect(Collectors.groupingBy(Transaction::getCurrency));
		System.out.println("iterating map");
			transactionsByCurrencies.entrySet().stream().map(m-> m.getValue()).forEach(t-> t.forEach(System.out::println));
		System.out.println("iterating map completed");
		
		/*
		 * grouping with collectors
		 */
		Map<Trader,List<Transaction>> transactionsMapedtoTraders=transactions.stream()
				.collect(Collectors.groupingBy(Transaction::getTrader));
		System.out.println("iterating map1");
		transactionsMapedtoTraders.entrySet().stream().map(m-> m.getValue()).forEach(t->t.forEach(System.out::println));
		System.out.println("iterating map1 completed");
		
		/*
		 * Grouping with multple colloctors
		 */
		
		Map<Trader,Transaction> higherTransactions=transactions.stream().collect(Collectors.groupingBy(Transaction::getTrader,
				Collectors.collectingAndThen(Collectors.maxBy(Comparator.comparingInt(Transaction::getValue)), Optional::get)));
		System.out.println("iterating map2");
		higherTransactions.entrySet().stream().map(m->m.getValue()).forEach(System.out::println);;
		System.out.println("iterating map2 completed");
		
		/*
		 * Grouping and collect to Map object
		 */
		
		Map<Trader,Integer> sumOfTransactionsGroupByTrader=transactions.stream()
				.collect(Collectors.groupingBy(Transaction::getTrader,Collectors.summingInt(Transaction::getValue)));
		sumOfTransactionsGroupByTrader.forEach((trader,sumOfValues)-> System.out.printf("#%s Total transaction amount:%d%n", trader,sumOfValues));
		
		
		/*
		 * counting using Stream.cout()
		 */
		
		Long numberOfTransactions=transactions.stream().count();
		
		System.out.println("Transaction count is :"+numberOfTransactions);
		
		/*
		 * counting using collect and Collectors
		 */
		
		 numberOfTransactions=transactions.stream().collect(Collectors.counting());
		 
		/*
		 * find max valued transactions using comparator and collect
		 */
		 
		 Optional<Transaction> higehestTransactions=transactions.stream().collect(Collectors.maxBy(Comparator.comparing(Transaction::getValue)));
	
		 System.out.println("Transtions with highest amount is:"+higehestTransactions.get());
		 
		 /*
		  * find sum using Collectors and summingInt method
		  */
		 System.out.println("Total amount of transactions:"+transactions.stream().collect(Collectors.summingInt(Transaction::getValue)));
		 
		 /*
		  * get summary of statics of values in stream using Collectors.summarizingInt
		  */
		 System.out.println("Summary of transactions:"+transactions.stream().collect(Collectors.summarizingInt(Transaction::getValue)));
		 
		 /*
		  * Concatenate strings in the stream using Collectors.joining()
		  */
		System.out.println(transactions.stream().map(t-> t.getTrader().getName()).collect(Collectors.joining(" ")));
		 
		
		/*
		 * calculating sum with Collectors.reducing
		 */
		System.out.println("Sum of transactions :"+transactions.stream().collect(Collectors.reducing(0,Transaction::getValue,(i,j)-> i+j)));
		
		/*
		 * finding highest using  Collectors.reducing
		 */
		System.out.println("Highest transactions :"+transactions.stream().collect(Collectors.reducing((t1,t2)->t1.getValue()>t2.getValue()? t1:t2)));
		
		/*
		 * finding Lowest using  Collectors.reducing
		 */
		System.out.println("Lowest transactions :"+transactions.stream().collect(Collectors.reducing((t1,t2)-> t1.getValue()<t2.getValue()?t1:t2)));
		
	}

}

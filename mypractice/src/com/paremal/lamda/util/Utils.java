package com.paremal.lamda.util;

import java.util.Arrays;
import java.util.List;

import com.paremal.lamda.operations.Employee;
import com.paremal.lamda.operations.Trader;
import com.paremal.lamda.operations.Transaction;

public class Utils {
	static List<Transaction> transactions = null;
	static List<String> phones=Arrays.asList(new String[] {"9387690660","9188584218"});
	
	static Employee[] employees= {new Employee("Jason", "Red", 5000, "IT",phones), new Employee("Ashly", "Green", 7600, "IT",phones),
			new Employee("Mathew", "Indigo", 3587.5, "Sales",phones),
			new Employee("James", "Indigo", 4700.77, "Marketing",phones), new Employee("Luke", "Indigo", 6200, "IT",phones),
			new Employee("Jason", "Blue", 3200, "Sales",phones), new Employee("Jason", "Blue", 3200, "finance",phones),
			new Employee("Wendy", "Brown", 4236.4, "Marketing",phones),new Employee("Wendy", "Brown", 4236.4, "Marketing",phones)};

	static {
		Trader raoul = new Trader("Raoul", "Cambridge");
		Trader mario = new Trader("Mario", "Milan");
		Trader Sheenoj = new Trader("Sheenoj", "bangalore");
		Trader alan = new Trader("Alan", "Cambridge");
		Trader brian = new Trader("Brian", "Cambridge");
		Trader sheebu = new Trader("sheebu", "bangalore");
		

		transactions = Arrays.asList(new Transaction(brian, 2011, 300, "$"), new Transaction(raoul, 2012, 1000, "$"),
				new Transaction(raoul, 2011, 400, "$"), new Transaction(mario, 2012, 710, "$"),
				new Transaction(mario, 2012, 700, "$"), new Transaction(alan, 2012, 950, "$"),
				new Transaction(sheebu, 2022, 1800, "INR"), new Transaction(Sheenoj, 2022, 950, "INR"));
		
		

	}

	public static List<Transaction> getTransactions() {
		return transactions;

	}
	public static List<Transaction> getnullTransactions() {
		return null;

	}
	public static Employee[] getEmployees() {
		return employees;
	}
	
	
	
}

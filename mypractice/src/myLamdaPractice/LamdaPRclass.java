package myLamdaPractice;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.paremal.lamda.operations.Transaction;
import com.paremal.lamda.util.Utils;

public class LamdaPRclass {
	static List<Transaction> transactions= Utils.getTransactions();
	public static void main(String[] args) {
		//converting list to map
		Map<String,List<Transaction>> currencyTransactions=transactions.stream()
				.collect(Collectors.groupingBy(Transaction::getCurrency));
		//currencyTransactions.entrySet().stream().map(m-> m.getValue()).forEach(t->t.forEach(System.out::println));
		
		//iterate, filter, and print map values
		currencyTransactions.entrySet().stream().map(m-> m.getValue()).
		forEach(t->t.stream().filter(t1->t1.getYear()==2012).forEach(System.out::println));
		System.out.println("....................................................");
		currencyTransactions.entrySet().stream().map(tv->tv.getValue()).forEach(t-> t.stream().forEach(System.out::println));
		//iterate, filter, and print map keys
		currencyTransactions.entrySet().stream().map(m->m.getKey()).forEach(System.out::println);
	}
	

}

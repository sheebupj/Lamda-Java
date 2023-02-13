package com.paremal.lamda.operations.comparator;

import java.util.Comparator;

import com.paremal.lamda.operations.Employee;

public class EmployeeComparator implements Comparator<Employee> {

	@Override
	public int compare(Employee o1, Employee o2) {
		// TODO Auto-generated method stub
		if(o1.getLastName().equals(o2.getLastName())) {
			return  o1.getSalary().compareTo(o2.getSalary());
		}
		return o1.getLastName().compareTo(o2.getLastName());
	}

	

	

}

package com.maven.employee;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class TestEmployee {
	public static void main(String[] args) throws DataAccessException, SQLException {
		EmployeeDao empDao = new EmployeeDao();
//		List<Employee> list = empDao.fetchAll();
//		for(Employee emp : list) {
//			System.out.println(emp.getEmpNo() + "\t\t");
//			System.out.println(emp.getName() + "\t\t");
//			System.out.println(emp.getSalary() + "\t\t");
//		}
		Employee emp = new Employee();
		
		Scanner input = new Scanner(System.in);
		System.out.println("Enter the name, salary and employee id: ");
		String name = input.next();
		String salary = input.next();
		int empno = input.nextInt();
		
		emp.setName(name);
		emp.setSalary(salary);
		emp.setEmpNo(empno);
		
		
	
		try {
			empDao.add(emp);
		}catch(DataAccessException e) {
			e.printStackTrace();
		}
	}
}

package com.masai.usecases;

import java.util.Scanner;

import com.masai.dao.EmployeeDao;
import com.masai.dao.EmployeeDaoImpl;
import com.masai.exception.EmployeeException;
import com.masai.main.EmployeeOption;

public class EmployeeLogIn {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter your email : ");
		String email=sc.next();
		System.out.println("Enter your password : ");
		String password=sc.next();
//		sc.close();
		EmployeeDao dao=new EmployeeDaoImpl();
		try {
			String msg=dao.employeelogIn(email, password);
			System.out.println(msg);
			EmployeeOption.main(args);
		} catch (EmployeeException e) {
			
			e.printStackTrace();
		}
		


	}

}

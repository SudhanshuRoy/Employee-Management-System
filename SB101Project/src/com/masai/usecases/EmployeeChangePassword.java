package com.masai.usecases;

import java.util.Scanner;

import com.masai.dao.EmployeeDao;
import com.masai.dao.EmployeeDaoImpl;
import com.masai.exception.EmployeeException;


public class EmployeeChangePassword {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter email : ");
		String email=sc.next();
		System.out.println("Enter password : ");
		String password=sc.next();
		EmployeeDao dao=new EmployeeDaoImpl();
		try {
			String msg=  dao.employeeChangePassword(email, password);
			System.out.println(msg);
		} catch (EmployeeException e) {
			
			e.printStackTrace();
		}	


	}

}

package com.masai.usecases;

import java.util.Scanner;

import com.masai.dao.HODDaoImpl;
import com.masai.exception.HODException;
import com.masai.main.HODOption;

public class HODLogIn {

	public static void main(String[] args) {
		
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter username : ");
		String username=sc.next();
		System.out.println("Enter password : ");
		String password=sc.next();
//		sc.close();
		HODDaoImpl dao=new HODDaoImpl();
		
		try {
			String msg=dao.logInHOD(username, password);
			System.out.println(msg);
		  HODOption.main(args);
			
		} catch (HODException e) {
			
			e.printStackTrace();
		}

	}

}

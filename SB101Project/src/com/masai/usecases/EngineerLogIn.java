package com.masai.usecases;

import com.masai.dao.EngineerDao;
import com.masai.dao.EngineerDaoImpl;
import com.masai.exception.EngineerException;
import com.masai.main.EngineerOption;

import java.util.Scanner;

public class EngineerLogIn {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter your email : ");
		String engemail=sc.next();
		System.out.println("Enter your password : ");
		String engpassword=sc.next();
//		sc.close();
		EngineerDao dao=new EngineerDaoImpl();
		try {
			String msg=dao.engineerLogIn(engemail, engpassword);
			System.out.println(msg);
			EngineerOption.main(args);
		} catch (EngineerException e) {
			
			e.printStackTrace();
		}
		

	}

}

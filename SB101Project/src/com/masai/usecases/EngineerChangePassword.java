package com.masai.usecases;
import java.util.Scanner;

import com.masai.dao.EngineerDao;
import com.masai.dao.EngineerDaoImpl;
import com.masai.exception.EngineerException;


public class EngineerChangePassword {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter email : ");
		String email=sc.next();
		System.out.println("Enter password : ");
		String password=sc.next();
//		sc.close();
		EngineerDao dao=new EngineerDaoImpl();
		try {
			String msg=  dao.changePassword(email, password);
			System.out.println(msg);
		} catch (EngineerException e) {
			
			e.printStackTrace();
		}	

	}

}

package com.masai.usecases;

import java.util.Scanner;

import com.masai.dao.HODDao;
import com.masai.dao.HODDaoImpl;
import com.masai.model.Engineer;

public class RegisterEngineer {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		
		System.out.println("Engineer Registration :-");
		
		System.out.println("Enter name: ");
		String name=sc.nextLine();
		
		System.out.println("Enter email: ");
		String email=sc.next();
		
		System.out.println("Enter password: ");
		String password=sc.next();
		
		System.out.println("Enter category(Hardware/Software) : ");
		String category=sc.next();
//		sc.close();
		HODDao dao=new HODDaoImpl();
		
		Engineer eng=new Engineer();
		
		eng.setEngname(name);
		eng.setEngemail(email);
		eng.setEngpassword(password);
		eng.setCategory(category);
		
		String msg=dao.registerEngineer(eng);
		System.out.println(msg);

	}

}

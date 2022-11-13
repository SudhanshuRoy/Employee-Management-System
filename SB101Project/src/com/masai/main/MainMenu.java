package com.masai.main;

import java.util.Scanner;

import com.masai.usecases.EmployeeLogIn;
import com.masai.usecases.EngineerLogIn;
import com.masai.usecases.HODLogIn;
import com.masai.usecases.RegisterEmployee;

public class MainMenu {

	public static void main(String[] args) {
		System.out.println("==============================================");
		System.out.println("  Online Hardware And Software Support System");
		System.out.println("===============================================");
		
		System.out.println("Select Option to Continue....");
		System.out.println("1.HOD Login\r\n"
				+ "2.Engineer Login\r\n"
				+ "3.Employee Login\r\n"
				+ "4.New Employee Registration\r\n"
				+ "5.Exit");
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter option : ");
		int choice=sc.nextInt();
		switch(choice) {
		case 1:
			System.out.println("Welcome HOd!!");
			HODLogIn.main(args);
			break;
		case 2:
			System.out.println("Welcome Engineers !!");
			EngineerLogIn.main(args);
			break;
		case 3:
			System.out.println("Welcome Employee");
			EmployeeLogIn.main(args);
			break;
		case 4:
			System.out.println("New Employee Registration");
			RegisterEmployee.main(args);
		case 5 :
			System.out.println(".........Thank You ! ...");
			break;
		default : 
			System.out.println("Invalid Input");
		
					
		}
		

	}

}

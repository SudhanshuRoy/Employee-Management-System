package com.masai.main;

import java.util.Scanner;

import com.masai.usecases.EmployeeChangePassword;
import com.masai.usecases.EmployeeGetAllComplaintRaisedByHim;
import com.masai.usecases.EmployeeRegisterComplaint;

public class EmployeeOption {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		
		
		while(true) {
		System.out.println("Select Options to Continue");
		System.out.println("1.Register new Complaint");
		System.out.println("2.Check Your Complaints");
		System.out.println("3.Change Password");
		System.out.println("4.Back to MainMenu");
		System.out.println("5. LogOut");
		
		
		System.out.println("Enter Option");
		int choice=sc.nextInt();
		
		if(choice==5) {
			System.out.println("********Thank You*********");	
			break;
		}
		

		switch(choice) {
		case 1:
			EmployeeRegisterComplaint.main(args);
			break;
		case 2:
			EmployeeGetAllComplaintRaisedByHim.main(args);
			break;
		case 3:
			EmployeeChangePassword.main(args);
			break;
		case 4: 
			System.out.println("Back to main menue");	
			MainMenu.main(args);
			break;
		case 5:
			System.out.println("*****Thank You******");
			break;
			default:
				System.out.println("Invalid Input");
		}
	  }

	}

}

package com.masai.main;

import java.util.Scanner;

import com.masai.usecases.EngineerChangePassword;
import com.masai.usecases.GetAllProblems;
import com.masai.usecases.UpdateComplaintStatus;

public class EngineerOption {

	public static void main(String[] args) {
		
		Scanner sc=new Scanner(System.in);
		
		while(true) {

		System.out.println("Select Options to Continue");
		System.out.println("1.Check Assigned Complaint");
		System.out.println("2.Update Assign Complaint");
		System.out.println("3.Change Password");
		System.out.println("4.Back to MainMenu");
		System.out.println("5. LogOut");
		
		System.out.println("Enter Option: ");
		int choice=sc.nextInt();
		
		if(choice==5) {
			System.out.println("********Thank You*********");	
			break;
		}
		
		switch(choice) {
		case 1:
			GetAllProblems.main(args);
			break;
		case 2:
			UpdateComplaintStatus.main(args);
			break;
		case 3:
			EngineerChangePassword.main(args);
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

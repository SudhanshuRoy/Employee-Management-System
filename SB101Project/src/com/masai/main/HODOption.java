package com.masai.main;

import java.util.Scanner;

import com.masai.usecases.AssignProblemToEngineer;
import com.masai.usecases.DeleteEngineer;
import com.masai.usecases.GetAllComplaints;
import com.masai.usecases.GetAllEngineersDetail;
import com.masai.usecases.HODLogIn;
import com.masai.usecases.RegisterEngineer;

public class HODOption {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);	
		
		while(true) {
			
		System.out.println("Select Options to Continue");
		System.out.println("1.Register New Engineer");
		System.out.println("2.See List of All Engineer");
		System.out.println("3.Delete Engineer");
		System.out.println("4.See All Complaints");
		System.out.println("5.Assign Complaint to Engineer");
		System.out.println("6.Back to MainMenu");
		System.out.println("7. LogOut");
		
       System.out.println("Enter Options : ");
		int choice = sc.nextInt();
		
		if(choice==7) {
			System.out.println("********Thank You*********");	
			break;
		}
		
		switch(choice) {
		case 1:
			RegisterEngineer.main(args);
			break;
		case 2:
			GetAllEngineersDetail.main(args);
			break;
		case 3:
			DeleteEngineer.main(args);
			break;
		case 4:
			GetAllComplaints.main(args);
			break;
		case 5: 
			AssignProblemToEngineer.main(args);
			break;
			
		case 6: 
			System.out.println("Back to main menue");	
			MainMenu.main(args);
			break;
		case 7:
			System.out.println("*****Thank You******");
			break;
		default:
			System.out.println("Invalid Input");
		}
		}

	}

}

package com.masai.usecases;

import java.util.Scanner;

import com.masai.dao.HODDao;
import com.masai.dao.HODDaoImpl;
import com.masai.model.Complaint;

public class EmployeeRegisterComplaint {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter engineer id : ");
		int engid=sc.nextInt();
		System.out.println("Enter employee id : ");
		int empid=sc.nextInt();
		System.out.println("Enter category(Hardware/Software) : ");
		String category=sc.next();
		System.out.println("Enter status : ");
		String status=sc.next();
		
		Complaint complaint=new Complaint();
		complaint.setCategory(category);
		complaint.setEngid(engid);
		complaint.setEmpid(empid);
		complaint.setStatus(status)
		;
		HODDao dao=new HODDaoImpl();
		String msg=dao.assignProblemToEngineer(complaint);
		System.out.println(msg);
		

	}

}

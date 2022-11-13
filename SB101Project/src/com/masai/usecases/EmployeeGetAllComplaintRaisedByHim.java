package com.masai.usecases;

import java.util.List;
import java.util.Scanner;

import com.masai.dao.EngineerDao;
import com.masai.dao.EngineerDaoImpl;
import com.masai.exception.ComplaintException;
import com.masai.model.Complaint;

public class EmployeeGetAllComplaintRaisedByHim {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter your empid : ");
		int empid=sc.nextInt();
		EngineerDao dao=new EngineerDaoImpl();
		try {
			List<Complaint> complaints=dao.getAllProblems(empid);
			complaints.forEach(c->System.out.println(c));
		} catch (ComplaintException e) {
			
			e.printStackTrace();
			
		}

	}

}

package com.masai.usecases;
import java.util.Scanner;

import com.masai.dao.EngineerDao;
import com.masai.dao.EngineerDaoImpl;
import com.masai.exception.ComplaintException;

public class UpdateComplaintStatus {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter complaint id : ");
		int compid=sc.nextInt();
		System.out.println("Enter message to update status : ");
		String status=sc.next();
//		sc.close();
		EngineerDao dao=new EngineerDaoImpl();
		try {
			String msg=dao.updateComplaintStatus(compid, status);
			System.out.println(msg);
		} catch (ComplaintException e) {
			
			e.printStackTrace();
		}
		

	}

}

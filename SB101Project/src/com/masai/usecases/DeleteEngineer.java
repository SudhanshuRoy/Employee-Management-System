package com.masai.usecases;

import java.util.Scanner;

import com.masai.dao.HODDao;
import com.masai.dao.HODDaoImpl;
import com.masai.exception.EngineerException;

public class DeleteEngineer {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter engineer id to delete engineer : ");
		int engid=sc.nextInt();
		HODDao dao=new HODDaoImpl();
		try {
			String msg=dao.deleteEngineer(engid);
			System.out.println(msg);
		} catch (EngineerException e) {
			
			e.printStackTrace();
		}

	}

}

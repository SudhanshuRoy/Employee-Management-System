package com.masai.usecases;
import java.util.Scanner;
import com.masai.dao.EmployeeDao;
import com.masai.dao.EmployeeDaoImpl;
import com.masai.exception.EmployeeException;
import com.masai.model.Employee;


public class RegisterEmployee {

	public static void main(String[] args) {
Scanner sc=new Scanner(System.in);
		
		System.out.println("Employee Registration :-");
		
		System.out.println("Enter name: ");
		String name=sc.nextLine();
		
		System.out.println("Enter email: ");
		String email=sc.next();
		
		System.out.println("Enter password: ");
		String password=sc.next();
		
//		sc.close();
		
		EmployeeDao dao=new EmployeeDaoImpl();
		Employee emp =new Employee();
		
		
		emp.setEmpname(name);
		emp.setEmpemail(email);
		emp.setEmppassword(password);
	
		
		String msg;
		try {
			msg = dao.employeeRegistration(emp);
			System.out.println(msg);
			
		} catch (EmployeeException e) {
			
			e.printStackTrace();
		}
		

	}

}

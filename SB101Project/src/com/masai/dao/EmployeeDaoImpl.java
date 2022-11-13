package com.masai.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.masai.exception.ComplaintException;
import com.masai.exception.EmployeeException;
import com.masai.model.Complaint;
import com.masai.model.Employee;
import com.masai.utility.DBUtil;

public class EmployeeDaoImpl implements EmployeeDao{

	@Override
	public String employeeRegistration(Employee employee) throws EmployeeException {
		String msg="Not registered";
		
		try(Connection conn=DBUtil.provideConnection()){
			PreparedStatement ps=conn.prepareStatement("insert into Employee(empname,empemail,emppassword) values(?,?,?)");
			ps.setString(1, employee.getEmpname());
			ps.setString(2, employee.getEmpemail());
			ps.setString(3, employee.getEmppassword());
						
			int x=  ps.executeUpdate();
			if(x>0) 
			msg=(x+" Employee registered");
			else throw new EmployeeException("Registration Failed !");
			
		} catch (SQLException e) {
			
			e.printStackTrace();
			throw new EmployeeException(e.getMessage());
		}
		
		return msg;
	}

	@Override
	public String employeelogIn(String email, String password) throws EmployeeException {
       String msg="Invalid Credentials";
		
		try(Connection conn=DBUtil.provideConnection()){
			
		PreparedStatement ps =	conn.prepareStatement("select * from Employee where empemail=? AND emppassword=?");
		ps.setString(1, email);
		ps.setString(2, password);
		ResultSet rs=ps.executeQuery();
		if(rs.next()) {
			String name=rs.getString("empname");
		msg="Welcome "+name;
		}
		else throw new EmployeeException("Wrong Credentials");
			
		} catch (SQLException e) {
			
			e.printStackTrace();
			throw new EmployeeException(e.getMessage());
		}
		
		return msg;
	}

	@Override
	public String employeeRegisterComplaint(Complaint complaint) throws ComplaintException {
		String msg="Complaint not registered..";
		try(Connection conn=DBUtil.provideConnection()){
		PreparedStatement ps=	conn.prepareStatement("insert into complaint(engid,empid,category,status) values(?,?,?,?) ");
		ps.setInt(1, complaint.getEngid());
		ps.setInt(2, complaint.getEmpid());
		ps.setString(3, complaint.getCategory());
		ps.setString(4, complaint.getStatus());
		int x=ps.executeUpdate();
		if(x>0) {
			msg=x+" complaint registered...";
		}
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return msg;
	}

	@Override
	public List<Complaint> employeeGetAllComplaintRaisedByHim(int empid) throws ComplaintException {
		
        List<Complaint> complaints=new ArrayList<>();
		
		
		try(Connection conn=DBUtil.provideConnection()){
			
		PreparedStatement ps =	conn.prepareStatement("SELECT * FROM Complaint where empid=?");
		ps.setInt(1, empid);
		ResultSet rs=ps.executeQuery();
		
		while(rs.next()) {
			int compid=rs.getInt("compid");
			String category=rs.getString("category");
			String status=rs.getString("status");
//			int eid=rs.getInt("empid");
			int engid=rs.getInt("engid");
			Complaint complaint =new Complaint(compid,category,status,empid,engid);
			complaints.add(complaint);
		}
		
		if(complaints.size()==0) {
			throw new ComplaintException("No complaint assigned with employee id :  "+empid);
		}
			
		} catch (SQLException e) {
			
			e.printStackTrace();
			throw new ComplaintException(e.getMessage());
		}
		
		return complaints;
	}

	@Override
	public String employeeChangePassword(String email, String password) throws EmployeeException {
		
		String msg="Invalid email : ";
		try(Connection conn=DBUtil.provideConnection()){
		PreparedStatement ps =	conn.prepareStatement("update employee set emppassword=? where empemail=?");
			ps.setString(1, password);
			ps.setString(2, email);
			int x=ps.executeUpdate();
			if(x>0) msg="Password changed!";
			else throw new EmployeeException("Invalid email");
		} catch (SQLException e) {
			
			e.printStackTrace();
			throw new EmployeeException(e.getMessage());
		}
		
		return msg;
	}

	
}

package com.masai.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.masai.exception.ComplaintException;
import com.masai.exception.EngineerException;
import com.masai.model.Complaint;
import com.masai.utility.DBUtil;

public class EngineerDaoImpl implements EngineerDao{

	@Override
	public String engineerLogIn(String engemail, String engpassword) throws EngineerException{
		String msg="Invalid Credentials";
		
		try(Connection conn=DBUtil.provideConnection()){
			
		PreparedStatement ps =	conn.prepareStatement("select * from Engineer where engemail=? AND engpassword=?");
		ps.setString(1, engemail);
		ps.setString(2, engpassword);
		ResultSet rs=ps.executeQuery();
		if(rs.next()) {
			String name=rs.getString("engname");
		msg="Welcome "+name;
		}
		else throw new EngineerException("Wrong Credentials");
			
		} catch (SQLException e) {
			
			e.printStackTrace();
			throw new EngineerException(e.getMessage());
		}
		
		return msg;
	}

	@Override
	public List<Complaint> getAllProblems(int engid) throws EngineerException {
		List<Complaint> complaints=new ArrayList<>();
		
		
		try(Connection conn=DBUtil.provideConnection()){
			
		PreparedStatement ps =	conn.prepareStatement("SELECT * FROM Complaint where engid=?");
		ps.setInt(1, engid);
		ResultSet rs=ps.executeQuery();
		
		while(rs.next()) {
			int compid=rs.getInt("compid");
			String category=rs.getString("category");
			String status=rs.getString("status");
			int empid=rs.getInt("empid");
			int eid=rs.getInt("engid");
			Complaint complaint =new Complaint(compid,category,status,empid,engid);
			complaints.add(complaint);
		}
		
		if(complaints.size()==0) {
			throw new EngineerException("No complaint assigned with engineer id :  "+engid);
		}
			
		} catch (SQLException e) {
			
			e.printStackTrace();
			throw new EngineerException(e.getMessage());
		}
		
		return complaints;
	}

	@Override
	public String updateComplaintStatus(int compid, String status) throws ComplaintException {
		String msg="Status not updated";
		try(Connection conn=DBUtil.provideConnection()){
			
		PreparedStatement ps=conn.prepareStatement("update complaint set status=? where compid=?");
		ps.setInt(2, compid);
		ps.setString(1, status);
		int x=ps.executeUpdate();
		if(x>0) msg="Status get updated";
		else throw new ComplaintException("Invalid complaint id : "+compid);
			
		} catch (SQLException e) {
			
			e.printStackTrace();
			throw new ComplaintException(e.getMessage());
		}
		return msg;
	}

	@Override
	public String changePassword(String email, String password) throws EngineerException {
		String msg="Invalid email : ";
		try(Connection conn=DBUtil.provideConnection()){
		PreparedStatement ps =	conn.prepareStatement("update engineer set engpassword=? where engemail=?");
			ps.setString(1, password);
			ps.setString(2, email);
			int x=ps.executeUpdate();
			if(x>0) msg="Password changed!";
			else throw new EngineerException("Invalid email");
		} catch (SQLException e) {
			
			e.printStackTrace();
			throw new EngineerException(e.getMessage());
		}
		
		return msg;
	}

	

}

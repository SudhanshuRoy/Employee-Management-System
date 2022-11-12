package com.masai.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.masai.exception.ComplaintException;
import com.masai.exception.EngineerException;
import com.masai.exception.HODException;
import com.masai.model.Complaint;
import com.masai.model.Engineer;
import com.masai.utility.DBUtil;
import com.mysql.cj.jdbc.JdbcPreparedStatement;
import com.mysql.cj.protocol.x.SyncFlushDeflaterOutputStream;

public class HODDaoImpl implements HODDao{

	@Override
	public String logInHOD(String username, String password) throws HODException {
		String msg="Invalid username or password";
		
		try(Connection conn=DBUtil.provideConnection()){
			
		PreparedStatement ps=conn.prepareStatement("SELECT * FROM HOD where username=? AND password=?");
		ps.setString(1, username);
		ps.setString(2, password);
		ResultSet rs= ps.executeQuery();
		
		if(rs.next()) {
			msg=("Welcome : "+rs.getString("username"));
		}else {
			throw new HODException("Invalid username or password");
		}
			
		} catch (SQLException e) {
			
			e.printStackTrace();
			throw new HODException(e.getMessage());
		}
		
		return msg;
	}

	@Override
	public String registerEngineer(Engineer engineer) {
		String msg="Not Registered!";
		
		try(Connection conn=DBUtil.provideConnection()){
		PreparedStatement ps=conn.prepareStatement("insert into Engineer(engname,engemail,engpassword,category) values(?,?,?,?)");
		ps.setString(1, engineer.getEngname());
		ps.setString(2, engineer.getEngemail());
		ps.setString(3, engineer.getEngpassword());
		ps.setString(4, engineer.getCategory());
		
		
		
		int x=  ps.executeUpdate();
		if(x>0) {
			msg=(x+" Engineer registered");
		}
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return msg;
	}

	@Override
	public List<Engineer> getAllEngineersDetail() throws EngineerException {
		List<Engineer> engineers=new ArrayList<>();
		
		try(Connection conn=DBUtil.provideConnection()){
			
		PreparedStatement ps =	conn.prepareStatement("select * from Engineer");
		ResultSet rs= ps.executeQuery();
		while(rs.next()) {
			int id=rs.getInt("engid");
			String name=rs.getString("engname");
			String email=rs.getString("engemail");
			String pass=rs.getString("engpassword");
			String category=rs.getString("category");
			Engineer engineer=new Engineer(id,name,email,pass,category);
			engineers.add(engineer);
			
		}
		if(engineers.size()==0) {
			throw new EngineerException("Engineers are not found..");
		}
			
		} catch (SQLException e) {
			
			e.printStackTrace();
			throw new EngineerException(e.getMessage());
		}
		
		return engineers;
	}

	@Override
	public String deleteEngineer(int engid) throws EngineerException {
		String msg="Not deleted...";
		
		try(Connection conn=DBUtil.provideConnection()){
			
		PreparedStatement ps=	conn.prepareStatement("delete from engineer where engid=?");
		int x=ps.executeUpdate();
		
		if(x>0) {
			msg=x+" engineer deleted";
		}else {
			throw new EngineerException("Engineer not deleted");
		}
		
			
		} catch (SQLException e) {
			
			e.printStackTrace();
			throw new EngineerException(e.getMessage());
		}
		
		 return msg;
	}

	@Override
	public List<Complaint> getAllComplaints() throws ComplaintException {
		List<Complaint> complaints=new ArrayList<>();
		
		try(Connection conn=DBUtil.provideConnection()){
			
		PreparedStatement ps =	conn.prepareStatement("SELECT * from Complaint");
		ResultSet rs= ps.executeQuery();
		while(rs.next()) {
		int compid=	rs.getInt("compid");
		String category=rs.getString("category");
		String status = rs.getString("status");
		int empid=rs.getInt("empid");
		int engid=rs.getInt("engid");
		Complaint complaint=new Complaint(compid,category,status,empid,engid);
		complaints.add(complaint);
		}
			if(complaints.size()==0) {
				throw new ComplaintException("No complaint is registered.");
			}
			
		} catch (SQLException e) {
			
			e.printStackTrace();
			throw new ComplaintException(e.getMessage());
		}
		
		return complaints;
	}

	@Override
	public String assignProblemToEngineer(Complaint complaint){
		String msg="Complaint not registered..";
		try(Connection conn=DBUtil.provideConnection()){
		PreparedStatement ps=	conn.prepareStatement("insert int complaint(engid,empid,category,status) values(?,?,?,?) ");
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

	

}

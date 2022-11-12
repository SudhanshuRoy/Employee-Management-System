package com.masai.dao;

import java.util.List;

import com.masai.exception.ComplaintException;
import com.masai.exception.EngineerException;
import com.masai.exception.HODException;
import com.masai.model.Complaint;
import com.masai.model.Engineer;

public interface HODDao {
public String logInHOD(String username,String password) throws HODException;
public String registerEngineer(Engineer engineer);
public List<Engineer> getAllEngineersDetail() throws EngineerException;
public String deleteEngineer(int engid) throws EngineerException;
public List<Complaint> getAllComplaints() throws ComplaintException;
public String assignProblemToEngineer(Complaint complaint);

}

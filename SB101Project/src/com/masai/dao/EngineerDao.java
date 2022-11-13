package com.masai.dao;

import java.util.List;

import com.masai.exception.ComplaintException;
import com.masai.exception.EngineerException;
import com.masai.model.Complaint;

public interface EngineerDao {
public String engineerLogIn(String engemail,String engpassword) throws EngineerException;
public List<Complaint> getAllProblems(int engid) throws ComplaintException;
public String updateComplaintStatus(int compid,String status) throws ComplaintException;
public String changePassword(String email,String password) throws EngineerException;

}

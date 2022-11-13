package com.masai.dao;

import java.util.List;

import com.masai.exception.ComplaintException;
import com.masai.exception.EmployeeException;
import com.masai.model.Complaint;
import com.masai.model.Employee;

public interface EmployeeDao {
public String employeeRegistration(Employee employee) throws EmployeeException;
public String employeelogIn(String email,String password) throws EmployeeException;
public String employeeRegisterComplaint(Complaint complaint) throws ComplaintException;
public List<Complaint> employeeGetAllComplaintRaisedByHim(int empid) throws ComplaintException;
public String employeeChangePassword(String email,String password) throws EmployeeException;

}

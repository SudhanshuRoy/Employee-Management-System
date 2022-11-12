package com.masai.usecases;

import java.util.List;

import com.masai.dao.HODDao;
import com.masai.dao.HODDaoImpl;
import com.masai.exception.ComplaintException;
import com.masai.model.Complaint;

public class GetAllComplaints {

	public static void main(String[] args) {
		HODDao dao=new HODDaoImpl();
	    try {
			List<Complaint> complaints=	dao.getAllComplaints();
			complaints.forEach(c->System.out.println(c));
		} catch (ComplaintException e) {
			
			e.printStackTrace();
		}

	}

}

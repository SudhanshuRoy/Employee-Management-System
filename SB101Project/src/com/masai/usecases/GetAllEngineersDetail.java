package com.masai.usecases;

import java.util.List;

import com.masai.dao.HODDao;
import com.masai.dao.HODDaoImpl;
import com.masai.exception.EngineerException;
import com.masai.model.Engineer;

public class GetAllEngineersDetail {

	public static void main(String[] args) {
		HODDao dao=new HODDaoImpl();
	try {
		List<Engineer> engineers=dao.getAllEngineersDetail();
		engineers.forEach(e->System.out.println(e));
		
	} catch (EngineerException e) {
		
		e.printStackTrace();
	}

	}

}

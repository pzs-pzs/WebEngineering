package com.dlb.test;

import com.dlb.dao.UserDao;
import com.dlb.dao.impl.UserDaoImpl;
import com.dlb.model.RegisterUser;

public class Test {
	
	public static void main(String args[]){
		UserDao dao = new UserDaoImpl();
		RegisterUser user = new RegisterUser();
		boolean b = dao.login(user);
		System.out.println(b);
		
		
	}
	
   
}

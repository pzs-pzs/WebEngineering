package com.dlb.test;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.alibaba.fastjson.JSON;
import com.dlb.dao.DataDao;
import com.dlb.dao.UserDao;
import com.dlb.dao.impl.LostDaoImpl;
import com.dlb.dao.impl.UserDaoImpl;
import com.dlb.model.EndData;
import com.dlb.model.RegisterUser;

public class Test {
	
	public static void main(String args[]){
	  DataDao dao=new LostDaoImpl();
	  System.out.println(dao.getData(4+""));
		
	}
	
   
}

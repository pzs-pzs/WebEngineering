package com.dlb.listener;

import javax.servlet.annotation.WebListener;

import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;

/**
 * Application Lifecycle Listener implementation class TotalUserListenter
 *
 */
@WebListener
public class TotalUserListenter implements HttpSessionBindingListener {
	/*
	 * 统计在线人数，具有误差
	 */
     static int count=0;//一直存在直到servlet被销毁
    /**
     * Default constructor. 
     */
    public TotalUserListenter() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public void valueBound(HttpSessionBindingEvent event) {
		// TODO Auto-generated method stub
		 count++;
	}

	@Override
	public void valueUnbound(HttpSessionBindingEvent event) {
		// TODO Auto-generated method stub
		count--;
	}
	public static int getNumberOfUser(){
		return count;
	}
	
}

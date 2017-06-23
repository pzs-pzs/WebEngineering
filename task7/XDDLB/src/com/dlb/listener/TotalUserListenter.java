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
	 * ͳ�������������������
	 */
     static int count=0;//һֱ����ֱ��servlet������
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

package com.dlb.utils;

import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.beanutils.BeanUtils;

public class WebUtils {
	/**
	 * 将请求参数对应的值注入Javabean
	 * @param request
	 * @param beanClass
	 * @return
	 */
	 public  static  <T>  T requestToBean(HttpServletRequest request,Class<T> beanClass){
	    	 try{
			     T bean = beanClass.newInstance();
			     Enumeration<String> e = request.getParameterNames();
			     while(e.hasMoreElements()){
			    	         
			     			  String name = e.nextElement();
			     			  String value = request.getParameter(name);
			     			  
			     			  BeanUtils.setProperty(bean, name, value);
			     			 
			     }
			     return bean;
			     }catch(Exception e){
			     		 e.printStackTrace();
			     }
	     	     return null;
	 }
}

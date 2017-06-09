package com.dlb.control;

import java.io.IOException;
import java.io.Writer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;
import com.dlb.model.RegisterUser;
import com.dlb.model.State;
import com.dlb.service.UserService;
import com.dlb.service.impl.UserServiceImpl;
import com.dlb.utils.WebUtils;

/**
 * @author puzhengsong  
 */
@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		RegisterUser user = WebUtils.requestToBean(request, RegisterUser.class);
		
		UserService service = new UserServiceImpl();
		State state = new State();
		Writer out = response.getWriter();
		/*
		 * ×¢²á³É¹¦ ·µ»ØJSON {"success":"1"}
		 */
		if(service.register(user)){
			state.setSuccess("1");
			String json = JSON.toJSONString(state);
		   
		    out.write(json);
		    return ;
		}
		/*
		 * ×¢²áÊ§°Ü  ·µ»ØJSON {"success":"0"}
		 */
		state.setSuccess("0");
		String json = JSON.toJSONString(state);
	    out.write(json);
		
		
		
		
		
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
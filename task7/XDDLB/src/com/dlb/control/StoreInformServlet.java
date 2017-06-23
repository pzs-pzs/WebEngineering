package com.dlb.control;

import java.io.IOException;
import java.io.Writer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;
import com.dlb.model.EndData;
import com.dlb.model.State;
import com.dlb.service.DataService;
import com.dlb.service.impl.InformServeiceImpl;
import com.dlb.service.impl.LostServeiceImpl;
import com.dlb.utils.WebUtils;

/**
 * @author puzhengsong  
 */
@WebServlet("/StoreInformServlet")
public class StoreInformServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		EndData endData  = WebUtils.requestToBean(request, EndData.class);
		;
		Writer out = response.getWriter();
		State s = new State();
		DataService service = new InformServeiceImpl();
		if(service.storeJsonDate(endData)){
			s.setSuccess("1");
			String json = JSON.toJSONString(s);
			out.write(json);
			return ;
		}
		s.setSuccess("0");
		String json = JSON.toJSONString(s);
		out.write(json);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
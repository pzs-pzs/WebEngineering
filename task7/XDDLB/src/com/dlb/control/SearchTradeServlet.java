package com.dlb.control;

import java.io.IOException;
import java.io.Writer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dlb.model.RequestForm;
import com.dlb.service.DataService;
import com.dlb.service.impl.LostServeiceImpl;
import com.dlb.service.impl.TradeServeiceImpl;
import com.dlb.utils.WebUtils;

/**
 * @author puzhengsong  
 */
@WebServlet("/SearchTradeServlet")
public class SearchTradeServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		DataService service = new TradeServeiceImpl();
		RequestForm rform = WebUtils.requestToBean(request, RequestForm.class);
		
		if(rform.getId()==null){
			Writer out = response.getWriter();
			String s = service.getDataToJson(rform);
			//String s = "[{\"name\":\"pzs\",\"pass\":\"1234\"}]";
			out.write(s);
			return ;
		}
		Writer out = response.getWriter();
		String s = service.getDataToJsonByid(rform);
		//String s = "[{\"name\":\"pzs\",\"pass\":\"1234\"}]";
		out.write(s);
		return ;
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
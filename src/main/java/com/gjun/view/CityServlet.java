package com.gjun.view;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

//ch4 web.xml + CityServlet.java
//ch4 六都呈現的Servlet
public class CityServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException {
		//設定MIME與編碼
		response.setContentType("text/html;charset=UTF-8");
		//取出注入進來的初始化資訊ServletConfig
		ServletConfig config=this.getServletConfig();
		//獲取初始化資訊.xml定義
		String cities=config.getInitParameter("cities");
		//切割
		String[] cityData=cities.split(",");
		//整理下拉式功能(不好寫法)
		PrintWriter out = response.getWriter();
		out.println("<select>");
		//迴圈
		for(String item:cityData) {
			out.printf("<option value='%s'>%s</option>",item,item);
		}
		out.println("</select>");
	}

	@Override
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		super.init(config);
		System.out.println("City活過來");
		
	}
	
}

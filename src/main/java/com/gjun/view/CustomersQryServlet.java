package com.gjun.view;
//ch4 CustomersQryServlet.java + countryform.html + web.xml
import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

//繼承HttpServlet抽象類別
public class CustomersQryServlet extends HttpServlet{

	//配合表單葉面傳送方式 POST
	//Overriding doPost Method

	@Override
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		//回應編碼
		response.setContentType("text/html;charset=UTF-8");
		//設定擷取編碼規則配合前端
		request.setCharacterEncoding("UTF-8");
		//1.擷取表單欄位select 挑選項目(request)
		String country = request.getParameter("country");
		//TODO 2.進行相對資料庫紀錄查詢
		//3.處理好了 回應訊息到前端去(response)
		response.getWriter().println("<font size='7' color='red'>"+country+"</font>");
	}
	
}

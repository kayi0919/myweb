package com.gjun.view;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

//繼承的HttpServlet抽象類別 沒有抽象方法 實現Adapter Pattern
public class HelloServlet extends HttpServlet{
	//配置前端採用任何一種傳送方式進行請求 引發事件程序(改寫Servlet生命週期的service method)
		//為何注入的是介面型別 因為無法掌握網站伺服器的類別是何種名稱 使用介面多型化
		@Override
		protected void service(HttpServletRequest request, 
		HttpServletResponse response) throws ServletException, IOException {
			//回應資訊到瀏覽器去 打招呼訊息(HTML文字內容) 使用相對的ouput
			//回應是文字內容的格式??? 要設定Response Header: Content-Type???
			//寫在Response Http Header key->multi value xxx;xxx;xxx
			response.setContentType("text/html;charset=UTF-8");
			//絕對回應的內容編碼???
			//取出Writer物件
			PrintWriter out=response.getWriter();
			
			out.println("<font size='7' color='red'>世界和平</font>");
			
			
			
		}
}

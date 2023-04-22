package com.gjun.view;
//ch5 ServletContextDemo + AppConfig + web.xml + ApplicationHandler + EncodingFilter
import java.io.IOException;
import java.io.PrintWriter;
import com.gjun.domain.AppConfig;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

//繼承HttpServlet
@WebServlet("/servletcontextdemo")
public class ServletContextDemo extends HttpServlet{
	
	//採用瀏覽器直接輸入位置進行請求 採用Http Request Method-GET
	//Overriding doGet Method
	@Override
	protected void doGet(HttpServletRequest request,
		HttpServletResponse response) throws ServletException, IOException {
		//決定回應Content Type與編碼
		response.setContentType("text/html;charset=UTF-8");
		//參照出網站應用系統SevletContext
		ServletContext application=this.getServletContext();
		//網站實際目錄???
		String applicationPath=application.getContextPath(); //網站應用系統虛擬目錄
		String webPath=application.getRealPath("/");
		//讀取特定虛擬目錄 實際目錄
		String imagePath=application.getRealPath("/images");
		//輸出 回應訊息到瀏覽器去
		//取出 Writer
		PrintWriter out=response.getWriter();
		out.println("<font size='7' color='red'>應用系統目錄:"
				+applicationPath+"</font>");
		out.println("<font size='7' color='red'>應用系統/images實際目錄:"
				+imagePath+"</font>");
				
		//取出網站系統初始化參數(應用系統Global Variable)
		String connectionString=
				application.getInitParameter("connectionString");
		//輸出
		out.println("<font size='7' color='red'>應用系統初始化參數:"
				+connectionString+"</font>");
		//透過應用系統參照出 AppConfig
		AppConfig config=(AppConfig)application.getAttribute("config");
		//取出公司行號資訊
		String com=config.getCompanyName();
				
		out.println("<font size='7' color='red'>應用系統生命週期範圍物件:"
				+com+"</font>");
				
		}
	
	
}

package com.gjun.listener;
//ch5 ServletContextDemo + AppConfig + web.xml + ApplicationHandler + EncodingFilter
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;

import com.gjun.domain.AppConfig;

@WebListener
public class ApplicationHandler implements ServletContextListener{
	//聽應用系統活過來時
	@Override
	public void contextInitialized(ServletContextEvent sce) {
		System.out.println("應用系統啟動了....");
		//獲取聆聽對象 網站系統物件
		ServletContext application=sce.getServletContext();
		//建構 AppConfig個體物件 封裝配置web.xml初始化資訊
		//取出應用系統初始化參數配置
		String connectionString=
				application.getInitParameter("connectionString");
		String company=application.getInitParameter("company");
		//建構自訂Entity物件
		AppConfig config=new AppConfig();
		config.setCompanyName(company);
		config.setConnectionString(connectionString);
		//讓這一個config生命週期跟應用系統一直活著
		//狀態管理 具有Scope
		application.setAttribute("config", config);	
		}
}

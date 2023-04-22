package com.gjun.view;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

//ch4 驗證Servlet生命週期
@WebServlet(name="MyLifeHookServlet",urlPatterns= {"/MyLifeHookServlet"},loadOnStartup=2)
public class MyLifeHookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    //隨機碼
	private int number;
    
    public MyLifeHookServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		//寫出隨機碼 同一個號碼 代表物件同一個
		PrintWriter out = response.getWriter();
		out.println("物件個體隨機碼:"+number);
	}

	
	//Overriding init
	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		//設定初始化資訊
		number=(int)(Math.random()*10000);
		System.out.println("Servlet活過來:"+number);
	}
	
	
	
}

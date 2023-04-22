package com.gjun.view;
//ch4 DownLoadingImgServlet.java + image.html

import jakarta.servlet.ServletException;
import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.FileInputStream;
import java.io.InputStream;
import java.io.IOException;


@WebServlet(description = "下載圖片",urlPatterns = {"/downloading.view"})
public class DownLoadingImgServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    //建構子一定要空參數 經由部屬產生個體物件
    public DownLoadingImgServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doPost(HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException {
		//設定Response Http Header Content-type
		
		// 擷取前端的挑選項目
		String fileName=request.getParameter("selectImage");
		String path="C:/Users/user/Desktop/專題/"+fileName;
		//1.採用java.io讀取實際目錄的檔案
		InputStream is = new FileInputStream(path);
		//2.讀取緩存取
		byte[] buffer = new byte[is.available()];
		is.read(buffer);
		//2.透過Response參照出OutputStream 寫出bytes
		ServletOutputStream out=response.getOutputStream();
		out.write(buffer);
		out.flush();
		out.close();
	}

}

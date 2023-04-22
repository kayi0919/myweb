package com.gjun.filter;
//ch5 ch5 ServletContextDemo + AppConfig + web.xml + ApplicationHandler + EncodingFilter
import java.io.IOException;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;

//請求與回應編碼攔截物件
public class EncodingFilter implements Filter{
	private String encoder;

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		//請求與回應的編碼規則設定
		request.setCharacterEncoding(encoder);
		response.setCharacterEncoding(encoder);
		
		
		
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		Filter.super.init(filterConfig);
		this.encoder=filterConfig.getInitParameter("encoding");
	}
}

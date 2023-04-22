package com.gjun.domain;
//ch5 ServletContextDemo + AppConfig + web.xml + ApplicationHandler + EncodingFilter
//ch6
public class AppConfig {
	//Attribute封裝性
	private String connectionString;
	private String companyName;
		
	//setter and getter
	public String getConnectionString() {
		return connectionString;
	}
	public void setConnectionString(String connectionString) {
		this.connectionString = connectionString;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
}

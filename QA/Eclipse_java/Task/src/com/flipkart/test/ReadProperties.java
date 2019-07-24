package com.flipkart.test;

import java.io.InputStream;
import java.util.Properties;

public class ReadProperties {
	

	protected Properties prop = null;
	protected InputStream input = ReadProperties.class.getClassLoader().getResourceAsStream("ConfigData/Config_Data");
	
	public ReadProperties() throws Exception
	{
		prop = new Properties();
		prop.load(input);
	}
	
	public String getUrl()
	{
		return prop.getProperty("url");
	}
	
	public String getUsername()
	{
		return prop.getProperty("username");
	}
	
	public String getPassword()
	{
		return prop.getProperty("password");
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
	}
}

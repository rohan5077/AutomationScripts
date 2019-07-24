package com.flipkart.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Login {
	
	public WebDriver driver = null;
	public ReadProperties data = null;
	
	public Login() throws Exception
	{
		driver = new ChromeDriver();
		data = new ReadProperties();		
	}
	
	public void openChrome() throws Exception
	{
		driver.get(data.getUrl());
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try 
		{
			Login obj = new Login();
			obj.openChrome();
		}
		catch (Exception e)
		{
			e.getStackTrace();
			
		}
		
	}

}

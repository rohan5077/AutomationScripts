package com.flipkart.pages;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class LoginPage {
	
	public static WebDriver driver;
	public static Properties prop;
	

	By username = By.xpath("/html/body/div[2]/div/div/div/div/div[2]/div/form/div[1]/input");
	By password = By.xpath("//input[@type = 'password']");
	By loginBtn = By.xpath("/html/body/div[2]/div/div/div/div/div[2]/div/form/div[3]/button/span");
	
	public LoginPage(WebDriver driver)
	{
		this.driver = driver;
		
		try
		{
			prop = new Properties();
			FileInputStream file = new FileInputStream("E:\\Rohan\\QA\\Eclipse_java\\PageObjectModelJava\\src\\com\\flipkart\\config\\config.properties");
			prop.load(file);
		}
		catch(FileNotFoundException e)
		{
			e.printStackTrace();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}
	
	public void typeUserName()
	{
		driver.findElement(username).sendKeys(prop.getProperty("username"));
		System.out.println("Username Entered");
	}
	
	public void typePassword()
	{
		driver.findElement(password).sendKeys(prop.getProperty("password"));
		System.out.println("Password Entered");
	}
	
	public void loginButton()
	{
		driver.findElement(loginBtn).click();
		System.out.println("Clicked");
	}
	
	public void pageTitle()
	{
		String title = driver.getTitle();
		Assert.assertEquals(title, prop.getProperty("Website_Title"));
		System.out.println("Title Matched");
	}
	
	
}

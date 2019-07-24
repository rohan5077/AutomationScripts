 package com.flipkart.testcases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.flipkart.pages.LoginPage;

public class LoginPageTest {
	
	WebDriver driver;
	LoginPage login;
	
	@BeforeMethod
	public void openFlipkart()
	{
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://www.flipkart.com");
		login = new LoginPage(driver);
	}

	@Test(priority=0)
	public void getTitle()
	{
		login.pageTitle();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	@Test(priority=1)
	public void LoginTest() throws InterruptedException
	{
		
		login.typeUserName();
		login.typePassword();
		login.loginButton();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		System.out.println("Logged In");
		Thread.sleep(2000);
		
	}
	
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
	
}

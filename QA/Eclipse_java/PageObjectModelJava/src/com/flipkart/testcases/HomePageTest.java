 package com.flipkart.testcases;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.flipkart.pages.HomePage;
import com.flipkart.pages.LoginPage;

public class HomePageTest {
	
	WebDriver driver;
	LoginPage login;
	HomePage homePage;
	
	@BeforeMethod
	public void openFlipkart()
	{
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://www.flipkart.com");
		login = new LoginPage(driver);
	}

	
	@Test(priority=1)
	public void customerIdTest() throws InterruptedException
	{
		
		homePage.customerId();	
	}
	
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
	
}

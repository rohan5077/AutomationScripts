package com.flipkart.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.flipkart.base.TestBase;
import com.flipkart.pages.LoginPage;

public class FlipkartTestCase extends TestBase{
	
	LoginPage loginPage;
	
	public FlipkartTestCase()
	{
		super();
	}
	
	@BeforeMethod
	public void setup()
	{
		initialization();
		loginPage = new LoginPage();		
	}
	
	@Test(priority=0)
	public void loginPageTitleTest()
	{
		String title = loginPage.validateTitleTest();
		Assert.assertEquals(title, "Online Shopping Site for Mobiles, Fashion, Books, Electronics, Home Appliances and More");
	}
	
	@Test(priority=1)
	public void loginTest()
	{
		loginPage.loginTest(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.close();
	}

}

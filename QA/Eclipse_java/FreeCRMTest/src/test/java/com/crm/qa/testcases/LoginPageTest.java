package com.crm.qa.testcases;


import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.Homepage;
import com.crm.qa.pages.LoginPage;

public class LoginPageTest extends TestBase {
	
	LoginPage loginPage;
	Homepage homePage;
	
	public LoginPageTest()
	{
		super();
	}
	
	@BeforeMethod
	public void setUp()
	{
		initialization();		
		loginPage = new LoginPage();
	}
	
	@Test(priority=1)
	public void loginPageTitleTest()
	{
		String title = loginPage.validateLoginPageTitle();
		Assert.assertEquals(title, "Online Shopping Site for Mobiles, Fashion, Books, Electronics, Home Appliances and More");
		System.out.println(title);
	}
	
	@Test(priority=2)
	public void crmLogoTest()
	{
		boolean flag = loginPage.validateCrmImage();
		System.out.println(flag);
		Assert.assertTrue(flag);
	}
	
	@Test(priority=3)
	public void loginTest() throws InterruptedException
	{
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		System.out.println("Login Test");
		Thread.sleep(3000);
	}
	
	
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}

}

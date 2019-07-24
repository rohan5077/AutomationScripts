package com.crm.qa.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.DealsPage;
import com.crm.qa.pages.Homepage;
import com.crm.qa.pages.LoginPage;

public class DealsPageTest extends TestBase {
	
	LoginPage loginPage;
	Homepage homePage;
	DealsPage dealsPage;
	
	public DealsPageTest()
	{
		super();
	}
	
	@BeforeMethod
	public void setUp() throws InterruptedException
	{
		initialization();
		loginPage = new LoginPage();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		Thread.sleep(1000);
		dealsPage = homePage.funcDealPage();
		Thread.sleep(2000);
	}
	
	@Test
	public void funcCheckButton()
	{
		dealsPage.dealsOfTheDay();
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}

}

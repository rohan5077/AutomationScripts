package com.crm.qa.testcases;


import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.DealsPage;
import com.crm.qa.pages.Homepage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.pages.SearchPage;

public class HomePageTest extends TestBase{
	LoginPage loginPage;
	Homepage homePage;
	SearchPage searchPage;
	DealsPage dealPage;

	public HomePageTest()
	{
		super();
	}
	
	@BeforeMethod
	public void setUp() throws InterruptedException
	{
		initialization();
//		searchPage = new SearchPage();
		loginPage = new LoginPage();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		Thread.sleep(3000);
	}
	
	@Test(priority=0)
	public void homePageTitleTest()
	{
		String title = homePage.funcHomePageTitle();
		Assert.assertEquals(title, prop.getProperty("title"));
		System.out.println("Homepage Title Matched");
	}
	
	@Test(priority=1)
	public void customerIdTest()
	{
		String customer_Id = homePage.funcCustomerId();
		Assert.assertEquals(customer_Id, prop.getProperty("CustomerId"));
		System.out.println("Customer Id Matched");
	}
	
	@Test(priority=2)
	public void cartPage() throws InterruptedException
	{
		homePage.funcCartPage();
		Thread.sleep(5000);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	@Test(priority=3)
	public void searchPage() throws InterruptedException
	{
		searchPage = homePage.funcSearchPage();
		Thread.sleep(5000);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	@Test(priority=4)
	public void dealPage() throws InterruptedException
	{
		dealPage = homePage.funcDealPage();
		Thread.sleep(5000);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
}

package com.testng.test;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestNGBasics {

	/*
	 * 
		@BeforeSuite --System setup
		@BeforeTest --Launch Browser: 
		@BeforeClass -- Login Method
		@BeforeMethod -- Enter URL: 
		@Test:1 -- Google Title Test: 1
		@AfterMethod -- Logout from app
		@BeforeMethod -- Enter URL: 
		@Test:2 -- TestCase: 2
		@AfterMethod -- Logout from app
		@AfterClass -- Delete Cookies
		@AfterTest -- Close Browser
	 */
	//Pre-counditions annotations - stating with @Before
	@BeforeSuite											 			
	public void setUp()
	{
		System.out.println("@BeforeSuite --System setup");
	}
	
	@BeforeTest
	public void launchBrowser()
	{
		System.out.println("@BeforeTest --Launch Browser: ");
	}	
	
	@BeforeClass
	public void login()
	{
		System.out.println("@BeforeClass -- Login Method");
	}
	
	@BeforeMethod
	public void enterURL()
	{
		System.out.println("@BeforeMethod -- Enter URL: ");
	}
	
	//Test casses -- starting with @Test
	@Test
	public void googleTitleTest()
	{
		System.out.println("@Test:1 -- Google Title Test: 1");
	}
	
	/*
	 * @BeforeMethod
	 * @TestCase:1
	 * @AfterMethod
	 * 
	 * @BeforeMethod
	 * @TestCase:2
	 * @AfterMethod
	 */
	
	@Test
	public void searchTest()
	{
		System.out.println("@Test:2 -- TestCase: 2");
	}
	
	//Post conditions -- starting with @After
	@AfterMethod
	public void logOut()
	{
		System.out.println("@AfterMethod -- Logout from app");
	}
	
	@AfterClass
	public void deleteAllCookies()
	{
		System.out.println("@AfterClass -- Delete Cookies");
	}
	
	@AfterTest
	public void closeBrowser()
	{
		System.out.println("@AfterTest -- Close Browser");
	}
	
	@AfterSuite
	public void generateTestReport()
	{
		System.out.println("@AfterSuite -- Test Report");
	}
	
}

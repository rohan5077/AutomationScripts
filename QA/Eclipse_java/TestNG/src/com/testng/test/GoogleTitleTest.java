package com.testng.test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class GoogleTitleTest {

WebDriver driver;
	
	@BeforeMethod
	public void setUp()
	{
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://www.google.com");
	}
	
	@Test(priority=0)
	public void googleTitleTest()
	{
		String title = driver.getTitle();
		System.out.println(title);
		Assert.assertEquals(title, "Google", "Title is not matching");
		
	}

	@Test(priority=1)
	public void googleLogoTest()
	{
		boolean logo_status = driver.findElement(By.xpath("//*[@id=\"hplogo\"]")).isDisplayed();
		System.out.println("Google Status: "+logo_status);
//		Assert.assertTrue(logo_status);
		Assert.assertEquals(logo_status, true);
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
}

package com.testng.test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class FlipkarTest {
	
	WebDriver driver;
	
	@BeforeMethod
	public void setup()
	{
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://www.flipkart.com");
	}
	
	@Test(priority=0)
	public void loginPage()
	{
		String title = driver.getTitle();
		Assert.assertEquals(title, "Online Shopping Site for Mobiles, Fashion, Books, Electronics, Home Appliances and More", "Title didn't match!");
		System.out.println("Title Matched");
	}
	
	@Test(priority=1)
	public void loginTest()
	{
		driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div/div[2]/div/form/div[1]/input")).sendKeys("rohansharma5077@gmail.com");
		driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div/div[2]/div/form/div[2]/input")).sendKeys("Roh@n.02");
		driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div/div[2]/div/form/div[3]/button")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		System.out.println("Login Test Ok");
	}
	
	@Test(dependsOnMethods="loginTest", priority=2)
	public void homepageTest()
	{
		driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div/div[2]/div/form/div[1]/input")).sendKeys("rohansharma5077@gmail.com");
		driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div/div[2]/div/form/div[2]/input")).sendKeys("Roh@n.02");
		driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div/div[2]/div/form/div[3]/button")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		WebElement customer_text = driver.findElement(By.xpath("//*[@id=\"container\"]/div/header/div[1]/div/div/div/div[2]/div[1]/div/div/div/span/div"));
		String customer_name = customer_text.getText();
		Assert.assertEquals(customer_name, "Rohan", "Customer Homepage not found");
	}
	
//	@Test(dependsOnMethods="loginTest", priority=3)
//	public void menuTest()
//	{
//		System.out.println("Menu Test");
//	}
//	
//	@Test(dependsOnMethods="loginTest", priority=4)
//	public void registerPageTest()
//	{
//		System.out.println("Registration Test");
//	}
	
	@AfterMethod
	public void end()
	{
		driver.quit();
	}

}

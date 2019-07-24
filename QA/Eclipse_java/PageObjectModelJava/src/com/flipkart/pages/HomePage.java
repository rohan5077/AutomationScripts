package com.flipkart.pages;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class HomePage {
	
	public static WebDriver driver;
	public static Properties prop;
	By customerId = By.xpath("//*[@id=\"container\"]/div/header/div[1]/div/div/div/div[3]/div[1]/div/div/div/span/div");
	

	LoginPage login;
	
	
	public void customerId()
	{
		login.typeUserName();
		login.typePassword();
		login.loginButton();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		String customerName = driver.findElement(customerId).getText();
		Assert.assertEquals(customerName, prop.getProperty("customerName"));
		System.out.println("customer Id is matched!!");
	}

}

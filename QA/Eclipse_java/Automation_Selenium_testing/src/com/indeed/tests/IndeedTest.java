package com.indeed.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class IndeedTest {
	public static void main(String[] args) throws InterruptedException
	{
		System.setProperty("webdriver.chrome.driver", "C:\\webdriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
//		WebDriver driver = new FirefoxDriver();
		driver.get("http://www.indeed.co.uk");
		Thread.sleep(1000);
		driver.findElement(By.id("text-input-what")).sendKeys("Selenium");
		Thread.sleep(1000);
		driver.findElement(By.id("text-input-where")).clear();
		driver.findElement(By.id("text-input-where")).sendKeys("London");
		Thread.sleep(2000);
		driver.findElement(By.tagName("Button")).click();
		
		System.out.println(driver.getTitle());
		System.out.println(driver.findElement(By.id("searchCount")).getText());
		
		Thread.sleep(3000);
		driver.close();
	}

}

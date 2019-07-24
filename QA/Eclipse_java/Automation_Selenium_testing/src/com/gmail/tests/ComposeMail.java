package com.gmail.tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ComposeMail {

	public static void main(String[] args) throws InterruptedException 
	{
		// TODO Auto-generated method stub

		String username = "rohans@dosepack.com";
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize(); 
		driver.get("http://www.gmail.com");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//		Thread.sleep(3000);
		driver.findElement(By.id("identifierId")).sendKeys(username);
		driver.findElement(By.xpath("//span[contains(text(),'Next')]")).click();	
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);	
//		Thread.sleep(5000);
		
		driver.findElement(By.xpath("//*[@id=\"password\"]/div[1]/div/div[1]/input")).sendKeys("Roh@n.02");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id=\"passwordNext\"]/content/span")).click();
//		driver.findElement(By.xpath("//*[@id=\"passwordNext\"]/content/span")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);		
		Thread.sleep(5000);
		
		driver.findElement(By.cssSelector(".aic .z0 div")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id=\":n5\"]")).sendKeys("viralm@dosepack.com");
		driver.findElement(By.xpath("//*[@id=\":mn\"]")).sendKeys("Daily Typing Log");		
		driver.findElement(By.xpath("//*[@id=\":nq\"]")).sendKeys("Hi,\n\nTiming: 9pm to 10pm,\nTyping Speed: 45wpm,\nPlatform: MTT\n\nThank You");
		driver.findElement(By.xpath("//*[@id=\":md\"]")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Thread.sleep(6000);
		driver.findElement(By.xpath("//*[@id=\"gb\"]/div[2]/div[3]/div/div[2]/div[1]/img")).click();
		driver.findElement(By.xpath("//*[@id=\"gb_71\"]")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//		Thread.sleep(5000);
		driver.close();
	}

}

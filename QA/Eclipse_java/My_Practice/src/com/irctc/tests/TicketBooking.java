package com.irctc.tests;

import java.util.concurrent.TimeUnit;
import 

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class TicketBooking {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("http://www.irctc.co.in");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		driver.findElement(By.xpath("//div[@class='h_head1']/a")).click();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		Thread.sleep(5000);
		driver.findElement(By.id("userId")).sendKeys("rohanrisc");
		driver.findElement(By.id("pwd")).sendKeys("ras640");
		Thread.sleep(10000);
		driver.findElement(By.xpath("//*[@id=\"login_header_disable\"]/div/div[2]/app-login/div[2]/div/div/div[3]/div[2]/form/button")).click();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("//*[@id=\"origin\"]/span/input")).sendKeys("NDLS");
		
		Actions action = new Actions(driver);
		Thread.sleep(500);
		action.sendKeys(Keys.TAB).perform();
		
		driver.findElement(By.xpath("//*[@id=\"destination\"]/span/input")).sendKeys("CNB");
		Thread.sleep(500);
		action.sendKeys(Keys.TAB).perform();
		
		driver.findElement(By.xpath("//*[@id=\"divMain\"]/div/app-main-page/div[2]/div/div[1]/div/div/div[1]/div/app-jp-input/div[3]/form/div[3]/p-calendar/span/input")).sendKeys("02-11-2018");
		Thread.sleep(1000);
		action.sendKeys(Keys.TAB).perform();
		driver.findElement(By.xpath("//*[@id=\"divMain\"]/div/app-main-page/div[2]/div/div[1]/div/div/div[1]/div/app-jp-input/div[3]/form/div[7]/button")).click();
		
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.findElement(By.id("check-availability")).click();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);	
		driver.findElement(By.xpath("//*[@id=\"ui-panel-0-content\"]/div/div/div/table/tbody/tr/td[1]/div/div[3]/button")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.findElement(By.xpath("//*[@id=\"divMain\"]/div/app-train-list/div[5]/div/div[2]/div[2]/div[5]/div[1]/div/app-train-avl-enq/p-dialog/div/div[2]/div[1]/div[2]/button")).click();
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//*[@id=\"psgn-name\"]")).sendKeys("Rohan Sharma");
		driver.findElement(By.xpath("//*[@id=\"divMain\"]/div/app-passenger-input/div[5]/form/div/div[1]/div[3]/div[1]/div/div[2]/app-passenger/div/div[1]/div[2]/input")).sendKeys("22");
		
		Select dropdown = new Select(driver.findElement(By.xpath("//*[@id=\"divMain\"]/div/app-passenger-input/div[5]/form/div/div[1]/div[3]/div[1]/div/div[2]/app-passenger/div/div[1]/div[3]/select")));
		dropdown.selectByVisibleText("Male");
		
		dropdown = new Select(driver.findElement(By.xpath("//*[@id=\"divMain\"]/div/app-passenger-input/div[5]/form/div/div[1]/div[3]/div[1]/div/div[2]/app-passenger/div/div[1]/div[4]/select")));
		dropdown.selectByVisibleText("Upper");
		
		dropdown = new Select(driver.findElement(By.xpath("//*[@id=\"divMain\"]/div/app-passenger-input/div[5]/form/div/div[1]/div[3]/div[1]/div/div[2]/app-passenger/div/div[1]/div[5]/select")));
		dropdown.selectByVisibleText("No Food");
		
		driver.findElement(By.xpath("//*[@id=\"divMain\"]/div/app-passenger-input/div[5]/form/div/div[1]/div[5]/div/button[1]")).click();
//		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Thread.sleep(15000);
		driver.findElement(By.xpath("//*[@id=\"divMain\"]/div/app-passenger-input/div[5]/form/div/div[1]/div[5]/div/button[1]")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
	}

}

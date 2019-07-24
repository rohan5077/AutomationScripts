package com.trash.tests;


import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class DragnDrop {

	public static void main(String[] args) throws IOException, InterruptedException {
		// TODO Auto-generated method stub

		WebDriver driver = new ChromeDriver();
		
		driver.get("http://marcojakob.github.io/dart-dnd/custom-avatar/web/");
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		File empty = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(empty, new File("E:\\Rohan\\QA\\Screenshots\\empty.png"));
		
//		driver.findElement(By.xpath("/html/body/div/img[1]")).click();
//		WebElement drag = driver.findElement(By.xpath("/html/body/div/img[1]"));
//		WebElement drop = driver.findElement(By.xpath("/html/body/div/div"));
		
		WebElement drag = driver.findElement(By.xpath("/html/body/div/img[1]"));
		Thread.sleep(2000);
		WebElement drop = driver.findElement(By.xpath("/html/body/div/div"));
		Actions act = new Actions(driver);
		act.dragAndDrop(drag, drop).perform();
		
		File full = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE); 
		FileUtils.copyFile(full, new File("E:\\Rohan\\QA\\Screenshots\\full.png"));
		
		Thread.sleep(3000);
		
		driver.close();
		
		
		
//		try {
//			FileUtils.copyFile(scrFile, new File("E:\\Rohan\\QA\\Screenshots\\empty.png"));
//		}
//		catch (IOException e) {
//			e.printStackTrace();
//		}
		
	}

}

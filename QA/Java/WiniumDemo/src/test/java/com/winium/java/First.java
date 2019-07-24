package com.winium.java;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.winium.DesktopOptions;
import org.openqa.selenium.winium.WiniumDriver;

public class First {

	public static void main(String[] args) throws MalformedURLException, InterruptedException {
		// TODO Auto-generated method stub

		DesktopOptions desktop = new DesktopOptions();
		
		desktop.setApplicationPath("C:\\Windows\\System32\\calc.exe");
		WiniumDriver driver = new WiniumDriver(new URL("http://localhost:9999"), desktop);
		Thread.sleep(2000);
		driver.findElement(By.name("Seven")).click();
		driver.findElement(By.name("Plus")).click();
		driver.findElement(By.name("Eight")).click();
		driver.findElement(By.name("Equals")).click();
		String output = driver.findElement(By.id("CalculatorResults")).getAttribute("Name");
		System.out.println(output);
		driver.findElement(By.name("Close")).click();
	}

}

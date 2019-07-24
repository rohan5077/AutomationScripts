package com.flipkart.test;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LogDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		WebDriver driver = new ChromeDriver();
		Logger logger = Logger.getLogger("LogDemo");
		PropertyConfigurator.configure("Config.properties");
		
		driver.get("http://www.google.com");
		logger.info("Website is opened");
	}

}

package com.crm.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import com.crm.qa.util.TestUtil;

public class TestBase {

	public static WebDriver driver;
	public static Properties prop;
	public static Actions act;
	
	public TestBase()
	{
		try 
		{
			prop = new Properties();
			FileInputStream file = new FileInputStream("E:\\Rohan\\QA\\Eclipse_java\\FreeCRMTest\\src\\main\\java\\com\\crm\\qa\\config\\config.properties ");
			prop.load(file);
		}
		catch (FileNotFoundException e)
		{
			e.printStackTrace();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		
	}
	
	public static void initialization()
	{
		driver = new ChromeDriver();
		act = new Actions(driver);
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT , TimeUnit.SECONDS);
		
		driver.get(prop.getProperty("url"));
	}
	
	
}

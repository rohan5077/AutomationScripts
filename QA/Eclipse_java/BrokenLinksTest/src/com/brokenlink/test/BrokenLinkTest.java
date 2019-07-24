package com.brokenlink.test;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrokenLinkTest {

	public static void main(String[] args) throws InterruptedException, MalformedURLException, IOException {
		// TODO Auto-generated method stub

		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.get("http://www.freecrm.com");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.findElement(By.name("username")).sendKeys("naveenk");
		driver.findElement(By.name("password")).sendKeys("test@123");
		Thread.sleep(1000);
		
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		driver.switchTo().frame("mainpanel");
//		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		//get the list of all the links and images
		List<WebElement> linksList = driver.findElements(By.tagName("a"));
		linksList.addAll(driver.findElements(By.tagName("img")));
		
		System.out.println("Number of active Links are: "+linksList.size());
		
		List<WebElement> activeLinks = new ArrayList<WebElement>();
		
		//iterate linkslist : exclude all the links/images which does not have href attributes
		for(int i = 0; i<linksList.size(); i++)
		{
			System.out.println(linksList.get(i).getAttribute("href"));
			if (linksList.get(i).getAttribute("href") != null && !linksList.get(i).getAttribute("href").contains("javascript") )
			{				
				activeLinks.add(linksList.get(i));
			}
//			else
//			{
//				String free_a = linksList.get(i).getAttribute("href");
//				System.out.println(free_a);
//			}
		}
		
		//check the href url, with httpconnection api:
		for (int j = 0; j< activeLinks.size(); j++)
		{
			HttpURLConnection connection = (HttpURLConnection)new URL(activeLinks.get(j).getAttribute("href")).openConnection();
			connection.connect();
			String response = connection.getResponseMessage(); 	//ok
			connection.disconnect();
			System.out.println(activeLinks.get(j).getAttribute("href")+ "-----"+ response);
		}
		
		//get the size of active links
		System.out.println("Number of active Links are: "+activeLinks.size());
		driver.quit();
	}

}

package com.flipkart.test;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;



public class FlipkartLogin {
	
//	String flipkart_title = "Online Shopping Site for Mobiles, Fashion, Books, Electronics, Home Appliances and More";

	public static void main(String[] args) throws InterruptedException, IOException {
		// TODO Auto-generated method stub

		WebDriver driver = new ChromeDriver();
		FileWriter notepad_text = new FileWriter("E:\\Rohan\\QA\\Document_Text\\data.txt");
		BufferedWriter file = new BufferedWriter(notepad_text);
		
		
		driver.get("https://www.flipkart.com/");
		String title = driver.getTitle();
		if (title.equals("Online Shopping Site for Mobiles, Fashion, Books, Electronics, Home Appliances and More"))
		{
			System.out.println("Flipkart Homepage is Opened!!");
			file.write("Homepage title is: "+title);
			file.newLine();
		}
		else 
		{
			System.out.println("Title is not matched");
		}
		
		driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div/div[2]/div/form/div[1]/input")).sendKeys("rohansharma5077@gmail.com");
		driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div/div[2]/div/form/div[2]/input")).sendKeys("Roh@n.02");
		driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div/div[2]/div/form/div[3]/button")).click();
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		WebElement customer_text = driver.findElement(By.xpath("//*[@id=\"container\"]/div/header/div[1]/div/div/div/div[2]/div[1]/div/div/div/span/div"));
		String customer_name = customer_text.getText();
//		System.out.println(customer_name);
		
		
		if (customer_name.equals("Rohan"))
		{
			System.out.print("Customer Name is: "+customer_name);
			file.write("Customer Name is: "+customer_name);
			file.newLine();
		}
		else 
		{
			System.out.println("Wrong Homepage");
		}
				
		file.close();
		Thread.sleep(5000);
		driver.quit();
	}

}

package com.pom.task;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login {

//	public static void main(String[] args) {
		// TODO Auto-generated method stub

		private WebDriver driver = null;
		
		@FindBy(xpath="/html/body/div[2]/div/div/div/div/div[2]/div/form/div[1]/input")
		private WebElement username;
		
		@FindBy(xpath="/html/body/div[2]/div/div/div/div/div[2]/div/form/div[2]/input")
		private WebElement password;
		
		@FindBy(xpath="/html/body/div[2]/div/div/div/div/div[2]/div/form/div[3]/button")
		private WebElement signin;
		
		public void setUsername(String usernameData)
		{
			username.sendKeys(usernameData);
		}
		
		public void setPassword(String passwordData)
		{
			password.sendKeys(passwordData);
		}
		
		public void clickSignin()
		{
			signin.click();
			HomePage h = new HomePage();
			return h;
		}
		
		public login(WebDriver driver)
		{
			this.driver = driver;
			PageFactory.initElements(driver, this);
			
		}
		
	}

//}

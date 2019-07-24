package com.flipkart.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.flipkart.base.TestBase;

public class LoginPage extends TestBase{

	//PageFactory
	@FindBy(xpath = "//input[@type = 'text']")
	WebElement username;
	
	@FindBy(xpath = "//input[@type = 'password']")
	WebElement password;
	
	@FindBy(xpath = "//span[contains(text(), 'Login')]")
	WebElement loginBtn;
	
	@FindBy(xpath = "//span[contains(text(), 'Forgot?')]")
	WebElement forgotPwdBtn;
	
	@FindBy(xpath = "//span[contains(text(), 'New to Flipkart? Sign up')]")
	WebElement signUpBtn;
	
	public LoginPage()
	{
		PageFactory.initElements(driver, this);		
	}
	
	public String validateTitleTest()
	{
		return driver.getTitle();
	}
	
	public String loginTest(String un, String pwd)
	{
		username.sendKeys(un);
		password.sendKeys(pwd);
		loginBtn.click();
		return "Logged In";
	}
	
}

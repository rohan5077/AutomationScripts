package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class LoginPage extends TestBase {
	
	//Object Repository
	@FindBy(xpath = "/html/body/div[2]/div/div/div/div/div[2]/div/form/div[1]/input")
	WebElement username;
	
	@FindBy(xpath = "//input[@type = \"password\"]")
	WebElement password;
	
	@FindBy(xpath = "/html/body/div[2]/div/div/div/div/div[2]/div/form/div[3]/button")
	WebElement loginButton;
	
	@FindBy(xpath = "//span[contains(text(), \"New to Flipkart? Sign up\")]")
	WebElement signupButton;
	
	@FindBy(xpath = "//img[contains(@class, 'jnSYHL')]")
	WebElement flipkartLogo;
	
	//Initialization of Page Objects
	public LoginPage()
	{
		PageFactory.initElements(driver, this);  //this can be replaced by class name also 
	}

	public String validateLoginPageTitle()
	{
		return driver.getTitle();
	}
	
	public boolean validateCrmImage()
	{
		return flipkartLogo.isDisplayed();
	}
	
	public Homepage login(String user_name, String pass_word)
	{
		username.sendKeys(user_name);
		password.sendKeys(pass_word);
		loginButton.click();
		
		return new Homepage();
	}
	
}

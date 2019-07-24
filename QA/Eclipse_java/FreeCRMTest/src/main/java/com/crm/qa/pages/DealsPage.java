package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class DealsPage extends TestBase{

	@FindBy(xpath = "//*[@id=\"container\"]/div/div[1]/div/div[1]/div/div[3]/div[1]/a")
	WebElement dealsoftheday;
	
	public DealsPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public boolean dealsOfTheDay()
	{
		return dealsoftheday.isDisplayed();
	}
}

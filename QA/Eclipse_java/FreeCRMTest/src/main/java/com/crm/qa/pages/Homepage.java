package com.crm.qa.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class Homepage extends TestBase {

	
	@FindBy(xpath = "/html/head/title/text()")
	WebElement homePageTitle;
	
	@FindBy(xpath = "//*[@id=\"container\"]/div/header/div[1]/div/div/div/div[3]/a")
	WebElement cartPagePath;
	
	@FindBy(xpath = "//*[@id=\"container\"]/div/div[1]/div[2]/div[1]/div/div[2]/div[1]/div/div[1]/div/div[2]/a")
	WebElement dealPagePath;
	
	@FindBy(xpath = "//*[@id=\"container\"]/div/header/div[1]/div/div/div/div[3]/div[1]/div/div/div/span/div")
	WebElement customerId;
	
	@FindBy(xpath = "//*[@id=\"container\"]/div/header/div[1]/div/div/div/div[2]/form/div/div[1]/div/input")
	WebElement searchPath;
	
	//Initialize homepage
	public Homepage() {
		PageFactory.initElements(driver, this);
	}
	
	public String funcHomePageTitle()
	{
		String homePageTitle = driver.getTitle();
		return homePageTitle;
	}
	
	public void funcCartPage() {
		cartPagePath.click();
	}
	
	public DealsPage funcDealPage() {
		dealPagePath.click();
		return new DealsPage();
	}
	
	public String funcCustomerId()
	{
		String customer_Id = customerId.getText();
		return customer_Id;
	}
	
	public SearchPage funcSearchPage()
	{
		String searchResult = prop.getProperty("Search");
		searchPath.sendKeys(searchResult);
		System.out.println(searchResult);
		act.sendKeys(Keys.ENTER).perform();
		return new SearchPage();
	}
}

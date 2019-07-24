package com.pom.task;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage {

//	public static void main(String[] args) {
		// TODO Auto-generated method stub

		WebDriver driver = null;
		
		@FindBy()
		private WebElement logoutLink;
		
		public void verifyLogoutLink()
		{
			Boolean result = false;
			result = logoutLink.isDisplayed();
			return result;
		}
//	}

}

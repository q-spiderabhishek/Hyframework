package com.hyframework.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Loginpage {
	
	WebDriver driver;
	
	public Loginpage(WebDriver ldriver)

	{
		this.driver=ldriver;
	}

	@FindBy(xpath = "//input[@placeholder='E-mail address']") WebElement uname;
	
	@FindBy(xpath = "//input[@placeholder='Password']") WebElement pass;

	@FindBy(xpath = "//div[@class='ui fluid large blue submit button']") WebElement loginButton;
	


	
	public void loginToRefined(String usernameapp,String passwordapp)
	
	{
		
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			
		}
		uname.sendKeys(usernameapp);
		pass.sendKeys(passwordapp);
		loginButton.click();
		
	}

	
}

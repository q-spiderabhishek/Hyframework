package com.hyframework.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CRMhomepage {
	
WebDriver driver;
	
	public CRMhomepage(WebDriver ldriver)
	
	{
		this.driver=ldriver;
	}

	@FindBy(xpath="//span[contains(text(),'Contacts')]") WebElement contactmenu;
	
	@FindBy(xpath="//button[contains(text(),'New')]") WebElement Newcontact;
	
	@FindBy(xpath="//input[@name='first_name']") WebElement Fname;
	
	
	
	public void WelcomeTOCRMHome(String Firstname)
	
	{
		
		try {
			Thread.sleep(7000);
		} catch (InterruptedException e) {
			
			System.out.println(" Home page ");
			
		}
		
		contactmenu.click();
		
		try {
			Thread.sleep(7000);
		} catch (InterruptedException e) {
			
			System.out.println(" click on contact ");
		}
		
		
		Newcontact.click();
		
		try {
			Thread.sleep(7000);
		} catch (InterruptedException e) {
			
			System.out.println(" Create new contact ");
			
		}
		
		Fname.sendKeys(Firstname);
	}

}

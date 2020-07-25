package com.hyframework.utility;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BrowserFactory {
	
	public static WebDriver startApplication(WebDriver driver,String browserName,String appURL)
	
	{
	if(browserName.equals("Firefox"))	
		
	{
		
		System.setProperty("webdriver.gecko.driver", "./DVRS/geckodriver.exe");
        driver = new FirefoxDriver();
	}
	
	else if (browserName.equals("Chrome")) 
	
	{
		System.setProperty("webdriver.chrome.driver","./DVRS/chromedriver.exe");
		driver = new ChromeDriver();
	}
	else 
	{
		System.out.println(" browser don't supported ");
	}
	driver.manage().timeouts().pageLoadTimeout(120, TimeUnit.SECONDS);
	driver.manage().window().maximize();
	driver.get(appURL);
	driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
	
	return driver;
	}
	
	public static void closeBrowser(WebDriver driver)
	
	{
		
		driver.quit();
	}

}

package com.hyframework.pages;


import java.io.File;
import java.io.IOException;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.support.PageFactory;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.hyframework.utility.BrowserFactory;
import com.hyframework.utility.ConfigDataProvider;
import com.hyframework.utility.ExcelDataProvider;
import com.hyframework.utility.Helper;

public class Baseclass
  
{
	public WebDriver driver;
	public ExtentReports report;
	public ExtentTest logger;
	
	
	@BeforeSuite
	public void  setReport()
	
	{
		ExtentHtmlReporter extent = new ExtentHtmlReporter(new File(System.getProperty("user.dir")+"/REPORT1/FreeCRM+"+Helper.getCurrentDateTime()+".html"));
		report = new ExtentReports();
		report.attachReporter(extent);
	}
	
	@Parameters({"browser","QAUrl"})
	@BeforeClass
	public void setup(String browser, String url)
	
	{
		 
		ConfigDataProvider config = new ConfigDataProvider();
		
		driver = BrowserFactory.startApplication(driver, browser,url);
		
		ExcelDataProvider excel = new ExcelDataProvider();
		

		Loginpage loginPage = PageFactory.initElements(driver, Loginpage.class);
		
		loginPage.loginToRefined(excel.getStringData("Login", 0, 0), excel.getStringData("Login", 0, 1));


		
			}
	
	@AfterClass
	public void tearDown()
	{
		BrowserFactory.closeBrowser(driver);

	}
	
	@AfterMethod
	public void teardownmethod(ITestResult result) throws IOException
	
	{
		if (result.getStatus()==ITestResult.FAILURE) 
		{
			
			logger.fail("Test failed", MediaEntityBuilder.createScreenCaptureFromPath(Helper.captureScreenshot(driver)).build());
		}
		
		else if (result.getStatus()==ITestResult.SUCCESS)
	    {
			logger.pass("Test pass", MediaEntityBuilder.createScreenCaptureFromPath(Helper.captureScreenshot(driver)).build());
		}
		
		report.flush();
		
	}
		
	

}

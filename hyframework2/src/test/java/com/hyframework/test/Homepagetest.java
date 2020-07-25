package com.hyframework.test;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.hyframework.pages.Baseclass;
import com.hyframework.pages.CRMhomepage;


public class Homepagetest extends Baseclass {
	
	@Test()
	public void WelcomeHomePage()
	{
    	
      logger= report.createTest(" welcome to FreeCRM ");
				
		CRMhomepage crmhomepage = PageFactory.initElements(driver, CRMhomepage.class);
		
		logger.info(" Homepage displayed ");
        
		crmhomepage.WelcomeTOCRMHome("Abhishek");
		
		logger.pass(" Create new contact page displayed ");
		
		
}


}

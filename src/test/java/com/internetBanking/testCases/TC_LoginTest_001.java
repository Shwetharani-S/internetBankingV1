package com.internetBanking.testCases;


import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.internetBankingV1.pageObjects.LoginPage;

public class TC_LoginTest_001 extends BaseClass {
	
	@Test
	public void loginTest() throws IOException                //loginTest is the test case name
	
	{
		
		log.info("URL opened");
		LoginPage lp = new LoginPage(driver);
		lp.setUserName(username);
		log.info("Entered User Name");
		lp.setPassword(password);
		log.info("Entered Password");
		lp.clickSubmit();
		log.info("Clicked Submit");
		
		if(driver.getTitle().equals("Guru99 Bank Manager HomePage"))
		{
			Assert.assertTrue(true);
			log.info("Login test successfull");
		}
		else
		{
			captureScreen(driver,"loginTest"); //captureScreen method is present in BaseClass
			Assert.assertTrue(false);
			log.info("Login test failed");
		}
	}


}

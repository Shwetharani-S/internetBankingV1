package com.internetBanking.testCases;


import java.io.IOException;

import org.junit.Assert;

import org.testng.annotations.Test;

import com.internetBankingV1.pageObjects.AddCustomerPage;
import com.internetBankingV1.pageObjects.LoginPage;

public class TC_AddCustomer_003 extends BaseClass{
	
	@Test
	public void addNewCustomer() throws InterruptedException, IOException
	{
		LoginPage lp= new LoginPage(driver);
		lp.setUserName(username);
		log.info("User name provided");
		lp.setPassword(password);
		log.info("Password provided");
		lp.clickSubmit();
		log.info("Clicked on Submit");
		
		Thread.sleep(3000);
		
		AddCustomerPage addcust = new AddCustomerPage(driver);
		addcust.clickAddNewCustomer();
		
		log.info("Providing customer details");
		
		addcust.setCustomerName("Shwetha");
		addcust.setGender();
		addcust.setdob("12", "08", "1997");
		addcust.setAddress("Mysore. Karnataka, India");
		addcust.setCity("Mysore");
		addcust.setState("Karnataka");
		addcust.setPin("570010");
		addcust.setPhoneNo("343545646");
		addcust.setEmailId(randomestring()+"@gmail.com"); //randomstring() method is in BaseClass it will create random email id
		addcust.setPW("test@123");
		addcust.setSubmit();
		
		Thread.sleep(3000);
		
		log.info("Validation Started....");
		
		boolean res=driver.getPageSource().contains("Customer Registered Successfully!!!");
		
		if(res==true)
		{
			Assert.assertTrue(true);
			log.info("test cases is passed");
		}
		else
		{
			log.info("test cases is failed");
			captureScreen(driver,"addNewCustomer");
			Assert.assertFalse(false);
		}
	}
	

}

package com.internetBanking.testCases;

import java.io.IOException;

import org.openqa.selenium.NoAlertPresentException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.internetBanking.utilities.XLUtils;
import com.internetBankingV1.pageObjects.LoginPage;

public class TC_LoginDDD_002 extends BaseClass{
    
	@Test(dataProvider="LoginData")
	public void loginDDD(String user,String pwd) throws InterruptedException
	{
		LoginPage lp=new LoginPage(driver);
		lp.setUserName(user);
		log.info("user name provided");
		lp.setPassword(pwd);
		log.info("password provided");
		lp.clickSubmit();
		
		Thread.sleep(3000);
		
		if(isAlertPresent()==true)
		{
			driver.switchTo().alert().accept();//close alert
			driver.switchTo().defaultContent();
			Assert.assertTrue(false);
			log.warn("Login failed");
		}
		else
		{
			Assert.assertTrue(true);
			log.info("Login passed");
			lp.clickLogout();
			Thread.sleep(3000);
			driver.switchTo().alert().accept();//close logout alert
			driver.switchTo().defaultContent();
			
		}	
		
	}
	
	public boolean isAlertPresent() //user defined method created to check alert is present or not
	{
		try
		{
		driver.switchTo().alert();
		return true;
		}
		catch(NoAlertPresentException e)
		{
			return false;
		}
		
	}
	
	@DataProvider(name="LoginData")
	String [][] getData() throws IOException{
	
		
		String path= System.getProperty("user.dir")+"/src/test/java/com/internetBanking/testData/LoginData.xlsx";
		
		int rownumber = XLUtils.getRowCount(path, "Sheet1");
		int cocount = XLUtils.getCellCount(path, "Sheet1",1);
		
		String logindata[][]=new String[rownumber][cocount];
		
		for(int i=1;i<=rownumber;i++)
		{
			for(int j=0;j<cocount;j++)
			{
				logindata[i-1][j]=XLUtils.getCellData(path, "Sheet1", i,j); //i-1 because in excel we have users 1st row for column names, so actual data starts from row 1, where as in array row starts from 0
			}
		}
		return logindata;
		
	}
}

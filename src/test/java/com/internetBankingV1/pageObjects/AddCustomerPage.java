package com.internetBankingV1.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class AddCustomerPage {
	WebDriver Idriver;
	
	public AddCustomerPage(WebDriver rdriver)
	{
		Idriver = rdriver;
		PageFactory.initElements(rdriver, this); //initiate the webdriver
	}
	
	@FindBy(how = How.XPATH, using ="/html/body/div[3]/div/ul/li[2]/a")
	@CacheLookup
	WebElement lnkAddNewCustomer;
	
	@FindBy(name="name") 
	WebElement CustomerName;
	
	@FindBy(xpath="//input[@value='f']")
	WebElement Gender;
	
	@FindBy(xpath="//input[@type='date']")
	WebElement dob;
	
	@FindBy(xpath="//textarea[@name='addr']")
	WebElement Address;
	
	@FindBy(xpath="//input[@name='city']")
	WebElement City;
	
	@FindBy(xpath="//input[@name='state']")
	WebElement State;
	
	@FindBy(xpath="//input[@name='pinno']")
	WebElement Pin;
	
	@FindBy(xpath="//input[@name='telephoneno']")
	WebElement PhoneNo;
	
	@FindBy(xpath="//input[@name='emailid']")
	WebElement EmailId;
	
	@FindBy(xpath="//input[@name='password']")
	WebElement PW;
	
	@FindBy(xpath="//input[@type='submit']")
	WebElement Submit;
	
	public void clickAddNewCustomer() {
		lnkAddNewCustomer.click();
			
	}

	
	public void setCustomerName(String uname)
	{
		CustomerName.sendKeys(uname);
	}
	public void setGender()
	{
		Gender.click();
	}
	public void setdob(String dd, String mm, String yy )
	{
		dob.sendKeys(dd);
		dob.sendKeys(mm);
		dob.sendKeys(yy);
	}
	public void setAddress(String addrs)
	{
		Address.sendKeys(addrs);
	}
	public void setCity(String city)
	{
		City.sendKeys(city);
	}
	public void setState(String state)
	{
		State.sendKeys(state);
	}
	public void setPin(String pin)
	{
		Pin.sendKeys(pin);
	}
	public void setPhoneNo(String phoneno)
	{
		PhoneNo.sendKeys(phoneno);
	}
	public void setEmailId(String emailid)
	{
		EmailId.sendKeys(emailid);
	}
	public void setPW(String pwd)
	{
		PW.sendKeys(pwd);
	}
	public void setSubmit()
	{
		Submit.click();
	}
		

}

package com.internetBanking.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {
	
	Properties pro; //create an object for properties class
	
	public ReadConfig() //constructor to load the complete config.properties file
	{
		File src= new File("./Configuration\\config.properties"); //path of config.properties
		
		try {
			FileInputStream fis = new FileInputStream(src);
			pro=new Properties();
			pro.load(fis); //loads data present in config.properties
		}catch(Exception e) {
			System.out.println("Exception is " + e.getMessage());
		}
		
	}
	
	// To read each value of variable from config.properties need to create different methods
	
	public String getApplicationURL()
	{
		String url=pro.getProperty("baseURL");
		return url;
	}
	
	public String getUsername()
	{
		String username=pro.getProperty("username");
		return username;
	}
	
	public String getPassword()
	{
		String password=pro.getProperty("password");
		return password;
	}
	
	public String getChromePath()
	{
		String chromepath=pro.getProperty("chromepath");
		return chromepath;
	}
	
	public String getFirefoxPath()
	{
		String firefoxpath=pro.getProperty("firefoxpath");
		return firefoxpath;
	}

}

package com.zoopla.testcases;

import org.apache.commons.logging.Log;

//import org.apache.logging.log4j;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.beust.jcommander.Parameter;
import com.zoopla.utilities.ReadConfig;

public class BaseClass {
	
	ReadConfig readconfig=new ReadConfig();
	public String url=readconfig.getApplicationurl();
	public static WebDriver driver;
	public static Log logger;
	
	@Parameters("browser")
	@BeforeSuite
	public void setup()
	{
		System.setProperty("webdriver.chrome.driver", "F:\\chromedrive\\chromedriver.exe");
		 driver=new ChromeDriver();
		 driver.get(url);
		 
		 driver.manage().window().maximize();
	}
	@AfterSuite(enabled=false)
	public void TearDown()
	{
		driver.close();
	}

}

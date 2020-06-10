package com.qa.hubspot.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BasePage {
	
	WebDriver driver;
	Properties prop;
	
	public WebDriver init_Driver(String browserName)
	{
		
		System.out.println("Name of the browser is " +browserName);
		if(browserName.equalsIgnoreCase("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver= new ChromeDriver();
		}
		else
		{
			System.out.println("Browser " +browserName+ "is not a valid name......");
		}
		
		driver.manage().deleteAllCookies();
		driver.manage().window().fullscreen();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		
		return driver;
	}
	
	public Properties set_properties()
	{
		prop = new Properties();
		String path = "./src/main/java/com/qa/hubspot/config/config.properties";
		try 
		{
			FileInputStream ip = new FileInputStream(path);
			prop.load(ip);
		} 
		catch (FileNotFoundException e) 
		{
			System.out.println("Some issue with the config properties.Please check...");
		} catch (IOException e)
		{
			e.printStackTrace();
		}
		
		return prop;		
	}

}

package com.qa.hubspot.util;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HubSpotUtil {
	
	WebDriver driver;
	WebDriverWait wait;
	
	
	public HubSpotUtil(WebDriver driver)
	{
		this.driver=driver;
		wait = new WebDriverWait(driver, AppConstant.DEFAULT_TIMEOUT);
	}
	
	
	public boolean doWaitForElementPresent(By locator)
	{
		wait.until(ExpectedConditions.presenceOfElementLocated(locator));
		return true;
	}
	
	public boolean doWaitForElementVisible(By locator)
	{
		wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		return true;
	}
	
	public boolean doWaitForTitlePresent(String value)
	{
		wait.until(ExpectedConditions.titleIs(value));
		return true;
	}
	
	
	
	public String doGetPageTitle()
	{
		try
		{
		 return driver.getTitle();
		}
		catch(Exception e)
		{
			System.out.println("Some issue while trying to retrieve the page title");
		}
		return null;
	}
	
	

	public WebElement doGetElement(By locator)
	{
		WebElement element = null;
		try
		{
		if(doWaitForElementPresent(locator))
		element = driver.findElement(locator);
		}
		catch(Exception e)
		{
			System.out.println("Some issue while creating the WebElement.Please check...");
		}
		return element;
	}
	
	public void doSendKeys(By locator, String value)
	{
		try
		{
		WebElement ele = doGetElement(locator);
		ele.clear();
		ele.sendKeys(value);
		}
		catch(Exception e)
		{
			System.out.println("Some issue occured while entering value. Please check...");
		}
	}
	
	public void doClick(By locator)
	{
		try
		{
		doGetElement(locator).click();
		}
		catch(Exception e)
		{
			System.out.println("Some issue occured while trying to click on the element. Please check...");
		}
	}
	
	public boolean doIsDisplayed(By locator)
	{
		try
		{
			return doGetElement(locator).isDisplayed();
		}
		catch(Exception e)
		{
			System.out.println("Some Issue occured while trying check the display of the element. Please check...");
		}
		return false;
	}
	
	public String doGetText(By locator)
	{
		try
		{
		return doGetElement(locator).getText();
		}
		catch(Exception e)
		{
			System.out.println("Some error occurred while trying to fetch the text. Please check...");
		}
		return null;
	}
}

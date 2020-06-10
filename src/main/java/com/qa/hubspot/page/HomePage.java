package com.qa.hubspot.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.hubspot.base.BasePage;
import com.qa.hubspot.util.AppConstant;
import com.qa.hubspot.util.HubSpotUtil;

public class HomePage extends BasePage {
	
	WebDriver driver;
	HubSpotUtil hubSpotUtil;
	
	By header = By.xpath("//h1[text()='Sales Dashboard']");
	
	
	
	public HomePage(WebDriver driver)
	{
		this.driver=driver;
		hubSpotUtil = new HubSpotUtil(driver);
	}
	
	public String getHomePageTitle()
	{
		hubSpotUtil.doWaitForTitlePresent(AppConstant.HOME_PAGE_TITLE);
		return hubSpotUtil.doGetPageTitle();
	}
	
	public String getHomePageHeader()
	{
		return hubSpotUtil.doGetText(header);
	}

}

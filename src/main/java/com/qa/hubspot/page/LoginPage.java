package com.qa.hubspot.page;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.hubspot.base.BasePage;
import com.qa.hubspot.util.AppConstant;
import com.qa.hubspot.util.HubSpotUtil;

public class LoginPage extends BasePage{
	
	WebDriver driver;
	HubSpotUtil hubSpotUtil;
	
	By emailID = By.id("username");
	By password = By.id("password");
	By loginButton = By.id("loginBtn");
	By signUp = By.linkText("Sign up");
	
	public LoginPage(WebDriver driver)
	{
		this.driver=driver;
		hubSpotUtil = new HubSpotUtil(driver);
	}
	
	public String getLoginPageTitle()
	{
		hubSpotUtil.doWaitForTitlePresent(AppConstant.LOGIN_PAGE_TITLE);
		return hubSpotUtil.doGetPageTitle();
	}
	
	public boolean checkLoginPageSignUpLink()
	{
		return hubSpotUtil.doIsDisplayed(signUp);
	}
	
	public HomePage clickLoginPageLogInButton(String username, String pwd)
	{
		hubSpotUtil.doSendKeys(emailID, username);
		hubSpotUtil.doSendKeys(password, pwd);
		hubSpotUtil.doClick(loginButton);
		
		return new HomePage(driver);
	}

}

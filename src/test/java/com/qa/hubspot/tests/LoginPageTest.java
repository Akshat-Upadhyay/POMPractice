package com.qa.hubspot.tests;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.qa.hubspot.base.BasePage;
import com.qa.hubspot.page.HomePage;
import com.qa.hubspot.page.LoginPage;
import com.qa.hubspot.util.AppConstant;


public class LoginPageTest {
	
	WebDriver driver;
	BasePage basePage;
	Properties prop;
	LoginPage loginPage;
	
	@BeforeTest
	public void setup()
	{
		basePage= new BasePage();
		prop = basePage.set_properties();
		String browserName = prop.getProperty("browser");
		driver = basePage.init_Driver(browserName);
		driver.get(prop.getProperty("url"));
		loginPage = new LoginPage(driver);
	}
	
	
	@Test(priority = 1)
	public void verifyLoginPage_TitleTest()
	{
		String title = loginPage.getLoginPageTitle();
		System.out.println("Title of Login page is " +title);
		Assert.assertEquals(title, AppConstant.LOGIN_PAGE_TITLE);
		
	}
	
	@Test(priority = 3)
	public void verifyLoginPage_LoginClickTest()
	{
		HomePage homePage = loginPage.clickLoginPageLogInButton(prop.getProperty("username"), prop.getProperty("password"));
		String title= homePage.getHomePageTitle();
		Assert.assertEquals(title, AppConstant.HOME_PAGE_TITLE);
	}
	
	@Test(priority = 2)
	public void verifyLoginPage_SignUpLinkDisplayTest()
	{
		Assert.assertTrue(loginPage.checkLoginPageSignUpLink());
	}
	
	
	@AfterTest
	public void tearDown()
	{
		driver.quit();
	}
	

}

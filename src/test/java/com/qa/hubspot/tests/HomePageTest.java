package com.qa.hubspot.tests;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.qa.hubspot.base.BasePage;
import com.qa.hubspot.page.HomePage;
import com.qa.hubspot.page.LoginPage;
import com.qa.hubspot.util.AppConstant;

public class HomePageTest {
	
	
	WebDriver driver;
	BasePage basePage;
	Properties prop;
	LoginPage loginPage;
	HomePage homePage;
	
	@BeforeTest
	public void setup() throws InterruptedException
	{
		basePage= new BasePage();
		prop = basePage.set_properties();
		String browserName = prop.getProperty("browser");
		driver = basePage.init_Driver(browserName);
		driver.get(prop.getProperty("url"));
		loginPage = new LoginPage(driver);
		homePage = loginPage.clickLoginPageLogInButton(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@Test(priority = 1)
	public void verifyHomePage_TitleTest()
	{
		String title= homePage.getHomePageTitle();
		System.out.println("Title of the Home Page is " +title);
		Assert.assertEquals(title, AppConstant.HOME_PAGE_TITLE);
	}
	
	
	@Test(priority = 2)
	public void verifyHomePage_HeaderTest()
	{
		String header = homePage.getHomePageHeader();
		System.out.println("Header of the Home Page is " +header);
		Assert.assertEquals(header, AppConstant.HOME_PAGE_HEADER);
	}
	
	
	
	@AfterTest
	public void tearDown()
	{
		driver.quit();
	}

}

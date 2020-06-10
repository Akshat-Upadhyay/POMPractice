package Selenium.Practice;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Zoopla {
	
	
	WebDriver driver;
	By cookieTitle = By.xpath("//h2[text()=' Your cookie preferences ']");
	By cookieButton = By.xpath("//button[text()='Accept all cookies' and @class = 'ui-button-primary ui-cookie-accept-all-medium-large']"); 
	By textField = By.id("search-input-location");
	By search = By.id("search-submit");
	
	@BeforeTest
	public void setup()
	{
		WebDriverManager.chromedriver().setup();
		driver= new ChromeDriver();
		
		driver.get("https://www.zoopla.co.uk/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();
		driver.manage().window().fullscreen();
		
	}
	
	@Test(priority = 1)
	public void siteTest1()
	{
		driver.findElement(cookieButton).click();
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(textField));
	
		driver.findElement(textField).sendKeys("London");
		driver.findElement(search).click();
		
		
		List<WebElement> propertyprice = driver.findElements(By.xpath("//a[@class='listing-results-price text-price']"));
		
		System.out.println("Total number of price tag present on the page :" +propertyprice.size());
		
		for(int i=0;i<propertyprice.size();i++)
		{
			String price = propertyprice.get(i).getText();
			String finalPrice = price.replaceAll("[^0-9]", " ");
			
			System.out.println(finalPrice);	
		}
		
		for(int j=0;j<propertyprice.size();j++)
		{
			
			if(j==0)
			{
				propertyprice.get(j).click();	
			}
		}
			
			String agentname = driver.findElement(By.xpath("//h4[@class='ui-agent__name']")).getText();
			System.out.println("Agent name is : "+agentname);
			
			String num = driver.findElement(By.xpath("//a[@class='ui-link'and @data-track-label='Agent phone number 1']")).getText();
			String agentContactNum = num.replaceAll("[^0-9]","");
			System.out.println("Agent Contact Number is: "+agentContactNum);
			
			
			driver.findElement(By.xpath("//h4[@class='ui-agent__name']")).click();
			
			String agentname2 = driver.findElement(By.xpath("//h1[@class='bottom-half']//b")).getText();
			
			Assert.assertEquals(agentname2, agentname);
			
			
			
			
	}

	
//	@AfterTest
//	public void tearDown()
//	{
//		driver.quit();
//	}

		}

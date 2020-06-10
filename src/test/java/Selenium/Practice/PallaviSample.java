package Selenium.Practice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class PallaviSample {
	WebDriver driver;
	
	@BeforeTest
	public void setup()
	{
		WebDriverManager.chromedriver().setup();
		driver= new ChromeDriver();
		
		driver.get("https://www.cricbuzz.com/cricket-series/2915/ranji-trophy-2019-20/stats");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();
		driver.manage().window().fullscreen();
		
	}
	
	@Test
	public void webTable() throws InterruptedException {
		System.out.println("In webTable method");
		
		//*[@id="seriesStatsTable"]/div/table/tbody/tr[1]/td[2]/a
				//*[@id="seriesStatsTable"]/div/table/tbody/tr[2]/td[2]/a
				//*[@id="seriesStatsTable"]/div/table/tbody/tr[3]/td[2]/a
		
		//*[@id="seriesStatsTable"]/div/table/tbody/tr[1]/td[2]/a
		
		//*[@id="seriesStatsTable"]/div/table/tbody/tr[1]/td[2]/a
		
		//*[@id="seriesStatsTable"]/div/table/tbody/tr[20]/td[2]/a
		
		int rowCount  = driver.findElements(By.xpath("//*[@id=\"seriesStatsTable\"]/div/table//tr")).size()-1;
		System.out.println(rowCount);
		String beforeXpath = "//*[@id='seriesStatsTable']/div/table/tbody/tr[";
		String afterXpath = "]/td[2]/a";
		
		for (int i =1; i<=rowCount; i++) {
			String playerName = driver.findElement(By.xpath(beforeXpath + i + afterXpath)).getText();
			System.out.println(playerName);
			
//			if(playerName.contains("Puneet Bisht")) {
//				//Thread.sleep(6000);
//				driver.findElement(By.xpath(beforeXpath + i + afterXpath)).click();
			}
		}
		
		
	}


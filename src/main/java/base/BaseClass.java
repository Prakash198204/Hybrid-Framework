package base;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import browserFactory.BrowserFactory;
import dataProvider.ConfigReader;

public class BaseClass {
	
	public WebDriver driver;
	
	@BeforeClass
	public void setupBrowser() {
		
		System.out.println("LOG:INFO - Setting up browser");
		//1- Config - Does not suite for crossbrowser 
		driver =BrowserFactory.startBrowser(ConfigReader.getProperty("browser"),ConfigReader.getProperty("url"));
		System.out.println("LOG:INFO - Application is up and running");
	}
	
	@AfterClass
	public void closeBrowser() {
		
		driver.quit();
		System.out.println("LOG:INFO - Closing the browser and application");
	}

}

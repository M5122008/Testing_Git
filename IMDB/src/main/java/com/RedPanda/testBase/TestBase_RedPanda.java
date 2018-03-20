package com.RedPanda.testBase;

import java.util.concurrent.TimeUnit;

//import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestBase_RedPanda{

	public WebDriver driver;
	String browser="firefox";
	String BaseUrl="https://www.imdb.com/";

	public void init() {
		getBrowser(browser);
		getUrl(BaseUrl);
		//String log4jConfPath="log4j.properties";
		//PropertyConfigurator.configure(log4jConfPath);
	}

	public void getBrowser(String browser) {
		if(browser.equalsIgnoreCase("firefox")) {
			//log.info("creating object of:"+browser);
			driver=new FirefoxDriver();
		}
	}
	
	public void getUrl(String BaseUrl) {
		//log.info("Navigating to URL"+BaseUrl);
		driver.get(BaseUrl);
		//driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
	}


}

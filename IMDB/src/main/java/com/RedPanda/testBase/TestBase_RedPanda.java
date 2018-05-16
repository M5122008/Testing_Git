package com.RedPanda.testBase;

import java.util.concurrent.TimeUnit;

//import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.RedPanda.excelReader.Excel_Reader;

public class TestBase_RedPanda{

	public WebDriver driver;
	String browser="firefox";
	String BaseUrl="http://automationpractice.com/index.php";
	Excel_Reader excel;

	public void init() {
		getBrowser(browser);
		getUrl(BaseUrl);
		//String log4jConfPath="log4j.properties";
		//PropertyConfigurator.configure(log4jConfPath);
	}

	public void getBrowser(String browser) {
		if(browser.equalsIgnoreCase("firefox")) {
			//log.info("creating object of:"+browser);
			System.setProperty("webdriver.gecko.driver", "E:\\geckodriver.exe");

			driver=new FirefoxDriver();
		}
	}
	
	public void getUrl(String BaseUrl) {
		//log.info("Navigating to URL"+BaseUrl);
		driver.get(BaseUrl);
		//driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
	}
	
	public String[][] getData(String sheetName,String ExcelName) {
		String path="C:\\Users\\User\\git\\Testing_Git\\IMDB\\src\\main\\java\\com\\RedPanda\\testData\\TestDataProvider.xlsx";
		//String path=System.getProperty("user.dir")+"\\src\\main\\java\\com\\RedPanda\\testData\\"+ExcelName;
		excel=new Excel_Reader(path);
		String[][] data= excel.getDataFromSheet(sheetName,ExcelName);
		return data;
	}


}

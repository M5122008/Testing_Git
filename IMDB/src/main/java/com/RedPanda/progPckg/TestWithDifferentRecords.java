package com.RedPanda.progPckg;

import org.apache.log4j.Logger;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.RedPanda.testBase.*;

public class TestWithDifferentRecords extends TestBase_RedPanda{
	HomePage homepage;
	
	public static final Logger log= Logger.getLogger(TestWithDifferentRecords.class.getName());
	
	@DataProvider(name="loginData")
	public String[][] getTestData() {
		String[][] testRecords=getData("testData","TestDataProvider.xlsx");
		return testRecords;
	}
	
	@BeforeClass
	public void setUp() {
		init();
	}
	
	@Test(dataProvider="loginData")
	public void testLogin(String uName,String passwd,String runmode) {
		log.info("-----starting testwithdifferent records--------");
		homepage=new HomePage(driver);
		homepage.LoginToApplication(uName,passwd,runmode);
			
		log.info("------ending testwithdifferent records------------");
		
		
	}
	
	@AfterClass
	public void endTest() {
		driver.close();
	}
	
	
	
}

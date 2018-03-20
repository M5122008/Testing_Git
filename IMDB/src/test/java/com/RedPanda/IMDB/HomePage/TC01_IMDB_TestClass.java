package com.RedPanda.IMDB.HomePage;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.RedPanda.IMDB.IMDB_HomePage;
import com.RedPanda.testBase.TestBase_RedPanda;
//import com.RedPanda.testBase.Te;

public class TC01_IMDB_TestClass extends TestBase_RedPanda{
	IMDB_HomePage IM;
	
	@BeforeTest
	public void setUp() {
		init();
		
	}

	@Test	
	public void IMDB_Rating() {
		//log.info("---------Start Test-------");
			IM = new IMDB_HomePage(driver);
			IM.LoginToApplication();
			//Assert.assertEquals(home.getInvalidText(),"Invalid email address.");
		//log.info("---------Finish Test-------");
	}
	
	@AfterClass
	public void endTest() {
		driver.close();
		
	}

}

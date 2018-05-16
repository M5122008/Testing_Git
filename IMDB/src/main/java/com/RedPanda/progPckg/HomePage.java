package com.RedPanda.progPckg;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
public class HomePage {
	public static final Logger log= Logger.getLogger(HomePage.class.getName());
	//WebDriver driver;
	
	@FindBy(xpath="//*[@id='header']/div[2]/div/div/nav/div[1]/a")
	WebElement SignIn;
	
	@FindBy(xpath="//*[@id='email']")
	WebElement loginEmail;
	
	@FindBy(xpath="//*[@id='passwd']")
	WebElement pwd;
	  
	@FindBy(xpath="//*[@id='SubmitLogin']")
	WebElement SubmitButton;
	
	@FindBy(xpath="//*[@id='center_column']/div[1]/ol/li")
	WebElement AuthenticationFail;
	
	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
	
	public void LoginToApplication(String uName,String passwd,String runmode) {
		log.info("click on sign in button"+SignIn.toString());
		SignIn.click();
		log.info("Enter Email"+loginEmail.toString());
		loginEmail.sendKeys(uName);
		log.info("Enter password"+pwd.toString());
		pwd.sendKeys(passwd);
		log.info("click on submit button"+SubmitButton.toString());
		SubmitButton.click();
	}
	
	public String getInvalidText() {
		log.info("error message is"+AuthenticationFail.getText());
		return AuthenticationFail.getText();
	}
	
}

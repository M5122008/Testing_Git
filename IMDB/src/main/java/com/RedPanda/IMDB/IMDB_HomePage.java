package com.RedPanda.IMDB;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
//mport org.openqa.selenium.By;

public class IMDB_HomePage {
	
	@FindBy(xpath=".//*[@id='main']/div[11]/span/div/div/div[1]/div[1]/a/div")
	WebElement Top250;
	
	public IMDB_HomePage(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
	
	public void LoginToApplication() {
		Top250.click();
	}
		
}

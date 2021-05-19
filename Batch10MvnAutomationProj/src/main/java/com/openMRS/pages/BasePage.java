package com.openMRS.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class BasePage {
	
	public WebDriver driver = null;
	
	public BasePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	/**
	 * To enter Text with parameters Web element and String
	 **/
	public void enterText(WebElement ele, String textToPass) {
		ele.clear();
		ele.sendKeys(textToPass);
	}
	
	/**
	 * To click with parameters Web element
	 **/
	public void click(WebElement ele) {
		ele.click();
	}

}

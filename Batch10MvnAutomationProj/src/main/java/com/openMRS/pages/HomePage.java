package com.openMRS.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {
	
	public HomePage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	public String HOMEPAGE_TITLE = "My account - My Store";
	
	@FindBy(css="a.logout")
	public WebElement btnLogout;

}

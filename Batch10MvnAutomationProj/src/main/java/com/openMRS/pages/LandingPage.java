package com.openMRS.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.openMRS.pages.BasePage;

public class LandingPage extends BasePage {
	
	public final String LANDINGPAGE_TITLE = "My Store";

	public LandingPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	@FindBy(xpath="//a[@class='login']")
	private WebElement lnkLogin;
	
	public void navToLoginPage() {
		click(lnkLogin);
	}

}

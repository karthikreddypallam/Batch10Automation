package com.openMRS.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {
	

	public LoginPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	public final String LOGINPAGE_TITLE = "Login - My Store";

	private String user = "kwebdriver@gmail.com";
	private String pass = "test123";
	
	@FindBy(xpath="//input[@id='email']")
	private WebElement txtFld_userName;
	
	@FindBy(xpath="//input[@id='passwd']")
	private WebElement txtFld_password;
	
	@FindBy(css="button#SubmitLogin")
	private WebElement btnLogin;
	
	
	public void login() {
		enterText(txtFld_userName, user);
		enterText(txtFld_password, pass);
		click(btnLogin);
	}
	
	public void login(String user, String pass) {
		enterText(txtFld_userName, user);
		enterText(txtFld_password, pass);
		click(btnLogin);
	}

}

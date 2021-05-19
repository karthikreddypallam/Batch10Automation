package com.openMRS.tests;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.openMRS.pages.BasePage;
import com.openMRS.pages.HomePage;
import com.openMRS.pages.LandingPage;
import com.openMRS.pages.LoginPage;

import Utils.Retry;


//@Listeners(ListenersTest.class)
public class LoginTest extends BaseTest {
	
	String validUser = "kwebdriver@gmail.com";
	String pass = "test123";
	String invalidUser = "test@gmail.com";
	
	@BeforeMethod
	public void initPages(ITestResult result) {
		test = reports.createTest(result.getMethod().getMethodName());
		bp = new BasePage(driver);
		login = new LoginPage(driver);
		home = new HomePage(driver);
		landPage = new LandingPage(driver);
	}
	
	@Test(description="Verify login passing valid credentials",testName="Login with Valid Credentials")
	public void testValidLogin() throws IOException {

		login.login(validUser, pass);
		test.log(Status.INFO, "Entered User Name and Password");
		test.log(Status.INFO, "clicked on SignIn Button");
		assertEquals(driver.getTitle(), home.HOMEPAGE_TITLE);
		assertTrue(home.btnLogout.isDisplayed());

	}
	
//	@Test(description="Verify Invalid login with valid credentials", retryAnalyzer=Retry.class)
	@Test(description="Verify Invalid login with valid credentials")
	public void testInvalidLogin() throws IOException {
		landPage.navToLoginPage();
		assertEquals(getTitle(), login.LOGINPAGE_TITLE);
		login.login(invalidUser, pass);
		assertEquals(driver.getTitle(), home.HOMEPAGE_TITLE);
		assertTrue(home.btnLogout.isDisplayed());
	}
	
	@AfterMethod
	public void afterMethod(ITestResult result) {
		
		if(result.getStatus()==ITestResult.SUCCESS) {
			test.log(Status.PASS, "Navigated to the Home Page");
		}else if(result.getStatus()==ITestResult.FAILURE) {
			test.log(Status.FAIL, "Failed to Navigate to the Home Page");
			getScreenshot(result.getMethod().getMethodName());
		}
		
		
	}

}

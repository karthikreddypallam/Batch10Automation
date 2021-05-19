package com.openMRS.tests;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.openMRS.pages.BasePage;
import com.openMRS.pages.HomePage;
import com.openMRS.pages.LandingPage;
import com.openMRS.pages.LoginPage;

import Utils.ConfigReader;
import Utils.IConstants;

public class BaseTest {
	
	ExtentHtmlReporter htmlReporter = null;
	ExtentReports reports = null;
	ExtentTest test = null;
	
	public WebDriver driver = null;
	ConfigReader cfgReader = null;
	
	BasePage bp = null;
	LoginPage login = null;
	HomePage home = null;
	LandingPage landPage= null;
	
	@BeforeSuite
	public void beforeSuite() {
		htmlReporter = new ExtentHtmlReporter("TestReport.html");
		reports = new ExtentReports();
		reports.attachReporter(htmlReporter);
	}
	
	@BeforeTest(enabled=false)
	public void initSuite() {
		cfgReader = new ConfigReader();
		cfgReader.readConfig();
	}
	
	@BeforeClass
	public void initTest() throws MalformedURLException {
		cfgReader = new ConfigReader();
		cfgReader.readConfig();
//		DesiredCapabilities dc = null;
//		
//		if(cfgReader.getBrowser().equalsIgnoreCase("chrome")) {
//			dc = DesiredCapabilities.chrome();	
//			dc.setBrowserName("chrome");
//			dc.setPlatform(Platform.ANY);
//		}else {
//			dc = DesiredCapabilities.firefox();	
//			dc.setBrowserName("firefox");
//			dc.setPlatform(Platform.ANY);
//		}
//
//		driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), dc);
		
		launchBrowser(cfgReader.getOS(), cfgReader.getBrowser());
		driver.get(cfgReader.getURL());
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}
	
	public void launchBrowser(String os, String browser) {
		if(browser.equalsIgnoreCase("chrome"))
			launchChrome(os);
		else
			launchFirefox(os);
	}
	
	public void launchChrome(String os) {
		if(os.equalsIgnoreCase("mac"))
			System.setProperty("webdriver.chrome.driver", IConstants.chromeDriverPathMAC);
		else
			System.setProperty("webdriver.chrome.driver", IConstants.chromeDriverPathWin10);
		
		driver = new ChromeDriver();
	}
	
	public void launchFirefox(String os) {
		if(os.equalsIgnoreCase("mac"))
			System.setProperty("webdriver.gecko.driver", IConstants.geckoDriverPathMAC);
		else
			System.setProperty("webdriver.gecko.driver", IConstants.geckoDriverPathWin10);
		
		driver = new FirefoxDriver();
	}
	
	// validations title, url,element,text
	
	public String getTitle() {
		return driver.getTitle();
	}
	
	@AfterClass
	public void quit() {
		driver.close();
	}
	
	@AfterSuite
	public void closeReports() {
		reports.flush();
	}
	
	public void getScreenshot(String screenshot) {
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(src, new File("/Users/karthikreddy/Selenium/"+screenshot+".png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

}

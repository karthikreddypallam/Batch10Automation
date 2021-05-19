package com.openMRS.tests;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.openMRS.pages.BasePage;
import com.openMRS.pages.LandingPage;

public class LandingPageTest extends BaseTest {
	
	@BeforeMethod
	public void initPages() {
		bp = new BasePage(driver);
		landPage = new LandingPage(driver);
	}
	
	@Test
	public void testNavToLandingPage() {
		assertEquals(getTitle(), landPage.LANDINGPAGE_TITLE);
	}

}

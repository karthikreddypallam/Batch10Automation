package Batch10.Batch10MvnAutomationProj;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class NewTest {
	
  @Test(invocationCount=3, invocationTimeOut = 3000)
  public void loginTest() throws InterruptedException {
	  System.out.println("Login Test");
	  Thread.sleep(1200);
	//  assertTrue(false);
  }
  
  @Test(dependsOnMethods = {"loginTest"}, testName="abc",alwaysRun=true)
  public void homeTest() {
	  System.out.println("Home Test");
  }
  
  @Test(expectedExceptions = { IOException.class })
  public void test3() throws IOException {
	  String test = "pass";
	 if(test.equals("pass")) {
		 System.out.println("Passed");
	 }else {
		 throw new IOException();
	 }
  }
  
  @Test(expectedExceptions = { Exception.class })
  public void exceptionTestOne() throws Exception {
      throw new Exception();
  }
  
  
  @BeforeMethod
  public void beforeMethod() {
	  System.out.println("BeforeMethod");

  }

  @AfterMethod
  public void afterMethod() {
	  System.out.println("AfterMethod");

  }

  @BeforeClass
  public void beforeClass() {
	  System.out.println("BeforeClass");

  }

  @AfterClass
  public void afterClass() {
	  System.out.println("@AfterClass");

  }

  @BeforeTest
  public void beforeTest() {
	  System.out.println("@BeforeTest");

  }

  @AfterTest
  public void afterTest() {
	  System.out.println("@AfterTest");

  }

  @BeforeSuite
  public void beforeSuite() {
	  System.out.println("@BeforeSuite");

  }

  @AfterSuite
  public void afterSuite() {
	  System.out.println("@AfterSuite");

  }

}

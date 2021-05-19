package Batch10.Batch10MvnAutomationProj;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;


public class Login {
	
	@Parameters({"browser","env"})
	@BeforeClass
	public void launchBrowser(String browser,String env) {
		if(browser.equalsIgnoreCase("chrome")) {
			// logic for launching chrome browser
			System.out.println("Chrome Browser Launched");
			environment(env);
		}else if(browser.equalsIgnoreCase("firefox")) {
			// logic for launching firefox browser
			System.out.println("Firefox Browser Launched");
			environment(env);
		}else {
			// logic for launching ie browser
			System.out.println("IE Browser Launched");
			environment(env);
		}
	}
	
	 @Test(priority=0, groups = {"smoke","sanity"})
	  public void testValidLogin() {
		  System.out.println("Test Valid Login ");
		  String expTitle = "Home Page";
		  String actTitle = "Home Page";
		  assertEquals(actTitle, expTitle);
		  System.out.println("Title Validation success");
		  assertTrue(9>8);
		  System.out.println("True1 Validation success");
		  assertFalse(7>6);
		  System.out.println("True2 Validation success");
	  }
	 
	 @Test(priority=1,groups = {"sanity"})
	  public void testInvalidLogin() {
		 SoftAssert sa = new SoftAssert();
		  System.out.println("Test Invalid Login ");
		  sa.assertEquals("Home", "Login");
		  System.out.println("Title Validation success");
		  sa.assertTrue(9>8);
		  System.out.println("True1 Validation success");
		  sa.assertFalse(7>6);
		  System.out.println("True2 Validation success");
		  sa.assertAll();
	  }
	 
	 @Test(enabled=true,priority=2,groups = {"sanity"})
	  public void testEmptyLogin() {
		  System.out.println("Test Empty Login ");
	  }
	 
	 public void environment(String env)
	 {
		 if(env.equalsIgnoreCase("uat"))
				System.out.println("https://uat.amazon.com");
			else
				System.out.println("https://beta.amazon.com");
	 }
}

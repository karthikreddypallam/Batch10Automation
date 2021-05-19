package Batch10.Batch10MvnAutomationProj;

import org.testng.annotations.Test;

public class Register {
	
	 @Test(groups = {"smoke","sanity"})
	  public void testRegisterWithSubmit() {
		  System.out.println("User should be Registered");
	  }
	 
	 @Test(groups = {"sanity"})
	  public void testRegisterWithCancel() {
		  System.out.println("User shouldn't be Registered");
	  }
	 
	

}

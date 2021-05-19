package com.testNG.Demo;
import org.testng.annotations.Test;

public class DependsOnGroupsDemo {
	
	
	@Test(groups = {"2 wheeler"})
	public void cycle() {
		System.out.println("Cycle");
	}
	
	@Test(groups = {"2 wheeler"})
	public void bike() {
		System.out.println("Bike");
	}
	
	@Test(groups = {"4 wheeler"})
	public void Car() {
		System.out.println("Car");
	}
	
	@Test(groups = {"6 wheeler"})
	public void Truck() {
		System.out.println("Truck");
	}
	
	@Test(groups = {"4 wheeler"})
	public void Van() {
		System.out.println("Van");
	}
	
	@Test(groups = {"6 wheeler"})
	public void Lorry() {
		System.out.println("Lorry");
	}
	
	@Test(dependsOnGroups = {"2 wheeler"})
	public void TwoWheelers() {
		System.out.println("Two Wheelers");
	}
	
	@Test(dependsOnGroups = {"4 wheeler"})
	public void FourWheelers() {
		System.out.println("Four Wheelers");
	}
	
	@Test(dependsOnGroups = {"6 wheeler"})
	public void SixWheelers() {
		System.out.println("Six Wheelers");
	}
	
	@Test(timeOut = 5000)
	public void timeoutTest() throws InterruptedException {
		Thread.sleep(4000);
	}

}

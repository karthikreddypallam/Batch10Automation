package com.testNG.Demo;
import org.testng.annotations.Test;

public class DependsOnMethodsDemo {
	
	
	@Test(dependsOnMethods = {"testEngineStart"})
	public void testAccelarate() {
		System.out.println("Accelarte");
	}
	
	@Test(dependsOnMethods = {"testAccelarate"})
	public void testBrake() {
		System.out.println("Brake");
	}
	
	@Test
	public void testOpenCar() {
		System.out.println("Check Key");
	}
	
	@Test(dependsOnMethods = {"testOpenCar"})
	public void testEngineStart() {
		System.out.println("Engine Started");
	}

}

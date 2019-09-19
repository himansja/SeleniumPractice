package testNG_scenarios_dummytestcases;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestDummyGrouping1 {

	
	@BeforeMethod
	public void beforeMethod() {
		System.out.println("Before Method of group 1");
	}

	@AfterMethod
	public void afterMethod() {
		System.out.println("After Method of group 1");
	}
	@BeforeClass
	public void beforeClass() {
		System.out.println("Before Class of group 1");
	}

	@AfterClass
	public void afterClass() {
		System.out.println("After Class of group 1");
	}
	
	
	@Test(groups= {"sanity"})
	public void methodOne() {
		System.out.println("Method of sanity groups 1");
	}
	@Test(groups= {"sanity"})
	public void methodTwo() {
		System.out.println("Method of sanity groups 2");
	}
	@Test(groups= {"sanity", "Regression"})
	public void methodThree() {
		System.out.println("Method of sanity and regression groups 3");
	}
	
}

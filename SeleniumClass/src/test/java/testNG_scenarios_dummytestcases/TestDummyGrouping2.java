package testNG_scenarios_dummytestcases;

import org.testng.annotations.Test;

public class TestDummyGrouping2 {

	
	@Test(groups= {"Regression"})
	public void method1() {
		System.out.println("Method of regression groups 1");
	}
	@Test(groups= {"Regression"})
	public void method2() {
		System.out.println("Method of regression groups 2");
	}
	@Test(groups= {"sanity", "Regression"})
	public void method3() {
		System.out.println("Method of regression and sanity groups 3");
	}
}

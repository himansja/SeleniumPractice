package testNG_scenarios_dummytestcases;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

public class InvokationCount {

	
	@Test(invocationCount =3)   
	public void invocationFail() {
		System.out.println("fail method 3 times");
		assertEquals(true, false);
	}
	
	@Test(invocationCount =2)   
	public void invokationPlan() {
		System.out.println("pass method 3 times");
		
	}
	
}

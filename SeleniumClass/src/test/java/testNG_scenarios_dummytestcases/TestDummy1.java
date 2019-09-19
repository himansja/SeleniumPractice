package testNG_scenarios_dummytestcases;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;


public class TestDummy1 {

	/**Execution priority
	 * 1. By default priority is zero
	 * 2. Execution id done in alphabetical order if priority is not set 
	 * 3. In Alphabetical first priority is Upper case and then LowerCase
	 * 4. DependsOnmethods is executed after all the priority methods get executed*/
	int i=0, k=0;
	SoftAssert softAssert = new SoftAssert();

	@Test(enabled = false)
	public void animal() {
		System.out.println("animalmenthod");
	}

	@Test(dependsOnMethods = {"dog"})
	public void cat() {  /* by default priority is zero 
							and then the order of execution is decided in alphabetical order*/
		System.out.println("cat method");
	}

	@Test(priority=1,invocationCount = 3,successPercentage = 80)   /* after priority 0, execution comes to next priority */
	public void plane() {
		System.out.println("plane method 3 times" + i++);
		//assertEquals(true, false);
		if(i==1||i==2) {
			Assert.assertEquals(true, false); // Hard Assertion
			
		}
		else {
				Assert.assertEquals(true, true);
			
		}
		
	}
	@Test(priority=2)
	public void boy() {
		System.out.println("boy method");
	}

	@Test
	public void dog() {
		System.out.println("dog method");
	}

	@Test
	public void skipMethod() {
		throw new SkipException("i am skipping this method");
	}

	@Test(invocationCount = 3)
	public void assertionMethod() {
		k++;
		if(k==1||k==2) {
			
			//Assert.assertEquals(true, false);
			softAssert.assertEquals(true, false);
			System.out.println("condition fail");
		}
		else {
			//Assert.assertEquals(true, true);
			softAssert.assertEquals(true, true);
			System.out.println("condition pass");
			}
		softAssert.assertAll();
	}



	@BeforeMethod
	public void beforeMethod() {
		System.out.println("Before Method");
	}

	@AfterMethod
	public void afterMethod() {
		System.out.println("After Method");
	}
	@BeforeClass
	public void beforeClass() {
		System.out.println("Before Class");
	}

	@AfterClass
	public void afterClass() {
		System.out.println("After Class");
	}

}
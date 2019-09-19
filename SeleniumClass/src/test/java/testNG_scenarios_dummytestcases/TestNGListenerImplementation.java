package testNG_scenarios_dummytestcases;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;


//Listener execution will only start from testNG.xml
public class TestNGListenerImplementation implements ITestListener {

	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		//OnStart method is called when any @Test starts. 
		System.out.println("method executed on test start");
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		// method is called when your @Test is success
		System.out.println("Method executed on success and pass");

	}

	@Override
	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		// method called when your @test is failed
		System.out.println("method executed on failed");
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		System.out.println("My test cases skipped");

	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		System.out.println("on test fail within success message method invoked ");

	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		//Method is called when your TestNg test starts.
		System.out.println("Method executed on test from testnG XML");
	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		//Method is called when all test are executed 
		System.out.println("Method executed on all test finish");
	}

}

package com.sahel.booking.utilities;


import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.sahel.booking.base.DriverFactory;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ExtentTestNGListeners implements ITestListener {

    private ExtentTest test;


    @Override
    public void onStart(ITestContext context) {
        // Create a new test instance in the report
        test = DriverFactory.getReport().createTest(context.getName());
        // Assign category, author, and device information
    }


    /**
     * Invoked each time before a test will be invoked. The <code>ITestResult</code> is only partially
     * filled with the references to class, method, start millis and status.
     *
     * @param result the partially filled <code>ITestResult</code>
     * @see ITestResult#STARTED
     */
    @Override
    public void onTestStart(ITestResult result) {
        // Log test start in the report
        test.log(Status.INFO, "Test started: " + result.getName());
    }

    /**
     * Invoked each time a test succeeds.
     *
     * @param result <code>ITestResult</code> containing information about the run test
     * @see ITestResult#SUCCESS
     */
    @Override
    public void onTestSuccess(ITestResult result) {
        // Log test success in the report
        test.log(Status.PASS, "Test passed: " + result.getName());
    }

    /**
     * Invoked each time a test fails.
     *
     * @param result <code>ITestResult</code> containing information about the run test
     * @see ITestResult#FAILURE
     */
    @Override
    public void onTestFailure(ITestResult result) {
        //log test success in the report
        test.log(Status.FAIL, "Test failed: " + result.getName());
    }

    @Override
    public void onFinish(ITestContext context) {
        // Flush the report at the end of the suite
        WebDriverUtils.getReport().flush();
    }


}

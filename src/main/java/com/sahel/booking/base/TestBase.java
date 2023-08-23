package com.sahel.booking.base;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.sahel.booking.utilities.WebDriverUtils;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.io.IOException;


public class TestBase extends WebDriverUtils {
    protected static ExtentTest test;

    @BeforeSuite
    public void setUpReporting() {
        test = WebDriverUtils.getReport().createTest(getClass().getSimpleName());
    }

//    @BeforeMethod
//    public void launchTests() throws IOException {
//        super.openBrowser();
//    }

    /**
     * creates the extent report for us
     * @param result extent report
     */
    @AfterMethod
    public void extentResults(ITestResult result) {
        // Log test status and details
        if (result.getStatus() == ITestResult.FAILURE) {
            test.log(Status.FAIL, "Test failed: " + result.getName());
            test.log(Status.FAIL, result.getThrowable()); // Log exception details
        } else if (result.getStatus() == ITestResult.SUCCESS) {
            test.log(Status.PASS, "Test passed: " + result.getName());
        } else if (result.getStatus() == ITestResult.SKIP) {
            test.log(Status.SKIP, "Test skipped: " + result.getName());
        }
        // Close WebDriver and do other teardown steps
    }

    /**
     * quits the browser
     */
    @AfterMethod
    public void tearDown() {
        super.quitBrowser();
    }


}

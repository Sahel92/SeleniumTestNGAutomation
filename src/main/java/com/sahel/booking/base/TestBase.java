package com.sahel.booking.base;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.sahel.booking.utilities.WebDriverUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.io.IOException;


public class TestBase extends WebDriverUtils {
    protected static ExtentTest test;
    private static final String TEST_CATEGORY = "Test Suite";
    private static final String TEST_AUTHOR = "Sahel";
    private static final String TEST_DEVICE = "Windows 11 PC,  Chrome Browser v-116";
    protected static final Logger logger = LogManager.getLogger(TestBase.class);

    @BeforeMethod
    public void launchTests() throws IOException {
        super.openBrowser();
    }

    /**
     * Close WebDriver and do other teardown steps
     */
    @AfterMethod
    public void tearDown() {
        super.quitBrowser();
    }


    @BeforeSuite
    public void setUpReporting() {
        //Load Log4j2 configuration
        System.setProperty("log4j.configurationFile", "src/main/resources/log4j2.xml");
        test = WebDriverUtils.getReport().createTest(getClass().getSimpleName());
        test.assignCategory(TEST_CATEGORY);
        test.assignAuthor(TEST_AUTHOR);
        test.assignDevice(TEST_DEVICE);
    }

    /**
     * creates the extent report for us
     *
     * @param result extent report
     */
    @AfterMethod
    public void extentResults(ITestResult result) {
        String testName = result.getName();
        String methodName = result.getMethod().getMethodName();
        String className = result.getTestClass().getName();
        String status = getTestStatus(result.getStatus());
        // Log test status and details
        if (result.getStatus() == ITestResult.FAILURE) {
            String errorMessage = result.getThrowable().getMessage();
            logger.error("Test Failed: {}", methodName);
            logger.error("Error Message: {}", errorMessage);
            test.log(Status.FAIL, "Test Failed: " + methodName);
            test.log(Status.FAIL, "Error Message: " + errorMessage);
        } else if (result.getStatus() == ITestResult.SUCCESS) {
            logger.info("Test Passed: {}", methodName);
            test.log(Status.PASS, "Test Passed: " + methodName);
        } else if (result.getStatus() == ITestResult.SKIP) {
            logger.info("Test Skipped: {}", methodName);
            test.log(Status.SKIP, "Test Skipped: " + methodName);
        }

        // Add more detailed information to the report
        test.info("Test Class: " + className);
        test.info("Test Name: " + testName);
        test.info("Test Status: " + status);

    }

    // Helper method to convert test status to readable text
    private String getTestStatus(int status) {
        return switch (status) {
            case ITestResult.FAILURE -> "Failed";
            case ITestResult.SUCCESS -> "Passed";
            case ITestResult.SKIP -> "Skipped";
            default -> "Unknown";
        };
    }


}

package com.sahel.booking.utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.sahel.booking.base.DriverFactory;

public class WebDriverUtils extends DriverFactory {

    private static ExtentReports extent;

    public static ExtentReports getReport() {
        if (extent == null) {
            ExtentSparkReporter spark = new ExtentSparkReporter("src/test/resources/extent-reports");
            extent = new ExtentReports();
            extent.attachReporter(spark);
        }
        return extent;
    }


}

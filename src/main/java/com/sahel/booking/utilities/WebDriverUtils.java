package com.sahel.booking.utilities;


import com.aventstack.extentreports.ExtentReports;

import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Protocol;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.sahel.booking.base.DriverFactory;

public class WebDriverUtils extends DriverFactory {
    private static ExtentReports extent;

    public static ExtentReports getReport() {
        if (extent == null) {
            ExtentSparkReporter spark = new ExtentSparkReporter("src/test/resources/extent-reports");
            spark.config().setTheme(Theme.DARK);
            spark.config().setDocumentTitle("Booking Automation Testing Framework");
            spark.config().setReportName("Test Result's");
            spark.config().setProtocol(Protocol.HTTP);
            spark.config().enableOfflineMode(true);
            spark.config().setTimelineEnabled(false);
            extent = new ExtentReports();
            extent.attachReporter(spark);
        }
        return extent;
    }


}

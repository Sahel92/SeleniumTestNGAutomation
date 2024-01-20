package com.sahel.booking.base;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Protocol;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.sahel.booking.browsers.ChromeBrowser;
import com.sahel.booking.browsers.EdgeBrowser;
import com.sahel.booking.browsers.FireFoxBrowser;
import lombok.Getter;
import org.apache.commons.io.IOIndexedException;
import org.openqa.selenium.WebDriver;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.time.temporal.ChronoUnit;
import java.util.Properties;

/**
 * Factory class to initialize WebDriver and ExtentReports
 */

@Getter
public class DriverFactory {
    private WebDriver driver;
    private static ExtentReports extentReports;
    private static final String EXTENT_REPORT_PATH = "src/test/resources/extent-reports";


    public static ExtentReports getReport() {
        if (extentReports == null) {
            ExtentSparkReporter spark = new ExtentSparkReporter(EXTENT_REPORT_PATH);
            spark.config().setTheme(Theme.DARK);
            spark.config().setDocumentTitle("Booking Automation Testing Framework");
            spark.config().setReportName("Test Result's");
            spark.config().setProtocol(Protocol.HTTP);
            spark.config().enableOfflineMode(true);
            spark.config().setTimelineEnabled(false);
            extentReports = new ExtentReports();
            extentReports.attachReporter(spark);
        }
        return extentReports;
    }

    private Properties loadProperties() throws IOException {
        Properties properties = new Properties();
        String propertiesFilePath = System.getProperty("user.dir") + "/src/main/resources/qa_env.properties";

        try (FileInputStream fileInputStream = getFileInput(propertiesFilePath)) {
            properties.load(fileInputStream);
        } catch (FileNotFoundException e) {
            throw new FileNotFoundException("Properties file is not on this path : " + propertiesFilePath + " , check the location and try again.");
        } catch (IOIndexedException e) {
            throw new IOException("Error while loading properties from file : " + propertiesFilePath, e);
        }
        properties.load(getFileInput(propertiesFilePath));
        return properties;
    }


    public static FileInputStream getFileInput(String filepath) throws FileNotFoundException {
        try {
            return new FileInputStream(filepath);
        } catch (FileNotFoundException e) {
            throw new FileNotFoundException("The file could not be found on this path : " + filepath);
        }
    }

    private String getProperty(String propertyKey) throws IOException {
        try {
            return loadProperties().getProperty(propertyKey);
        } catch (IOException e) {
            throw new IOException("Error loading the properties, check the location of the file again");
        }
    }

    public void openBrowser() throws IOException {
        String browser = this.getProperty("browser");
        String url = this.getProperty("url");
        String headless = this.getProperty("headless");
        driver = createWebDriver(browser, headless);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.of(10, ChronoUnit.SECONDS));
        driver.get(url);
    }


    private WebDriver createWebDriver(String browser, String headless) {
        switch (browser.toLowerCase()) {
            case "chrome" -> driver = ChromeBrowser.createChromeDriver(headless);
            case "firefox" -> driver = FireFoxBrowser.createFireFoxDriver(headless);
            case "edge" -> driver = EdgeBrowser.createEdgeDriver(headless);
            default -> throw new IllegalArgumentException("Unsupported browser");
        }
        return DriverFactory.this.driver;
    }


    public void quitBrowser() {
        if (driver != null) {
            driver.quit();
        }
    }


}

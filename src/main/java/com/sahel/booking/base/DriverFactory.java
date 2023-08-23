package com.sahel.booking.base;

import com.sahel.booking.Browsers.ChromeBrowser;
import com.sahel.booking.Browsers.EdgeBrowser;
import com.sahel.booking.Browsers.FireFoxBrowser;
import org.apache.commons.io.IOIndexedException;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.time.temporal.ChronoUnit;
import java.util.Properties;


public class DriverFactory {
    private static WebDriver driver;

    /**
     * @return WebDriver
     */
    public WebDriver getDriver() {
        return driver;
    }

    /**
     * Loads and returns a Properties object from a specified properties file.
     *
     * @return A Properties object containing the loaded properties.
     * @throws IOException If an I/O error occurs while reading the properties file.
     */
    private Properties loadProperties() throws IOException {
        Properties properties = new Properties();
        String propertiesFilePath = System.getProperty(("user.dir") + "/src/main/resources/qa_env.properties");

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

    /**
     * Retrieves an input stream for reading files.
     *
     * @param filepath The path to the file.
     * @return An input stream for the specified file.
     * @throws FileNotFoundException If the file at the given path is not found.
     */
    public static FileInputStream getFileInput(String filepath) throws FileNotFoundException {
        try {
            return new FileInputStream(new File(filepath));
        } catch (FileNotFoundException e) {
            throw new FileNotFoundException("The file could not be found on this path : " + filepath);
        }
    }

    /**
     * Retrieves the value of a property from the properties file.
     *
     * @param propertyKey-Key The key of the property to retrieve.
     * @return The value of the specified property.
     * @throws IOException If an I/O error occurs while loading the properties file.
     */
    private String getProperty(String propertyKey) throws IOException {
        try {
            return loadProperties().getProperty(propertyKey);
        } catch (IOException e) {
            throw new IOException("Error loading the properties, check the location of the file again");
        }
    }

    /**
     * Opens a web browser based on the properties provided.
     *
     * @throws IOException If an I/O error occurs while reading properties.
     */
    public void openBrowser() throws IOException {
        String browser = this.getProperty("browser");
        String url = this.getProperty("url");
        String headless = this.getProperty("headless");
        driver = createWebDriver(browser, headless);
        driver.get(url);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.of(10, ChronoUnit.SECONDS));
    }

    /**
     * Creates and returns a WebDriver instance based on the chosen browser and headless mode.
     *
     * @param browser  The name of the browser (e.g., "chrome", "firefox", "edge").
     * @param headless Whether to run the browser in headless mode ("true" or "false").
     * @return A WebDriver instance for the specified browser and mode.
     * @throws IllegalArgumentException If an unsupported browser name is provided.
     */
    private static WebDriver createWebDriver(String browser, String headless) {
        switch (browser.toLowerCase()) {
            case "chrome" -> driver = ChromeBrowser.createChromeDriver(headless);
            case "firefox" -> driver = FireFoxBrowser.createFireFoxDriver(headless);
            case "edge" -> driver = EdgeBrowser.createEdgeDriver(headless);
            default -> throw new IllegalArgumentException("Unsupported browser");
        }
        return driver;
    }

    /**
     * Quits the current instance of WebDriver if it is open.
     */
    public void quitBrowser() {
        if (driver != null) {
            driver.quit();
        }
    }


}

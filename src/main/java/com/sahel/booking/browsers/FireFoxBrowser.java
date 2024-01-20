package com.sahel.booking.browsers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class FireFoxBrowser {

    public static WebDriver createFireFoxDriver(String headless) {
        FirefoxOptions firefoxOptions = new FirefoxOptions();
        if ("true".equalsIgnoreCase(headless)) {
            firefoxOptions.addArguments("--headless");
        }
        return new FirefoxDriver(firefoxOptions);
    }
}

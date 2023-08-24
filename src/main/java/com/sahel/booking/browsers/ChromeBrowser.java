package com.sahel.booking.browsers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class ChromeBrowser {

    public static WebDriver createChromeDriver(String headless) {
        ChromeOptions chromeOptions = new ChromeOptions();
        if ("true".equalsIgnoreCase(headless)) {
            chromeOptions.addArguments("--headless");
        }
        return new ChromeDriver(chromeOptions);

    }


}

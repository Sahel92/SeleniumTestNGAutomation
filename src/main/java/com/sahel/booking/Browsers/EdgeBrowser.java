package com.sahel.booking.Browsers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

public class EdgeBrowser {

    public static WebDriver createEdgeDriver(String headless) {
        EdgeOptions edgeOptions = new EdgeOptions();
        if ("true".equalsIgnoreCase(headless)) {
            edgeOptions.addArguments("--headless");
        }
        return new EdgeDriver(edgeOptions);
    }
}

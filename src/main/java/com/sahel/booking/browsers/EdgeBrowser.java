package com.sahel.booking.browsers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

public class EdgeBrowser {

    public static WebDriver createEdgeDriver(String headless) {
        EdgeOptions edgeOptions = new EdgeOptions();
        if ("true".equalsIgnoreCase(headless)) {
         //   edgeOptions.addArguments("--no-sandbox");
        //    edgeOptions.addArguments("--disable-dev-shm-usage");
            edgeOptions.addArguments("--headless");
        }
        return new EdgeDriver(edgeOptions);
    }
}

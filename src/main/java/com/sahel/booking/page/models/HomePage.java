package com.sahel.booking.page.models;

import com.sahel.booking.utilities.WebDriverUtils;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends WebDriverUtils {

    public HomePage(){
        PageFactory.initElements(getDriver(), this);
    }


}

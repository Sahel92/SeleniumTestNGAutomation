package com.sahel.booking.page.models;

import com.sahel.booking.utilities.WebDriverUtils;
import org.openqa.selenium.support.PageFactory;

public class SignInPage extends WebDriverUtils {

    public SignInPage(){
        PageFactory.initElements(getDriver(), this);
    }




}

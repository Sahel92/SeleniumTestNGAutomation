package com.sahel.booking.page.models;

import com.sahel.booking.utilities.WebDriverUtils;
import org.checkerframework.checker.signature.qual.FieldDescriptorForPrimitive;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.security.Key;
import java.util.List;

public class HomePage extends WebDriverUtils {

    public HomePage() {
        PageFactory.initElements(getDriver(), this);
    }


    //LOGIN ELEMENTS

    @FindBy(xpath = "//button[@aria-label = 'Dismiss sign-in info.']")
    private WebElement modalExitButton; // exit button for the modal window that appears when opening Booking.com

    @FindBy(css = "a[data-testid ='header-sign-in-button']")
    private WebElement homePageSignInButton; // Homepage 'SignIn' button

    /**
     * Clicks on SignIn Button
     */
    public void clickSignIn() {
        this.closeModal();
        click((homePageSignInButton));
    }

    /**
     * closes the modal dialog box
     * pop-up when visiting site
     */
    private void closeModal() {
        if (isElementDisplayed(modalExitButton)) click(modalExitButton);
    }


// SEARCH FUNCTIONALITIES

    @FindBy(xpath = "//input[@placeholder = 'Where are you going?']")
    private WebElement searchBox;

    @FindBy(xpath = "//button[@type = 'submit']")
    private WebElement searchButton;

    @FindBy(xpath = "//li[@class = 'a80e7dc237']")
    private List<WebElement> locationList;

    public void search(String location) throws InterruptedException {
        searchBox.sendKeys(location);
       Thread.sleep(750);
        for (WebElement destination : locationList) {
            //System.out.println(destination.getText());
            if (destination.getText().equals("Athens")) ;
            click(destination);
            break;
        }
        searchBox.sendKeys(Keys.ENTER);
    }


}


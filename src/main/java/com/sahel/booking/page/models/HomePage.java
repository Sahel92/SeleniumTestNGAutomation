package com.sahel.booking.page.models;

import com.sahel.booking.utilities.WebDriverUtils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends WebDriverUtils {

    public HomePage() {
        PageFactory.initElements(getDriver(), this);
    }


    @FindBy(xpath = "//button[@aria-label = 'Dismiss sign-in info.']")
    private WebElement modalExitButton; // exit button for the modal window that appears when opening Booking.com

    @FindBy(css = "a[data-testid ='header-sign-in-button']")
    private WebElement homePageSignInButton; // Homepage 'SignIn' button

    @FindBy(xpath = "//input[@placeholder = 'Where are you going?']")
    public WebElement locationSearchBox;

    @FindBy(xpath = "//button[@type = 'button' and @data-testid ='date-display-field-start']")
    public WebElement datePicker;






    /**
     * Clicks on SignIn Button
     */
    public void clickSignIn() {
        this.closeModal();
        click((homePageSignInButton));
    }

    /**
     * closes the modal dialog box
     */
    private void closeModal() {
        if (isElementDisplayed(modalExitButton)) click(modalExitButton);
    }


}


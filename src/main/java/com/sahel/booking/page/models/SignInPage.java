package com.sahel.booking.page.models;

import com.sahel.booking.utilities.WebDriverUtils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignInPage extends WebDriverUtils {

    public SignInPage() {
        PageFactory.initElements(getDriver(), this);
    }

    @FindBy(css = "#username")
    private WebElement emailField;

    @FindBy(xpath = "//input[@type = 'password']")
    private WebElement passwordField;

    @FindBy(xpath = "//button[@type = 'submit']")
    private WebElement signInButton;
    @FindBy(xpath = "//button[@type = 'submit']")
    private WebElement continueWithEmailButton;


    public void enterEmail(String email) {
        sendValueUsingJS(emailField, email);
    }

    public void enterPassword(String password) {
        sendText(passwordField, password);
    }

    /**
     * presses Sign in button on the sign-in page.
     */
    public void clickSignIn() {
        click(signInButton);
    }

    public void clickContinueWithEmail() {
        click(continueWithEmailButton);
    }

}

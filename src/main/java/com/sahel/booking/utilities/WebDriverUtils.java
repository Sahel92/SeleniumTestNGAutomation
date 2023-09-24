package com.sahel.booking.utilities;


import com.sahel.booking.base.DriverFactory;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.*;

import java.time.Duration;
import java.util.List;
import java.util.Set;

public class WebDriverUtils extends DriverFactory {
    static final int WEB_DRIVER_WAIT = 10;

    /**
     * Returns a WebDriverWait instance with the given duration in seconds.
     *
     * @return WebDriverWait instance
     */
    public WebDriverWait getWait() {
        return new WebDriverWait(getDriver(), Duration.ofSeconds(WEB_DRIVER_WAIT));
    }

    /**
     * Waits until the provided element is clickable.
     *
     * @param element Element to wait for
     * @return Clickable element
     */
    public WebElement waitTillClickable(WebElement element) {
        return this.getWait().until(ExpectedConditions.elementToBeClickable(element));
    }

    /**
     * Waits until the provided element is visible.
     *
     * @param element Element to wait for
     * @return Visible element
     */
    public WebElement waitTillVisible(WebElement element) {
        return this.getWait().until(ExpectedConditions.visibilityOf(element));
    }

    /**
     * Clicks on the provided element after ensuring it's clickable.
     * implements waitTillVisible();
     * @param element Element to be clicked
     */
    public void click(WebElement element) {
        this.waitTillClickable(element).click();
    }

    /**
     * Enters the given text into the provided element after ensuring it's visible.
     *
     * @param element Element to which text will be sent
     * @param value   Text value to send
     */
    public void sendText(WebElement element, String value) {
        this.waitTillVisible(element).sendKeys(value);
    }

    /**
     * Retrieves the text of the provided element after ensuring it's visible.
     *
     * @param element Element from which text will be retrieved
     * @return Text of the element
     */
    public String getElementTextString(WebElement element) {
        return this.waitTillVisible(element).getText();
    }

    /**
     * Retrieves the title of the current page.
     *
     * @return Title of the current page
     */
    public String getTitle() {
        return getDriver().getTitle();
    }

    /**
     * Uses JavascriptExecutor to set a value to the provided element.
     *
     * @param element Element to which value will be set
     * @param value   Value to set
     */
    public void sendValueUsingJS(WebElement element, String value) {
        JavascriptExecutor executor = ((JavascriptExecutor) getDriver());
        executor.executeScript("arguments[0].value='" + value + "';", element);
    }

    /**
     * Clears the text of the provided element using a combination of key presses.
     *
     * @param toClear Element to clear
     */
    public void clearTextUsingSendKeys(WebElement toClear) {
        toClear.sendKeys(Keys.CONTROL + "a");
        toClear.sendKeys(Keys.DELETE);
    }

    /**
     * Selects an element from a dropdown using its index number.
     *
     * @param element Dropdown element
     * @param index   Index of the option to select
     */
    public void selectByIndex(WebElement element, int index) {
        Select select = new Select(element);
        select.selectByIndex(index);
    }

    /**
     * Selects an element from a dropdown by specified value.
     *
     * @param element Dropdown element
     * @param value   Value of the option to select
     */
    public void selectByValue(WebElement element, String value) {
        Select select = new Select(element);
        select.selectByValue(value);
    }

    /**
     * Selects an element from a dropdown by visible text.
     *
     * @param element     WebElement representing the dropdown
     * @param visibleText Visible text of the option to select
     */
    public void selectByVisibleText(WebElement element, String visibleText) {
        Select select = new Select(element);
        select.selectByVisibleText(visibleText);
    }

    /**
     * Deselects an element from a dropdown by index.
     *
     * @param element WebElement representing the dropdown
     * @param index   Index of the option to deselect
     */
    public void deselectByIndex(WebElement element, int index) {
        Select select = new Select(element);
        select.deselectByIndex(index);
    }

    /**
     * Deselects an element from a dropdown by value.
     *
     * @param element WebElement representing the dropdown
     * @param value   Value of the option to deselect
     */
    public void deselectByValue(WebElement element, String value) {
        Select select = new Select(element);
        select.deselectByValue(value);
    }

    /**
     * Deselects an element from a dropdown by visible text.
     *
     * @param element     WebElement representing the dropdown
     * @param visibleText Visible text of the option to deselect
     */
    public void deselectByVisibleText(WebElement element, String visibleText) {
        Select select = new Select(element);
        select.deselectByVisibleText(visibleText);
    }

    /**
     * Retrieves the tag name of the specified WebElement.
     *
     * @param element WebElement to retrieve tag name from
     * @return Tag name of the element
     */
    public String getTagName(WebElement element) {
        return element.getTagName();
    }

    /**
     * Retrieves the visible text of the specified element.
     *
     * @param element WebElement to retrieve text from
     * @return Visible text of the element
     */
    public String getText(WebElement element) {
        return element.getText();
    }

    /**
     * Highlights the specified element using JavascriptExecutor.
     *
     * @param element WebElement to highlight
     */
    public void highlightElement(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        js.executeScript("arguments[0].style.border='3px solid red'", element);
        js.executeScript("arguments[0].style.border= '1px white'", element);
    }

    /**
     * Performs a drag-and-drop action using Actions class.
     *
     * @param dragLocation Element to drag
     * @param dropLocation Target drop location
     */
    public void dragAndDropAction(WebElement dragLocation, WebElement dropLocation) {
        Actions action = new Actions(getDriver());
        action.dragAndDrop(dragLocation, dropLocation).perform();
    }

    /**
     * Checks if the specified element is displayed.
     *
     * @param element WebElement to check
     * @return True if the element is displayed, false otherwise
     */
    public boolean isElementDisplayed(WebElement element) {
        return element.isDisplayed();
    }

    /**
     * Checks if the specified element is enabled.
     *
     * @param element WebElement to check
     * @return True if the element is enabled, false otherwise
     */
    public boolean isElementEnabled(WebElement element) {
        return element.isEnabled();
    }

    /**
     * Checks if the specified element is selected.
     *
     * @param element WebElement to check
     * @return True if the element is selected, false otherwise
     */
    public boolean isElementSelected(WebElement element) {
        return element.isSelected();
    }

    /**
     * Moves the mouse cursor to an element using Actions class.
     *
     * @param element Element to move to
     */
    public void moveToElementAction(WebElement element) {
        Actions actions = new Actions(getDriver());
        actions.moveToElement(element).build().perform();
    }

    /**
     * Switches to a desired window based on its title.
     *
     * @param switchToWindow Title of the window to switch to
     */
    public void switchWindow(String switchToWindow) {
        String currentWindow = getDriver().getWindowHandle();
        Set<String> handles = getDriver().getWindowHandles();
        for (String winHandle : handles) {
            String currentWindowTitle = getDriver().switchTo().window(winHandle).getTitle();
            if (currentWindowTitle.equals(switchToWindow)) {
                break;
            } else {
                getDriver().switchTo().window(currentWindow);
            }
        }
    }

    /**
     * Selects a calendar date using JavaScript by setting the 'value' attribute.
     *
     * @param date    Date value to set
     * @param element Calendar element
     */
    public void selectCalendarDateWithJS(String date, WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        js.executeScript("arguments[0].setAttribute('value', '" + date + "');", element);
    }

    /**
     * Clicks on an element using JavaScript.
     *
     * @param element Element to click
     */
    public void clickElementWithJS(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        js.executeScript("arguments[0].click();", element);
    }

    /**
     * Scrolls down the page using JavaScript.
     */
    public void scrollPageDownWithJS() {
        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
    }

    /**
     * Clears the text of an element using JavaScript.
     *
     * @param element Element to clear
     */
    public void clearTextWithJS(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        js.executeScript("arguments[0].value = '';", element);
    }

    /**
     * Clears the text of an element using JavaScript and sends new text.
     *
     * @param element Element to clear and send text to
     * @param value   Text value to send
     */
    public void clearAndSendWithJs(WebElement element, String value) {
        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        js.executeScript("arguments[0].value = '';", element);
        element.sendKeys(value);
    }

    /**
     * Refreshes the webpage.
     */
    public void refreshPage() {
        getDriver().navigate().refresh();
    }

    /**
     * Waits for an element to disappear from the page.
     *
     * @param element Element to wait for disappearance
     */
    public void waitForElementToDisappear(WebElement element) {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(WEB_DRIVER_WAIT));
        wait.until(ExpectedConditions.invisibilityOf(element));
    }

    /**
     * Switches to an iframe using the iframe element.
     *
     * @param iframeElement The iframe element to switch to
     */
    public void switchToIframe(WebElement iframeElement) {
        getDriver().switchTo().frame(iframeElement);
    }

    /**
     * Switches back to the main content from an iframe.
     */
    public void switchToDefaultContent() {
        getDriver().switchTo().defaultContent();
    }

    /**
     * Accepts an alert dialog.
     */
    public void acceptAlertDialog() {
        getDriver().switchTo().alert().accept();
    }

    /**
     * Dismisses an alert dialog.
     */
    public void dismissAlertDialog() {
        getDriver().switchTo().alert().dismiss();
    }

    /**
     * Gets the value of a specific attribute of an element.
     *
     * @param element       Element to retrieve attribute from
     * @param attributeName Name of the attribute to retrieve
     * @return Value of the attribute
     */
    public String getAttribute(WebElement element, String attributeName) {
        return element.getAttribute(attributeName);
    }


}

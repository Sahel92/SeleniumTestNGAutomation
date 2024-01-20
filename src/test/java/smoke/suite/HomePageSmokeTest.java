package smoke.suite;

import com.sahel.booking.base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HomePageSmokeTest extends TestBase {

    @Test
    public void doesHomepageExist(){
        String title = getDriver().getTitle();
        String actualTitle = "My Retail App";
        Assert.assertEquals(title,actualTitle);
        logger.info("Homepage exists and the boss is happy");
    }

    @Test
    public void doesHeaderExist(){
        WebElement header = getDriver().findElement(By.xpath("//h1[@class ='header']"));
    Assert.assertTrue(isElementDisplayed(header));
    logger.info("Header is displayed on the homepage : " + header.getText());
    }

    @Test
    public void doesLinkToProductPageExist(){
        WebElement shopLink = getDriver().findElement(By.xpath("//a[@class ='link-to-shopping']"));
        Assert.assertTrue(isElementEnabled(shopLink));
    }

    @Test
    public void userCanNavigateToShopPage(){
        WebElement shopLink = getDriver().findElement(By.xpath("//a[@class ='link-to-shopping']"));
        Assert.assertTrue(isElementEnabled(shopLink));
        logger.info("The link to the products page is enabled and displayed");
        shopLink.click();
        logger.info("Link to product page was clicked");
        WebElement homeLink = getDriver().findElement(By.xpath("//h1[@class ='products']"));
        Assert.assertTrue(isElementEnabled(homeLink));
        logger.info("User has successfully been navigated to the Products page.");

    }

}




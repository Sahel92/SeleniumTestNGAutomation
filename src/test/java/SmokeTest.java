import com.aventstack.extentreports.Status;
import com.sahel.booking.base.TestBase;

import com.sahel.booking.page.models.HomePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SmokeTest extends TestBase {
                    HomePage homePage;
    @Test
    public void test1()  {
        homePage = new HomePage();
        logger.info("Smoke Testing Commencing");
        Assert.assertEquals(homePage.getTitle(), "Booking.com | Official site | The best hotels, flights, car rentals & accommodations");
        homePage.clickSignIn();
    }




}

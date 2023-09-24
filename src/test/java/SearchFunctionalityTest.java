import com.sahel.booking.base.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SearchFunctionalityTest extends TestBase {

    @Test
    public void searchDestination() throws InterruptedException {
        factory.homePage().search("Athens Greece");
        Assert.assertEquals(getDriver().getTitle(),"Booking.com: Hotels in Athens. Book your hotel now!");
        logger.info("User searched for desired destination");
    }


}

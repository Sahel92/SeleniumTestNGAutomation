import com.sahel.booking.base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;
import java.util.Random;

public class SearchFunctionalityTest extends TestBase {

    /**
     * Search for a Hotel in a Specific Location:
     * As a user, I want to search for a hotel in a specific location.
     * Acceptance Criteria:
     * I can enter the destination city or location.
     * I can specify check-in and check-out dates.
     * The search results should display available hotels in the selected location and dates.
     */

    @Test
    public void validHotelSearch() {
        sendText(factory.homePage().locationSearchBox, "Seattle");
        WebElement checkInMonth = getDriver().findElement(By.xpath("(//button[@class = 'd47738b911 e246f833f7 fe211c0731'])[1]"));
        WebElement checkOutMonth = getDriver().findElement(By.xpath("(//button[@class = 'd47738b911 e246f833f7 fe211c0731'])[2]"));
        setRandomCalendarDate(checkInMonth);
        setRandomCalendarDate(checkOutMonth);
    }


}

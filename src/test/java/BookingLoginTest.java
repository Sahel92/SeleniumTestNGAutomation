import com.sahel.booking.base.TestBase;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class BookingLoginTest extends TestBase {
/**
 * This is a sample of how to implement the login functionality.
 * Booking.com uses captcha technology to prevent automated login.
 */
    // Performs login action.
    // Login scenarios cannot be automated for Booking.com. Unfortunate.....
//    @Parameters({"email", "password"})
//    @Test
//    public void performSignIn(String email, String password) {
//        Assert.assertEquals(factory.homePage().getTitle(), "Booking.com | Official site | The best hotels, flights, car rentals" + " & " + "accommodations");
//        logger.info("User is on Booking.com homepage");
//        factory.homePage().clickSignIn();
//        logger.info("User clicked on 'SignIn' button");
//        factory.signInPage().enterEmail(email);
//        logger.info("User entered valid email");
//        factory.signInPage().clickContinueWithEmail();
//        logger.info("User clicked 'Continue with email' button");
//        factory.signInPage().enterPassword(password);
//        logger.info("User entered valid password");
//        factory.signInPage().clickSignIn();
//        logger.info("User clicked 'Sign in' button on the sign page");
//    }
//

}

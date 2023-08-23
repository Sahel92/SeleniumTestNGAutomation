import com.sahel.booking.base.TestBase;

import org.testng.annotations.Test;

public class SmokeTest extends TestBase {

    @Test
    public void test1() {
        test.info("method one will start");
        System.out.println("This is test one");
        test.pass("test 1 passed");
    }

    @Test
    public void test2() {
        test.assignCategory("Smoke").assignAuthor("Sahel").assignDevice("Windows 11 Chrome 116");
        System.out.println("This is test two");
        test.pass("test 2 passed");
    }

}

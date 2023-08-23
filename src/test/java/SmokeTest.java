import com.aventstack.extentreports.Status;
import com.sahel.booking.base.TestBase;

import org.testng.annotations.Test;

public class SmokeTest extends TestBase {

    @Test
    public void test1() {
        test.info("method one will start");
        test.assignCategory("Smoke").assignAuthor("Sahel").assignDevice("Windows 11 -- Chrome 116");
        System.out.println("This is test one");
       // test.pass("test 1 passed");
        test.log(Status.PASS, "<b> TEST 1 PASSED </b>");
    }

    @Test
    public void test2() {
       // test.assignCategory("Smoke").assignAuthor("Sahel").assignDevice("Windows 11 Chrome 116");
        test.createNode("Unit").fail("fail");
        System.out.println("This is test two");
        test.info("test 2 failed");
    }


}

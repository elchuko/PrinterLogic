package tests;

import pages.IndexPage;
import utilities.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    protected IndexPage indexPage = new IndexPage(driver,15);

    @Test
    public void loginTest_OK(){
        log.login("ElChuko", "PrinterLogic27");
        Assert.assertTrue(indexPage.indexPageLoaded());
    }

    @Test
    public void loginTest_BadCredentials(){
        log.login("Pocahontas", "FakePassword");
        Assert.assertTrue(log.isWrongLoginTextPresent());
    }
}

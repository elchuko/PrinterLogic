package tests;

import org.openqa.selenium.WebDriver;
import pages.IndexPage;
import utilities.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    private final String ELCHUKO = "ElChuko";
    private final String GOOD_PASSWORD = "PrinterLogic27";
    private final String NOT_ELCHUKO = "NotElChuko";
    private final String BAD_PASSWORD = "FakePassword";

    protected IndexPage indexPage;

    @Test
    public void loginTest_OK(){
        log.login(ELCHUKO, GOOD_PASSWORD);
        indexPage = new IndexPage(driver, 15);
        Assert.assertTrue(indexPage.indexPageLoaded());
    }

    @Test
    public void loginTest_Bad_Username_Good_Password_Fails(){
        log.populateAndSubmitLoginPageExpectingHomePage(NOT_ELCHUKO, GOOD_PASSWORD);
        Assert.assertTrue(log.isWrongLoginTextPresent());
    }

    @Test
    public void loginTest_Good_Username_Bad_Password_Fails(){
        log.populateAndSubmitLoginPageExpectingHomePage(ELCHUKO, BAD_PASSWORD);
        Assert.assertTrue(log.isWrongLoginTextPresent());
    }

    @Test
    public void loginTest_Bad_Username_Bad_Password_Fails(){
        log.populateAndSubmitLoginPageExpectingHomePage(NOT_ELCHUKO, BAD_PASSWORD);
        Assert.assertTrue(log.isWrongLoginTextPresent());
    }
}

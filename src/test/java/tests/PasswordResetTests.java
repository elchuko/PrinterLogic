package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.PasswordResetPage;
import utilities.BaseTest;

public class PasswordResetTests extends BaseTest {

    private final String RESET_PAGE_EXPECTED_URL = "https://antonioss.printercloud.com/admin/password/reset/";
    private final String LOGIN_PAGE_EXPECTED_URL = "https://antonioss.printercloud.com/admin/";
    private final String CORRECT_EMAIL = "sanchezsierr@gmail.com";
    private final String BAD_EMAIL = "randomemail@tlcqa.com";

    private PasswordResetPage resetPage;

    @BeforeMethod
    public void navigateToForgotPasswordPage(){
        log.forgotPassowrdClick();
    }

    @Test
    public void resetPassword_Correct_Email(){
        resetPage = new PasswordResetPage(driver, 15);
        Assert.assertEquals(driver.getCurrentUrl(), RESET_PAGE_EXPECTED_URL);
        Assert.assertTrue(resetPage.isMessageVisible());
        resetPage.writeEmail(CORRECT_EMAIL);
        resetPage.clickResetPassword();
        Assert.assertTrue(resetPage.isMailSentMsgVisible());
    }

    @Test
    public void resetPassword_Incorrect_Email(){
        resetPage = new PasswordResetPage(driver, 15);
        Assert.assertEquals(driver.getCurrentUrl(), RESET_PAGE_EXPECTED_URL);
        Assert.assertTrue(resetPage.isMessageVisible());
        resetPage.writeEmail(BAD_EMAIL);
        resetPage.clickResetPassword();
        Assert.assertTrue(resetPage.isSentFailMsgVisible());
    }

    @Test
    public void resetPassword_Cancel(){
        resetPage = new PasswordResetPage(driver, 15);
        Assert.assertEquals(driver.getCurrentUrl(), RESET_PAGE_EXPECTED_URL);
        Assert.assertTrue(resetPage.isMessageVisible());
        resetPage.clickCancelButton();
        log.waitForPageToLoad();
        Assert.assertEquals(driver.getCurrentUrl(), LOGIN_PAGE_EXPECTED_URL);
    }

}

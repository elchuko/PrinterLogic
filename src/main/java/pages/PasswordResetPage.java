package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import utilities.BasePage;

public class PasswordResetPage extends BasePage {

    @FindBy(id="password-title")
    WebElement forgotPassword;

    @FindBy(id="password-body")
    WebElement passwordBodyMsg;

    @FindBy(id="email")
    WebElement emailTextBox;

    @FindBy(xpath = "//*[contains(text(),'Reset Password')]")
    WebElement resetPasswordButton;

    @FindBy(xpath = "//*[contains(text(),'Cancel')]")
    WebElement cancelButton;

    @FindBy(xpath = "//*[contains(text(),'We have emailed your password reset link!')]")
    WebElement mailSentSuccessMsg;

    @FindBy(xpath = "//*[contains(text(),'find a user with that email address.')]")
    WebElement mailSentFailMsg;

    @FindBy(id = "password-modal")
    WebElement passwordPage;

    public PasswordResetPage(WebDriver driver, int time) {
        super(driver, time);
    }

    public void waitForPageToLoad() {
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("password-modal")));
    }

    public Boolean isMessageVisible(){
        return passwordBodyMsg.isDisplayed();
    }

    public Boolean isMailSentMsgVisible(){
        return mailSentSuccessMsg.isDisplayed();
    }

    public Boolean isSentFailMsgVisible(){
        return mailSentFailMsg.isDisplayed();
    }

    public void writeEmail(String email){
        sendKeysToElement(emailTextBox, email);
    }

    public void clickResetPassword(){
        clickOnElement(resetPasswordButton);
    }

    public void clickCancelButton(){
        clickOnElement(cancelButton);
    }





}

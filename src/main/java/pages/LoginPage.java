package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import utilities.BasePage;

public class LoginPage extends BasePage {

    public LoginPage(WebDriver driver, int time) {
        super(driver, time);
    }

    @FindBy(id="relogin_user")
    WebElement usernameInput;

    @FindBy(id="relogin_password")
    WebElement passwordInput;

    @FindBy(id="admin-login-btn")
    WebElement loginButton;

    @FindBy(xpath = "//*[contains(text(),'Invalid username or password')]")
    WebElement wrongLoginText;



    public void waitForPageToLoad() {
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("logo")));
    }

    public void login(String username, String password){
        sendKeysToElement(this.usernameInput, username);
        sendKeysToElement(this.passwordInput, password);
        clickOnElement(loginButton);
    }

    public Boolean isWrongLoginTextPresent(){
        return wrongLoginText.isDisplayed();
    }

    public void populateAndSubmitLoginPageExpectingHomePage(String userName, String password) {
        waitForPageToLoad();
        login(userName, password);
    }
}

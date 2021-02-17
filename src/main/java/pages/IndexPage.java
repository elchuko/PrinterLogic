package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import utilities.BasePage;

public class IndexPage extends BasePage {

    public IndexPage(WebDriver driver, int time){
        super(driver, time);
    }

    @FindBy(id="logo")
    WebElement printerLogicLogo;


    public void waitForPageToLoad() {
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("logo")));
    }

    public Boolean indexPageLoaded(){
        waitForPageToLoad();
        return printerLogicLogo.isDisplayed();
    }


}

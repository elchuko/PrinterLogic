package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import utilities.BasePage;

public class IndexPage extends BasePage {



    @FindBy(id="mainpane")
    WebElement mainPane;

    @FindBy(xpath="//*[contains(text(),'General')]")
    WebElement generalTab;

    @FindBy(xpath="//*[contains(text(),'Security')]")
    WebElement securityTab;

    @FindBy(xpath="//*[contains(text(),'Alerts')]")
    WebElement alertsTab;

    @FindBy(xpath="//*[contains(text(),'Map')]")
    WebElement mapTab;


    public IndexPage(WebDriver driver, int time){
        super(driver, time);
    }

    public void waitForPageToLoad() {
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("mainpage")));
    }

    public Boolean indexPageLoaded(){
        waitForPageToLoad();
        return mainPane.isDisplayed();
    }


}

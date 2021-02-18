package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import utilities.BasePage;

public class SidePane extends BasePage {

    @FindBy(id="sidepane")
    WebElement sidepane;

    @FindBy(id="newfolder")
    WebElement newFolderButton;
    
    public SidePane(WebDriver driver, int time){
        super(driver, time);
    }


    public void waitForPageToLoad() {
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("sidepane")));
    }
}

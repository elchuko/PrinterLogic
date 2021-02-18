package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import utilities.BasePage;

public class Header extends BasePage {

    @FindBy(id="utility")
    WebElement headerTable;

    @FindBy(id="reports-menu")
    WebElement reportTab;

    @FindBy(id="gear-menu")
    WebElement toolsTab;

    @FindBy(id="help-menu")
    WebElement supportAndTrainingTab;

    @FindBy(id="admin-audit-records-link")
    WebElement adminAuditRecordsMenu;

    @FindBy(id="workstations-link")
    WebElement workstationsMenu;

    @FindBy(id="print-job-records-link")
    WebElement printJobRecords;

    @FindBy(id="printer-status-link")
    WebElement printerStatusLink;

    public Header(WebDriver driver, int time){
        super(driver, time);
    }

    public void waitForPageToLoad() {
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("utility")));
    }
}

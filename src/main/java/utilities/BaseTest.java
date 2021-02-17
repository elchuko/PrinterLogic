package utilities;

import java.util.concurrent.TimeUnit;

import io.cucumber.java.AfterStep;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import pages.LoginPage;

public class BaseTest {

    protected WebDriver driver;
    protected LoginPage log;

    public void setBrowser(String browser){
        driver = driverFactory(browser);
    }


    public void setup() {
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://antonioss.printercloud.com/admin/index.php");
        log = new LoginPage(driver, 15);
    }

    public void tearDown() {
        driver.quit();
    }

    private WebDriver driverFactory(String browser){
        if(browser.equals("Chrome")){
            System.setProperty("webdriver.chrome.driver", "C:\\chromedriver\\chromedriver.exe");
            return new ChromeDriver();
        }
        else if (browser.equals("Firefox")){
            System.setProperty("webdriver.gecko.driver","C:\\geckodriver\\geckodriver.exe");
            return new FirefoxDriver();
        }
        else{
            return new ChromeDriver();
        }
    }
}

package utilities;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

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
    private final BrowserFactory BROWSER_FACTORY = new BrowserFactory();
    private final ConfigHelper CONFIG = new ConfigHelper();

    @BeforeMethod
    public void setup() throws IOException {
        driver = BROWSER_FACTORY.driverFactory(CONFIG.getBroserFromPropValues());
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://antonioss.printercloud.com/admin/index.php");
        log = new LoginPage(driver, 15);
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }


}

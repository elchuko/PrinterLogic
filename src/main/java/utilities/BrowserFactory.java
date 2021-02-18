package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BrowserFactory {

    public WebDriver driverFactory(String browser){
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

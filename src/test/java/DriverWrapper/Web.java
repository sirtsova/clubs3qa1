package DriverWrapper;

import Utils.TestConstant;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Web {
    private static WebDriver driver = null;

    @Before
    public static void openUrl() {
        System.setProperty("webdriver.chrome.driver", ".\\drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://clubs3qa1.scholastic.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(TestConstant.tenSeconds, TimeUnit.SECONDS);
    }

    public void closePage() { driver.close(); }

    @After
    public static void quitPage() { driver.quit(); }

    public static WebDriver getDriver () { return driver; }

}

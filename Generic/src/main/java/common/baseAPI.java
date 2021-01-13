package common;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class baseAPI {

    public static WebDriver driver = null;

    @BeforeTest
    public WebDriver initializeDriver() throws IOException {
        Properties prop = new Properties();
        FileInputStream fileInput = new FileInputStream("src/main/resources/data.properties");

        prop.load(fileInput);
        String browserName = prop.getProperty("browser");
        if (browserName.equals("chrome")) {
            WebDriverManager.chromedriver().setup();            driver = new ChromeDriver();
        } else if (browserName.equals("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        } else if (browserName.equals("iexplorer")) {
            WebDriverManager.iedriver().setup();
            driver = new InternetExplorerDriver();
        } else if (browserName.equals("iEdge")) {
            WebDriverManager.edgedriver().setup();
            driver = new InternetExplorerDriver();
        }else if (browserName.equals("opera")) {
            WebDriverManager.operadriver().setup();
            driver = new InternetExplorerDriver();
        }
    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        return driver;
    }


    public void asssertLandingPage(String expectedURL){
        String actualURL = driver.getCurrentUrl();
        Assert.assertEquals(actualURL,expectedURL,"Test Failed: Actual URL is not as expected.");
    }

    public void assertCurrentTitle(String expectedPageTitle) {
        String actualPageTitle = driver.getTitle();
        Assert.assertEquals(actualPageTitle,expectedPageTitle,"Test Failed: The title found, does not match with expected.");
    }

    public void sleepFor(int seconds){
        try {
            Thread.sleep(seconds*1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    @AfterTest (alwaysRun = true)
    public void tearDown(){
        driver.manage().deleteAllCookies();
        driver.quit();
    }

}

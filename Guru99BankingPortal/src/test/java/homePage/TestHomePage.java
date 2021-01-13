package homePage;

import bankingHompage.HomePage;
import common.baseAPI;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import static bankingHompage.HomePageElements.*;

public class TestHomePage extends baseAPI {
    HomePage homepage;

    @BeforeMethod
    public void basePageNavigation() throws IOException {

        homepage = PageFactory.initElements(driver,HomePage.class);
        driver.manage().window().maximize();
        driver.get(guru99Homepage);
        homepage.Login("mngr303541","YbydEqU");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void testLogin() {
        driver.navigate().refresh();
        homepage.asssertLandingPage(homeLandingPageElement);
        homepage.assertCurrentTitle(getHomeLandingPageTitleElement);
    }


}

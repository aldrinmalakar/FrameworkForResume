package newCustomerPage;

import bankingHompage.HomePage;
import common.baseAPI;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import static bankingHompage.HomePageElements.guru99Homepage;
import static newCustomerPage.NewCustomerPageElements.*;

public class TestNewCustomerPage extends baseAPI {
    HomePage homepage;
    NewCustomerPage newCustomerPage;

    @BeforeMethod
    public void basePageNavigation() throws IOException {

        homepage = PageFactory.initElements(driver, HomePage.class);

        driver.manage().window().maximize();
        driver.get(guru99Homepage);
        homepage.Login("mngr303541", "YbydEqU");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        newCustomerPage = PageFactory.initElements(driver, NewCustomerPage.class);
        newCustomerPage.newCustomerPageSelector.click();
        //driver.findElement(By.cssSelector(newCustomerPageSelectorElement)).click();
        sleepFor(1);

    }

    @Test
    public void testNewCustomerPageLanding() {
        asssertLandingPage(newCustomerPageExpectedURL);
        assertCurrentTitle(newCustomerPageExpectedTitle);
    }

    @Test(dataProvider = "formData")
    public void testAddANewCustomer(String name,
                                    String DOB,
                                    String address,
                                    String city,
                                    String state,
                                    String pinNum,
                                    String mobileNum,
                                    String emailAd,
                                    String password) {
        newCustomerPage.fillANewForm(name,
                                    DOB,
                                    address,
                                    city,
                                    state,
                                    pinNum,
                                    mobileNum,
                                    emailAd,
                                    password);
        newCustomerPage.assertSuccessfulRegistration(getCustomerRegisteredConfirmationText);
    }

    @DataProvider
    public Object[][] formData() {
        Object[][] inputFormData = new Object[2][9];

        inputFormData[0][0] = "Hung Lopez";
        inputFormData[0][1] = "01/24/1975";
        inputFormData[0][2] = "3391 Gnatty Creek Road";
        inputFormData[0][3] = "Freeport";
        inputFormData[0][4] = "NY";
        inputFormData[0][5] = "159357";
        inputFormData[0][6] = "5163790441";
        inputFormData[0][7] = "HungSLopez@armyspy.com";
        inputFormData[0][8] = "password1";

        inputFormData[1][0] = "Ilham Bolten";
        inputFormData[1][1] = "01/24/1959";
        inputFormData[1][2] = "2766 Hanover Street";
        inputFormData[1][3] = "New York";
        inputFormData[1][4] = "NY";
        inputFormData[1][5] = "745963";
        inputFormData[1][6] = "9177222805";
        inputFormData[1][7] = "IlhamBolten1@dayrep.com";
        inputFormData[1][8] = "password1";
        return inputFormData;
    }
}

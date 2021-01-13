package newCustomerPage;


import common.baseAPI;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.Assert;

import static newCustomerPage.NewCustomerPageElements.*;

public class NewCustomerPage extends baseAPI {
    @FindBy(how = How.CSS, using = newCustomerPageSelectorElement)
    public WebElement newCustomerPageSelector;
    @FindBy(how = How.CSS, using = customerNameCssElement)
    public WebElement customerNameCss;
    @FindBy(how = How.ID, using = customerDOBIdElement)
    public WebElement customerDOBId;
    @FindBy(how = How.XPATH, using = customerAddressXpathElement)
    public WebElement customerAddressXpath;
    @FindBy(how = How.NAME, using = customerCityNameElement)
    public WebElement customerCityName;
    @FindBy(how = How.XPATH, using = customerStateXpathElement)
    public WebElement customerStateXpath;
    @FindBy(how = How.NAME, using = customerPINNameElement)
    public WebElement customerPINName;
    @FindBy(how = How.CSS, using = customerMobileNoCssElement)
    public WebElement customerMobileNoCss;
    @FindBy(how = How.CSS, using = customerEmailCssElement)
    public WebElement customerEmailCss;
    @FindBy(how = How.NAME, using = customerPasswordNameElement)
    public WebElement customerPasswordName;
    @FindBy(how = How.XPATH, using = submitFormXPathElement)
    public WebElement submitFormXPath;
    @FindBy(how = How.XPATH, using = customerRegistrationConfirmationXpathElement)
    public WebElement customerRegistrationConfirmationXpath;


    public void asssertLandingPage(String expectedURL) {
        String actualURL = driver.getCurrentUrl();
        Assert.assertEquals(actualURL, expectedURL, "Test Failed: Actual URL is not as expected.");
    }

    public void assertCurrentTitle(String expectedPageTitle) {
        String actualPageTitle = driver.getTitle();
        Assert.assertEquals(actualPageTitle, expectedPageTitle, "Test Failed: The title found, does not match with expected.");
    }


    public void fillANewForm(String name,
                             String dob,
                             String address,
                             String city,
                             String state,
                             String pinNum,
                             String mobileNum,
                             String emailAd,
                             String password) {

        customerNameCss.sendKeys(name);
        customerDOBId.sendKeys(dob);
        customerAddressXpath.sendKeys(address);
        customerCityName.sendKeys(city);
        customerStateXpath.sendKeys(state);
        customerPINName.sendKeys(pinNum);
        customerMobileNoCss.sendKeys(mobileNum);
        customerEmailCss.sendKeys(emailAd);
        customerPasswordName.sendKeys(password);
        submitFormXPath.click();
    }

    public void assertSuccessfulRegistration(String expectedText) {
        String actualText = customerRegistrationConfirmationXpath.getText();
        Assert.assertEquals(actualText, expectedText, "Test Failed: Text isn't as expected.");
    }


}

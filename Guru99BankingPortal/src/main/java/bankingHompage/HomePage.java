package bankingHompage;


import common.baseAPI;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.Assert;

import static bankingHompage.HomePageElements.*;

public class HomePage extends baseAPI {
    @FindBy(how = How.NAME, using = userIDNameElement)
    public WebElement userIDName;
    @FindBy(how = How.NAME, using = passwordNameElement)
    public WebElement passwordName;
    @FindBy(how = How.NAME, using = loginButtonNameElement)
    public WebElement loginButtonName;





    public void Login(String userName, String passWord) {
        userIDName.sendKeys(userName);
        passwordName.sendKeys(passWord);
        loginButtonName.click();
    }

    public void asssertLandingPage(String expectedURL){
        String actualURL = driver.getCurrentUrl();
        Assert.assertEquals(actualURL,expectedURL,"Test Failed: Actual URL is not as expected.");
    }

    public void assertCurrentTitle(String expectedPageTitle) {
        String actualPageTitle = driver.getTitle();
        Assert.assertEquals(actualPageTitle,expectedPageTitle,"Test Failed: The title found, does not match with expected.");
    }
}

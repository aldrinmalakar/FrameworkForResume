package newCustomerPage;

public class NewCustomerPageElements {
    public static final String newCustomerPageSelectorElement = "ul.menusubnav:nth-child(1) > li:nth-child(2) > a";
    public static final String newCustomerPageExpectedURL = "http://demo.guru99.com/V4/manager/addcustomerpage.php";
    public static final String newCustomerPageExpectedTitle = "Gtpl Bank New Customer Entry Page";

    public static final String customerNameCssElement = "input[name='name']";
    public static final String customerDOBIdElement = "dob";
    public static final String customerAddressXpathElement = "//textarea[@name='addr']";
    public static final String customerCityNameElement = "city";
    public static final String customerStateXpathElement = "//input[@name='state']";
    public static final String customerPINNameElement = "pinno";
    public static final String customerMobileNoCssElement = "input[name='telephoneno']";
    public static final String customerEmailCssElement = "input[name='emailid']";
    public static final String customerPasswordNameElement = "password";
    public static final String submitFormXPathElement = "//input[@name='sub']";
    public static final String customerRegisteredPageTitle = " Guru99 Bank Customer Registration Page ";
    public static final String customerRegistrationConfirmationXpathElement = "//p[@align='center']";
    public static final String getCustomerRegisteredConfirmationText = "Customer Registered Successfully!!!";
}

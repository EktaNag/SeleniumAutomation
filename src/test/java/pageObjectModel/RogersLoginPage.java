package pageObjectModel;

import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import shared.Utils;

import java.util.NoSuchElementException;

public class RogersLoginPage extends BasePOM {

    //Initializing the value of driver from basePOM class
    public RogersLoginPage(WebDriver newDriver) {
        super(newDriver);
    }

    //Page header
    By TitleSHOP = By.xpath("//nav[@class=\"rcl-header-navigation\"]/ul/li[1]");

    //Page SHOP nav sub headers
    public By DropDownWireless = By.xpath("//nav[@class=\"rcl-header-navigation\"]/ul/li[1]/ul/li[1]");
    public By DropDOwnTVBundles = By.xpath("//nav[@class=\"rcl-header-navigation\"]/ul/li[1]/ul/li[2]");
    public By DropDownInternet = By.xpath("//nav[@class=\"rcl-header-navigation\"]/ul/li[1]/ul/li[3]");
    public By DropDownHomePhone = By.xpath("//nav[@class=\"rcl-header-navigation\"]/ul/li[1]/ul/li[4]");
    public By DropDownWirelessHomePhone = By.xpath("//nav[@class=\"rcl-header-navigation\"]/ul/li[1]/ul/li[5]");
    public By DropDownHomeMonitoring = By.xpath("//nav[@class=\"rcl-header-navigation\"]/ul/li[1]/ul/li[6]");
    public By DropDownMastercard = By.xpath("//nav[@class=\"rcl-header-navigation\"]/ul/li[1]/ul/li[7]");
    public By DropDownPromotions = By.xpath("//nav[@class=\"rcl-header-navigation\"]/ul/li[1]/ul/li[8]");
    public By DropDownWhyRogers = By.xpath("//nav[@class=\"rcl-header-navigation\"]/ul/li[1]/ul/li[9]");

    //Roger Page Footer Links

    public By InvesterRelations = By.xpath("//footer//*[text()='Investor Relations' or @title='Investor Relations']");
    public By CorporateSocialResponsibility = By.xpath("//footer//*[text()='Corporate Social Responsibility' or @title='Corporate Social Responsibility']");
    public By CommunityInvestment = By.xpath("//footer//*[text()='Community Investment' or @title='Community Investment']");
    public By AboutRogers = By.xpath("//footer//*[text()='About Rogers' or @title='About Rogers']");
    public By Security = By.xpath("//footer//*[text()='Security' or @title='Security']");


    public By PrivacyCRTC = By.xpath("//footer//*[text()='Privacy & CRTC ' or text()='Privacy & CRTC']");
    public By AdChoices = By.xpath("//footer//*[text()='Ad Choices ' or text()='Ad Choices']");
    public By Careers = By.xpath("//footer//*[text()='Careers' or text()='Careers ']");
    public By AccessibityServices = By.xpath("//footer//*[text()='Accessibility Services']");
    public By RogersMastercard = By.xpath("//footer//*[text()='Rogers Mastercard']");

    public By TermsAndConditions = By.xpath("//footer//*[text()='Terms & Conditions ' or text()='Terms & Conditions']");
    public By SiteMap = By.xpath("//footer//*[text()='Site Map' or text()='Site Map ']");
    public By MediaContact = By.xpath("//footer//*[text()='Media Contact']");
    public By Unsubscribe = By.xpath("//footer//*[text()='Unsubscribe']");
    public By CommunityForums = By.xpath("//footer//*[text()='Community Forums']");

    //By ContactUs=By.xpath("//div[@class='m-cta-hideMobile']/ul/li[1]");////*[text()='Contact us'or text()='Contact Us ']
//    By FindaStore=By.xpath("//div[@class='m-cta-hideMobile']/ul/li[2]");

    //String a="ekta\"nag";
    //String a="ekta"+"\\"+"\""+"nag";


//    public void checkWireless(String expectedPageURL)
//    {
//        click(TitleSHOP);
//        Utils.iWait(2);
//        click(DropDownWireless);
//        expectedPageURL.equals(getCurrentURL());
//       // navigateToHomePage();
//        Utils.iWait(1);
//    }

    public void selectSHOPDropDownMenuOptions(By locator) {
        click(TitleSHOP);
        Utils.iWait(1);
        click(locator);
    }


    public void verifyElementOnPage(By elementName) {
        Utils.iWait(3);

        boolean present;
        try {
            driver.findElement(elementName);
            present = true;
            // System.out.println("Element  is present .Value is "+ present);
            System.out.println("Link '" + getText(elementName) + "' is present.");
        } catch (NoSuchElementException e) {
            present = false;
            System.out.println("Link '" + getText(elementName) + "' is not present.");

        }


    }

    public void navigateToHomePage() {
        driver.navigate().to("https://www.rogers.com/home");
        Utils.iWait(1);
    }


}

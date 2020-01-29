package baseTest;

import org.openqa.selenium.By;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pageObjectModel.RogersLoginPage;
import shared.Utils;

public class RogersTestCases extends BaseTest {
    @DataProvider
    public Object[][] getFooterLinks() {

        RogersLoginPage obj = new RogersLoginPage(driver);

        By[] footerLinks = {
                obj.InvesterRelations,
                obj.CorporateSocialResponsibility,
                obj.CommunityInvestment,
                obj.AboutRogers,
                obj.Security,
                obj.PrivacyCRTC,
                obj.AdChoices,
                obj.Careers,
                obj.AccessibityServices,
                obj.RogersMastercard,
                obj.TermsAndConditions,
                obj.SiteMap,
                obj.MediaContact,
                obj.Unsubscribe,
                obj.CommunityForums
        };

//        By[] pageLinks = {
//                obj.DropDownWireless
//        };

        return new Object[][]
                {
                        {obj.DropDownWireless, footerLinks},
                        {obj.DropDOwnTVBundles, footerLinks},
                        {obj.DropDownInternet, footerLinks},
                        {obj.DropDownHomePhone, footerLinks},
                        {obj.DropDownWirelessHomePhone,footerLinks},
                        {obj.DropDownHomeMonitoring,footerLinks},
                        {obj.RogersMastercard,footerLinks},
                        {obj.DropDownPromotions,footerLinks},
                        {obj.DropDownWhyRogers,footerLinks}
                };
    }

    @Test(dataProvider = "getFooterLinks")
    public void openRogersHomePage(By page, By[] footerLinks) {
        driver.get("https://" + testEnv + "/home");
        Utils.iWait(2);

        RogersLoginPage obj = new RogersLoginPage(driver);

        //  obj.checkWireless("https://"+testEnv+"/consumer/wireless");
        obj.selectSHOPDropDownMenuOptions(page);

        for (By locator : footerLinks) {
            obj.verifyElementOnPage(locator);
        }


    }

}

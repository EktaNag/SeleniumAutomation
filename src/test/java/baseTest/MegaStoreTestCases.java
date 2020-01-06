package baseTest;

import org.testng.annotations.Test;
import pageObjectModel.MegaStoreLoginPage;

public class MegaStoreTestCases extends  BaseTest{

    @Test
    public void openPage()
    {
        driver.get("https://usmegastore.com/");
        MegaStoreLoginPage obj=new MegaStoreLoginPage(driver);
        obj.clickOnDepartment();
        obj.promotionsHeader();
    }

    @Test
    public void getPromotionPageDetails()
    {
        driver.get("https://usmegastore.com/promo");
        MegaStoreLoginPage obj1=new MegaStoreLoginPage(driver);
        obj1.getAllLimitedTimeOffers();

    }

   @Test
   public void getDepartmentMenuDetails()
   {
       driver.get("https://usmegastore.com/");
       MegaStoreLoginPage obj2=new MegaStoreLoginPage(driver);
       obj2.getMenuDetails();

   }


}

package baseTest;

import org.openqa.selenium.Keys;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pageObjectModel.LoginPage;

public class TestCases extends BaseTest {
    @DataProvider
    public Object[][] getData()
    {
        return new Object[][]{{"Ekta Nag"},
                {"Karan Nag"},
                {"Arjun Nag"},
                {"Rahul Nag"}
        };
    }
    @Test(dataProvider ="getData")
    public void getPageSubHeadings(String val)
    {
        driver.get("https://www.google.com/");


        LoginPage loginPage=new LoginPage(driver);
loginPage.searchValue(val+ Keys.ENTER);
loginPage.getSearchResultHeadingWithLinks();


    }
}

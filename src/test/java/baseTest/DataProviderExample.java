package baseTest;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderExample extends  BaseTest{

    @DataProvider(name = "ABC",indices = {0,1,2})
    public Object[][] getData()
    {
        return new Object[][]
        {
            {"Ekta"}  ,
            {"Anjali"},
                {"Devika"},
                {"Rahul"},
                {"Arjun"},
                {"Karan"}

        };
    }

    @Test(dataProvider = "ABC")
    public void openLoginPage(String name)
    {
        driver.get("https://www.google.com");

    }

















}

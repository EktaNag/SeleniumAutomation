package baseTest;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import shared.Utils;

import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;

public class BaseTest {

    String testEnv = "www.rogers.com";
    WebDriver driver;

    @BeforeMethod(alwaysRun = true)
    public void setUp(Method method)
    {
        driver=Utils.browserLaunch("local");
        System.out.println("The method name is : "+method.getName());
        System.out.println();
    }



    @AfterMethod(alwaysRun = true)
    public void closeBrowser(ITestResult result)
    {
        if (result.isSuccess())
        {
            System.out.println("TEST IS PASSED");
        }
        else
        {
            System.out.println("TEST FAILED");
        }
  driver.quit();
    }


}




// Jenkins token - beb8fe72837294390bf1bd7c9fe3def0af319f4c

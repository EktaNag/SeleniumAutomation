package baseTest;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;

public class BaseTest {

    WebDriver driver;

    @BeforeMethod(alwaysRun = true)
    public void setUp(Method method)
    {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        System.out.println(method.getName());
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

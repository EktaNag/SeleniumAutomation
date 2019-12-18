package seleniumAutomation;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class BrowserLaunch {
   // WebDriver driver;

    @DataProvider(parallel = true)
    public Object[][] getData()
    {
        return new Object[][]
                {
                        {"Prabhat Kumar" } ,
                        {"Karan Nag"},
                        {"Karan Nag"},
                        {"Karan Nag"},
                        {"Karan Nag"},
                        {"Karan Nag"},
                        {"Karan Nag"},
                        {"Karan Nag"},
                        {"Karan Nag"},
                        {"Karan Nag"},
                        {"Karan Nag"},
                        {"Karan Nag"},
                        {"Karan Nag"},
                        {"Arjun Nag"}

                };
    }

    @Test(dataProvider = "getData")
    public void openURL(String value) {
        WebDriver driver;

        //System.setProperty("webdriver.chrome.driver", "/Users/admin/Documents/GitHub/seleniumGridLearning/src/test/resources/chromedriver");
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

       // driver.manage().window().maximize();

        driver.get("https://www.google.com/");

        driver.findElement(By.name("q")).sendKeys(value + Keys.ENTER);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        List<WebElement> array = driver.findElements(By.xpath("//div[@id='search']//h2/../div/div//div/div/a/h3"));
System.out.println(array.size());

        for (int i = 0; i < array.size(); i++) {
            System.out.println(i+1);
            System.out.println(array.get(i).getText());
            System.out.println(array.get(i).findElement(By.xpath("./..//cite")).getText());

        }
        driver.quit();
    }


    @AfterMethod(alwaysRun = true)
    public void closeBrowser()
    {
       // driver.quit();
    }
}

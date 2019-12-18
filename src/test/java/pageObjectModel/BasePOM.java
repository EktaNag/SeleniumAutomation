package pageObjectModel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BasePOM
{

    WebDriver driver;
    //Make a constructor to initialize value of driver
    public BasePOM(WebDriver d)
    {
        driver=d;
    }

    public void getText(By locator)
    {
        driver.findElement(locator).getText();
    }

    public void sendKeys(By locator, String name)
    {
        driver.findElement(locator).sendKeys(name);
    }

    public void click(By locator)
    {
        driver.findElement(locator).click();
    }




}

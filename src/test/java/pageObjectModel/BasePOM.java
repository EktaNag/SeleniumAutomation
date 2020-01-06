package pageObjectModel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class BasePOM
{

    WebDriver driver;
    //Make a constructor to initialize value of driver
    public BasePOM(WebDriver d)

    {
        driver=d;
    }

    public String getText(By locator)
    {
        return driver.findElement(locator).getText();
    }


    public void sendKeys(By locator, String name)
    {
        driver.findElement(locator).sendKeys(name);
    }

    public void clearPlaceholder(By locator)
    {
        driver.findElement(locator).clear();
    }


    public void click(By locator)
    {
        driver.findElement(locator).click();
    }

public String getCurrentURL()
{
    return driver.getCurrentUrl();
}

public void hoverMouse(WebElement element)
{
    Actions action = new Actions(driver);
    action.moveToElement(element).build().perform();
}


}

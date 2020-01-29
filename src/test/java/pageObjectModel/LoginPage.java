package pageObjectModel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class LoginPage extends BasePOM
{
    //Initializing the value of driver from basePOM class
    public LoginPage(WebDriver newDriver)
    {
        super(newDriver);
    }
    //Page locators
    By searchBox=By.name("q");
    By headings=By.xpath("//div[@id='search']//h2/../div/div//div/div/a/h3");
    By secondLineText=By.xpath("./..//cite");


    //page Methods/actions

    public void searchValue(String value)
    {
        click(searchBox);
        sendKeys(searchBox,value);
    }

public void getSearchResultHeadingWithLinks()
{

List<WebElement> listHeadings = driver.findElements(headings);

for(int i=0;i<listHeadings.size();i++)
{
    System.out.println(listHeadings.get(i).getText());
    System.out.println(listHeadings.get(i).findElement(secondLineText).getText());
}


}






}

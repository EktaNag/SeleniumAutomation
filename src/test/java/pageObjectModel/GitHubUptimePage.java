package pageObjectModel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import shared.Utils;

import java.util.List;

public class GitHubUptimePage extends BasePOM {
    public GitHubUptimePage(WebDriver d) {
        super(d);
    }
    //By outageMonthName= By.xpath("//div[@class='uptime-calendar-display']/div[@class='calendar-month']/div[@class='month-header']/small[not(contains(.,'100'))]/../h6");

    By leftClick = By.xpath("//div[@class='uptime-header']/div[@class='pagination-container']//a[1]/i");

    By monthStart = By.xpath("//div[@class='uptime-calendar']//div[@class='pagination-container']/div[@class='pagination']/span/span[1][contains(.,'')]");
    By yearStart = By.xpath("//div[@class='uptime-calendar']//div[@class='pagination-container']/div[@class='pagination']/span/var[1][contains(.,'')]");


    By colorOutage = By.xpath("//div[@class='calendar-month']/div[@class='days']//*[contains(@fill,'#85a926') or contains(@fill,'#baaa14') or contains(@fill,'#e17609')]");
    By colorOutageMonthName = By.xpath("./../../..//div[@class='month-header']/h6");
    By date = By.xpath("//div[@id='uptime-tooltip']//p");

    public void getOutageDetails() {
//WebElement monthBeginName=driver.findElement(monthStart);
//while(!(monthBeginName.getText().matches("February")))

        WebElement yearStartMonth = driver.findElement(yearStart);
        while (!(yearStartMonth.getText().matches("2017"))) {
            List<WebElement> outage = driver.findElements(colorOutage);
            for (int i = 0; i < outage.size(); i++) {
                List<WebElement> outageMonths = outage.get(i).findElements(colorOutageMonthName);
                System.out.println("Outage in the month of -  " + outageMonths.get(i).getText());
                hoverMouse(outage.get(i));
                System.out.println(driver.findElement(date).getText());
            }
            click(leftClick);
            Utils.iWait(2);
        }
        System.out.println("**************");

    }


}

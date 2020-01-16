package pageObjectModel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import shared.Utils;

import java.util.List;

public class GitHubUptimeOutagePage extends BasePOM {
    //constructor to initialize the value of WebDriver d
    public GitHubUptimeOutagePage(WebDriver d) {
        super(d);
    }

    //Capturing page objects
    By currentYear = By.xpath("//div[@class='calendar-month'][3]/div[@class='month-header']/h6/*[@data-var='year']");
    By rightArrow = By.xpath("//div[@class='uptime-header']/div[@class='pagination-container']//a[2]/i");
//By december=By.xpath("//div[@class='calendar-month']/div[@class='month-header']/h6[contains(.,'December')]");
//By monthName=By.xpath("//div[@class='calendar-month']/div[@class='month-header']/h6[contains(.,'')]");

//    By colorOutage = By.xpath("//div[@class='calendar-month']/div[@class='days']//*[contains(@fill,'#85a926') or contains(@fill,'#baaa14') or contains(@fill,'#e17609')]");

    By colorOutageMonthName = By.xpath("./../../..//div[@class='month-header']/h6");
    By date = By.xpath("//div[@id='uptime-tooltip']//p");


//creating page functions


    public void getYear(int userYear) {
        String getCurrentYear = driver.findElement(currentYear).getText();

        int difference = Integer.parseInt(getCurrentYear) - userYear;
        int getPage = (difference * 4) + 1;

        Utils.iWait(5);
        //System.out.println(getCurrentYear);

        for (int j = 0; j < 5; j++) {

            driver.get("https://www.githubstatus.com/uptime?page=" + (getPage-j));

            List<WebElement> outage = driver.findElements(By.xpath("//div[@class='calendar-month']/div[@class='month-header' and contains(.,'"+userYear+"')]/../div[@class='days']//*[contains(@fill,'#85a926') or contains(@fill,'#baaa14') or contains(@fill,'#e17609')]"));

            for (int i = 0; i < outage.size(); i++) {
               // System.out.println("***********************************");

                //System.out.println("The outage size is : " + outage.size());
                //List<WebElement> outageMonths = outage.get(i).findElements(colorOutageMonthName);
                //System.out.println("Outage in the month of -  " + outageMonths.get(i).getText());
                hoverMouse(outage.get(i));
                System.out.println(driver.findElement(date).getText());
//                click(rightArrow);

               // System.out.println("***********************************");
            }
        }
        Utils.iWait(2);

    }


}

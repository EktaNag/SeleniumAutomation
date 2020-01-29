package pageObjectModel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import shared.Utils;

import java.util.List;

public class GithubstatusLogin extends BasePOM {
    public GithubstatusLogin(WebDriver d) {
        super(d);
    }

    //page objects of GitHubStatus page
    By pageHeadings = By.xpath("//div[contains(@class,'components-container')]/div/div[contains(@class,'component-inner-container') and contains(@class,'showcased')]//span[@class='name']");
    By colors = By.xpath("./../div/*[@class='availability-time-line-graphic']/*[not(contains(@fill,'#28a745'))]");
    By date = By.xpath("//div[@class='tooltip-content']/div[@class='date']");
    //div[@class='components-container one-column']/div[1]/div[@class='component-inner-container status-green showcased']//span[@class='name']/../div/*[@class='availability-time-line-graphic']/*[not(contains(@fill,'#28a745'))]/../../../../../../../div[@id='uptime-tooltip']//div[@class='tooltip-content']/div[@class='date']
//    By timeHours=By.xpath("//div[@class='outages']/div[@class='outage-field major']//span[@class='value-hrs']");
    By timeHours = By.xpath("//div[@class='outages']/div[contains(@class,'outage-field') and not(contains(@style,'none'))]//span[@class='value-hrs']");
    By timeMinutes = By.xpath("//div[@class='outages']/div[contains(@class,'outage-field') and not(contains(@style,'none'))]//span[@class='value-mins']");


    //Functions for GitHubStatus page
    public void printHeadings() {
        List<WebElement> headings = driver.findElements(pageHeadings);
        System.out.println("Categories count is :" + headings.size());

        for (int i = 0; i < headings.size(); i++) {
            System.out.println(headings.get(i).getText());

            List<WebElement> colorsErrors = headings.get(i).findElements(colors);
            System.out.println("Outage count is :" + colorsErrors.size());

            for (int j = 0; j < colorsErrors.size(); j++) {

                hoverMouse(colorsErrors.get(j));
                System.out.println(driver.findElement(date).getText());
                System.out.print(driver.findElement(timeHours).getText());
                System.out.print("\t" + driver.findElement(timeMinutes).getText() + "\n");

                hoverMouse(headings.get(i));
            }
            System.out.println("\n\n");
            System.out.println("*******************");
        }
    }

}

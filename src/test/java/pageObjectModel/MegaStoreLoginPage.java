package pageObjectModel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import shared.Utils;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MegaStoreLoginPage extends BasePOM {


    //Initialize the value of WebDriver by the constructor
    public MegaStoreLoginPage(WebDriver driver) {
        super(driver);
    }


    //Creating Page objects for the US MegaStore page

    By Alldepartments = By.xpath("//header//div[@id='search']//select[@id='departments']");
    By allSearchList = By.xpath("//header//div[@id='search']//select[@id='departments']/option");

    By promotionHeader = By.xpath("//div[@id='responsive-menu']//a[text()='Promotions']");
    By lastChanceItemDescription = By.xpath("//h3[text()='Last Chance Deals']/..//article/div/h3/a");
    By lastChanceSalePrice = By.xpath("//h3[text()='Last Chance Deals']/..//article/div/ul/li/span[text()='Sale Price:']/../div/strong");

    By allLimitedTimeOffers = By.xpath("//section[@class='promos-list']//figure/img");
    By showMoreButton = By.xpath("//button[@class='show-more']");

    By departmentsDropDown = By.xpath("//div[@id='responsive-menu']//span[text()='Shop by']");
    By categories = By.xpath("//ul[@class='dropdown-menu header-dropdown']/li//span/..");
    // By subCategories = By.xpath("//ul[@class='dropdown-menu header-dropdown']/li//span/../../div/ul[@class='categories']/li/a[not(contains(.,'View All'))]");
    By subCategories = By.xpath("//div[contains(@class,'open') and contains(@class,'container-dropdown')]/ul[1]/li[not(contains(@class,'view-all'))]");

    //Creating all the methods for the US MegaStore page

    public void clickOnDepartment() {
        int total = 0;
        Utils.iWait(2);
        click(Alldepartments);

        List<WebElement> searchList = driver.findElements(allSearchList);
        System.out.println("The search List options are as follows");
        for (int i = 0; i < searchList.size(); i++) {
            System.out.println(searchList.get(i).getText());
            total = i++;
        }
        System.out.println("The total count of the serach List Options = " + total);
        click(Alldepartments);
    }

    public void promotionsHeader() {
        click(promotionHeader);
        Utils.iWait(1);
        List<WebElement> lastChanceItemsDescription = driver.findElements(lastChanceItemDescription);
        List<WebElement> lastChanceItemsSalePrice = driver.findElements(lastChanceSalePrice);

        for (int i = 0; i < lastChanceItemsDescription.size(); i++) {
            System.out.println(lastChanceItemsDescription.get(i).getAttribute("innerText"));
            System.out.println(lastChanceItemsSalePrice.get(i).getAttribute("innerText"));
        }
        System.out.println("*************************");

    }

    public void getAllLimitedTimeOffers() {
        WebElement button;
        button = driver.findElement(showMoreButton);
        while (button.isDisplayed()) {
            try {
                Utils.iWait(1);
                click(showMoreButton);
                Utils.iWait(1);

            } catch (Exception e) {
                System.out.println("No more clicks");
            }
        }
        List<WebElement> limitedTimeOfferTitle = driver.findElements(allLimitedTimeOffers);
        System.out.println("Size of limitedTimeOffers is " + limitedTimeOfferTitle.size());


        for (int i = 0; i < limitedTimeOfferTitle.size(); i++) {
            System.out.println(limitedTimeOfferTitle.get(i).getAttribute("title"));
            System.out.println(limitedTimeOfferTitle.get(i).getAttribute("currentSrc"));

//            1. Get the SRC attribute of the image.
//            2. Use ImageIO.read to read the image onto a BufferedImage
//            3. Save the BufferedImage using ImageIO.write function

            String src = limitedTimeOfferTitle.get(i).getAttribute("currentSrc");

            BufferedImage bufferedImage = null;
            try {
                bufferedImage = ImageIO.read(new URL(src));
            } catch (IOException e) {
                e.printStackTrace();
            }

            File outputfile = new File("/Users/admin/Documents/GitHub/SeleniumAutomation/src/test/java/shared/ImageFiles/Image" + i + ".jpg");
            try {
                ImageIO.write(bufferedImage, "jpg", outputfile);
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }


    public void getMenuDetails() {

        Utils.iWait(1);
        click(departmentsDropDown);
        List<WebElement> DDcategories = driver.findElements(categories);
        System.out.println("DDcategories size :" + DDcategories.size());

        for (int i = 0; i < DDcategories.size(); i++) {
            hoverMouse(DDcategories.get(i));

            List<WebElement> DDsubCategories = driver.findElements(subCategories);
            for (int j = 0; j < DDsubCategories.size(); j++) {

                String cat = DDsubCategories.get(j).getText();

                System.out.print("          "+DDcategories.get(i).getText());
                System.out.print("                      " + cat.split("\\(")[0]);
                System.out.print("                      " + cat.split("\\(")[1].split("\\)")[0]);
                System.out.println();


            }

        }
    }
}


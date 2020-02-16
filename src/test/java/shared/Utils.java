package shared;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Utils {

    public static WebDriver browserLaunch(String executionType) {
        WebDriver driver = null;


        switch (executionType.toLowerCase()) {
            case "local":
                WebDriverManager.chromedriver().setup();
                ChromeOptions options = new ChromeOptions();
                options.setExperimentalOption("useAutomationExtension", false);
                options.setExperimentalOption("excludeSwitches", Collections.singletonList("enable-automation"));
                driver = new ChromeDriver(options);
                break;

            case "remote":

                DesiredCapabilities capability=new DesiredCapabilities();
                capability.setBrowserName("chrome");

                try {
                    driver=new RemoteWebDriver(new URL("http://127.0.0.1:4040/wd/hub"),capability);
// ip address or loopback address is localhost because server is running on our local machine
                   // driver=new RemoteWebDriver(new URL("http://192.168.2.251:4040/wd/hub"),capability);//ip address is localhost because server is running on our local machine
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                }


                break;
            default:
                System.out.println("Execution type not supported=" + executionType);

        }

        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        //driver.manage().window().setSize(new Dimension(400,400));
        //getWindowResolution("400","400",driver);
        return driver;
    }


public static void getWindowResolution(String xaxis,String yaxis,WebDriver driver)
    {

        driver.manage().window().setSize(new Dimension(Integer.parseInt(xaxis),Integer.parseInt(yaxis)));

    }


    public static void iWait(long seconds){
        try {
            Thread.sleep(seconds*1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    //This method is to capture the screenshot and return the path of the screenshot.

    public static String getScreenhot(WebDriver driver, String screenshotName) throws Exception {
        String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
        TakesScreenshot ts = (TakesScreenshot) driver;
        File source = ts.getScreenshotAs(OutputType.FILE);
        //after execution, you could see a folder "FailedTestsScreenshots" 
        String destination = "F:\\GitHub25thJan2020\\ExtentReportSeleniumAutomationProject\\FailedTestCasesScreenshot"+screenshotName+dateName+".png";
        File finalDestination = new File(destination);
        FileUtils.copyFile(source, finalDestination);
        return destination;
    }










}

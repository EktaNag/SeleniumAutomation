package shared;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Collections;
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
//                    driver=new RemoteWebDriver(new URL("http://127.0.0.1:4444/wd/hub"),capability);//ip address or loopback address is localhost because server is running on our local machine
                    driver=new RemoteWebDriver(new URL("http://192.168.2.251:4444/wd/hub"),capability);//ip address is localhost because server is running on our local machine
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
}

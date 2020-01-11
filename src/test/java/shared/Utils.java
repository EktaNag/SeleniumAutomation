package shared;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class Utils {

    public static WebDriver browserLaunch(String executionType) {
        WebDriver driver = null;

        switch (executionType.toLowerCase()) {
            case "local":
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                break;

            case "remote":

                DesiredCapabilities capability=new DesiredCapabilities();
                capability.setBrowserName("chrome");

                try {
                    driver=new RemoteWebDriver(new URL("http://192.168.2.251:4444/wd/hub"),capability);
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                }


                break;
            default:
                System.out.println("Execution type not supported=" + executionType);

        }

        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        return driver;
    }

    public static void iWait(long seconds){
        try {
            Thread.sleep(seconds*1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

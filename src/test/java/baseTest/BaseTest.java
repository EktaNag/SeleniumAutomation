package baseTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.SkipException;
import org.testng.annotations.*;
import shared.Utils;

import java.lang.reflect.Method;

public class BaseTest  {

    String testEnv = "www.rogers.com";
    WebDriver driver;
    ExtentReports report;
    ExtentHtmlReporter htmlReporter;
    ExtentTest extentTest;


    @BeforeSuite
    public void startUpReport()
    {
         report=new ExtentReports();
         htmlReporter=new ExtentHtmlReporter("F:\\GitHub25thJan2020\\ExtentReportSeleniumAutomationProject\\ExtentReport.html");
        htmlReporter.config().setDocumentTitle("Title of the Report Comes here");
        htmlReporter.config().setReportName("Name of the Report Comes here");
        htmlReporter.config().setTestViewChartLocation(ChartLocation.TOP);
        htmlReporter.config().setTheme(Theme.STANDARD);

         report.attachReporter(htmlReporter);

        report.setSystemInfo("Host Name", "Adding the Extent Report Version 3");
        report.setSystemInfo("Environment", "Automation Testing");
        report.setSystemInfo("User Name", "Ekta Nag");



    }

    @BeforeMethod(alwaysRun = true)
    public void setUp(Method method)
    {

        extentTest = report.createTest(method.getName());


        driver=Utils.browserLaunch("local");
        System.out.println("The method name is : "+method.getName());
        System.out.println();
    }

    @AfterMethod(alwaysRun = true)
    public void closeBrowser(ITestResult result)
    {
        if(result.getStatus() == ITestResult.FAILURE){

            extentTest.log(Status.FAIL, MarkupHelper.createLabel(result.getName() + " - Test Case Failed", ExtentColor.RED));
            extentTest.log(Status.FAIL, MarkupHelper.createLabel(result.getThrowable() + " - Test Case Failed", ExtentColor.RED));
        }
        else if(result.getStatus() == ITestResult.SKIP){

            extentTest.log(Status.SKIP, MarkupHelper.createLabel(result.getName() + " - Test Case Skipped", ExtentColor.ORANGE));
        }
        else {
            extentTest.log(Status.PASS, MarkupHelper.createLabel(result.getName() + "Test is passed", ExtentColor.GREEN));
        }
            driver.quit();

    }

    @AfterSuite
    public void endReport() {
        report.flush();

    }
}




// Jenkins token - beb8fe72837294390bf1bd7c9fe3def0af319f4c

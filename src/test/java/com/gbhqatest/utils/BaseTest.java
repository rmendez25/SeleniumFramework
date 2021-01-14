package com.gbhqatest.utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Date;

public class BaseTest {
    //TO SEE HOW TO IMPLEMENT THIS BASE TEST CLASS SEE THE EXAMPLE IN THE TEST PACKAGE

    //CREATE A WEB DRIVER INSTANCE, SO YOU DONT NEED TO CREATE IT IN EVERY TEST CLASS
    String url = "https://gbhqatest.firebaseapp.com/";//Url for the AUT
    String loggerClass = "";
    protected Logger logger = Logger.getLogger(loggerClass);
    public ExtentHtmlReporter htmlReporter;
    public ExtentReports extent;
    public ExtentTest extentTest;
    public WebDriver driver;

    //THIS WILL EXECUTE BEFORE EVERY TEST CLASS BEFORE
    @BeforeClass
    public void setup() {
        PropertyConfigurator.configure(System.getProperty("user.dir") + "\\resources\\log.properties");
        DriverFactory.getInstance().setDriver(BrowserType.CHROME);
        driver = DriverFactory.getInstance().getDriver();
        driver.get(url);
    }

    //THIS WILL CLOSE AND KILL THE DRIVER AFTER EVERY TEST CLASS BEFORE
    @AfterClass
    public void cleanUp() {
        if (driver != null) {
            driver.close();
            driver.quit();
        }
    }

    //THIS METHOD JUST RETURN THE DRIVER
    public WebDriver getDriver() {
        return driver;
    }

}

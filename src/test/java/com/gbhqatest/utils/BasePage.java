package com.gbhqatest.utils;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;


public class BasePage {
    //TO SEE HOW TO IMPLEMENT THIS BASE PAGE CLASS SEE THE EXAMPLE IN THE PAGE PACKAGE

    //THIS ARE SOME OBJECT AND VARIABLES TO REUSE IN EVERY PAGE CLASS
    protected WebDriver driver;
    private final WebDriverWait wait;
    private static final int TIMEOUT = 10;
    private static final int POLLING = 100;
    //protected Logger logger = LogManager.getLogger();

    //CONSTRUCTOR TO USE IN EVERY PAGE CLASS
    public BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, TIMEOUT, POLLING);
    }

    //METHOD TO WAIT FOR AN ELEMENT TO DISAPPEAR
    protected void waitForElementToDisappear(WebElement element) {
        wait.until(ExpectedConditions.invisibilityOf(element));
    }

    //METHOD TO WAIT FOR AN ELEMENT TO BE VISIBLE
    protected void waitForElementToAppear(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    //METHOD TO WAIT FOR THE FULL PAGE IS LOADED
    protected void waitForLoad(WebDriver driver) {
        ExpectedCondition<Boolean> pageLoadCondition = new
                ExpectedCondition<Boolean>() {
                    public Boolean apply(WebDriver driver) {
                        return ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete");
                    }
                };
        wait.until(pageLoadCondition);
    }

    //METHOD TO TAKE SCREENSHOTS
    protected void takeSnapShot(WebDriver driver, String name) throws IOException {
        TakesScreenshot srcShot = (TakesScreenshot) driver;
        File srcFile = srcShot.getScreenshotAs(OutputType.FILE);
        File destFile = new File(System.getProperty("user.dir") + "\\photos\\" + name + ".png");
        FileUtils.copyFile(srcFile, destFile);
    }
}

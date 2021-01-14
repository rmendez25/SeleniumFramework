package com.gbhqatest.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverFactory {
    private DriverFactory() {

    }

    private final static DriverFactory instance = new DriverFactory();

    public static DriverFactory getInstance() {
        return instance;
    }

    ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>() {
        @Override
        protected WebDriver initialValue() {
            return null;
        }
    };

    public WebDriver getDriver() {
        return driver.get();
    }

    public WebDriver setDriver(BrowserType browser) {
        String osName = System.getProperty("os.name").toLowerCase().contains("mac") ? "mac" : "windows";
        String driverPath = System.getProperty("user.dir") + "\\drivers\\";

        switch (browser.toString()) {
            case "CHROME":
                if (osName.equals("windows")) {
                    System.setProperty("webdriver.chrome.driver", driverPath + "chromedriver.exe");
                } else {
                    System.setProperty("webdriver.chrome.driver", driverPath + "chromedriver");
                }
                driver.set(new ChromeDriver());
                break;
            case "FIREFOX":
                if (osName.equals("windows")) {
                    System.setProperty("webdriver.gecko.driver", driverPath + "geckodriver.exe");
                } else {
                    System.setProperty("webdriver.chrome.driver", driverPath + "geckodriver");
                }
                driver.set(new ChromeDriver());
                break;
        }
        try {
            driver.get().manage().window().maximize();

        } catch (WebDriverException we) {
            driver.set(new ChromeDriver());
            driver.get().manage().window().maximize();
        }
        return driver.get();
    }
}

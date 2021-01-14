package com.selenium.utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import java.io.File;
import java.util.Date;

public class ExtentManager {
    private static ExtentReports extent;

    public static ExtentReports createInstance(){
        String fileName = getReportName();
        String directory = System.getProperty("user.dir") + "\\reports\\";
        new File(directory).mkdir();
        String path = directory + fileName;

        ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter(path);
        htmlReporter.config().setEncoding("uft-8");
        htmlReporter.config().setDocumentTitle("GBH QA Test Reports");
        htmlReporter.config().setReportName("Automation Tests Results");
        htmlReporter.config().setTheme(Theme.DARK);

        extent = new ExtentReports();
        extent.setSystemInfo("", "");
        extent.setSystemInfo("Browser", "Chrome");
        extent.attachReporter(htmlReporter);

        return extent;
    }

    public static String getReportName() {
        Date d = new Date();
        String fineName = "AutomationReport_" + "_" + d.toString().replace(":", "_").replace(" ", "_") + ".html";
        return fineName;
    }

}

package com.selenium.reports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.selenium.constants.FrameworkConstants;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.Objects;

public final class ExtentReport {

    private ExtentReport() {

    }

    private static ExtentReports extent;

    public static void initReports() {
        if(Objects.isNull(extent)) {
            extent = new ExtentReports();
            ExtentSparkReporter spark = new ExtentSparkReporter(FrameworkConstants.getEXTENTREPORTFILEPATH());
            extent.attachReporter(spark);
            spark.config().setTheme(Theme.DARK);
            spark.config().setDocumentTitle("Test Automation Report");
            spark.config().setReportName("Selenium Framework Demo");
        }
    }

    public static void flushReports() throws IOException {
        if(Objects.nonNull(extent)) {
            extent.flush();
        }
    }

    public static void createTest(String testcasename) {
        ExtentTest test = extent.createTest(testcasename);
        ExtentManager.setExtentTest(test);

    }

}

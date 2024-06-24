package org.QA.util;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import org.apache.logging.log4j.Logger;

import java.util.HashMap;
import java.util.Map;

public class ExtentTestManager {


    static Map<Integer,ExtentTest> extentTestMap = new HashMap<>();

    //private static final ThreadLocal<ExtentTest> extentTestThreadLocal = new ThreadLocal<>();


    static ExtentReports report = ExtentManager.createExtentReport();

    public static synchronized ExtentTest getTest(){
        return extentTestMap.get((int) Thread.currentThread().getId());
       // return extentTestThreadLocal.get();

    }

    public static synchronized ExtentTest startTest(String testName){
        ExtentTest test=report.createTest(testName);
        extentTestMap.put((int) Thread.currentThread().getId(),test);
        //extentTestThreadLocal.set(test);
        if (test != null) {
            test.log(Status.INFO, "Details about the step");
        } else {
            System.out.println("ExtentTest not initialized");
        }
        return test;
    }

    public static synchronized void step(Logger logger, String log){
        ExtentTest test = getTest();

        test.log(Status.INFO, MarkupHelper.createLabel("Performing"+log, ExtentColor.INDIGO));
    }
}

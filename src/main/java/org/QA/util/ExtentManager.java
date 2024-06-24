package org.QA.util;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ExtentManager {

    public static final ExtentReports extendReport = new ExtentReports();

    public static ExtentReports createExtentReport() {

        String Date = formateDate("dd-MM-yyyy");
        String time = formateDate("HH-mm-ss");
        String reportFolderName = "AutomationTestResults_"+Date;
        String html = "index_"+time;

        String path = System.getProperty("user.dir") + "//test-output//" + reportFolderName + "//" + html + ".html";


        ExtentSparkReporter reporter = new ExtentSparkReporter(path);
        reporter.config().setReportName("Test Automation Results");
        reporter.config().setDocumentTitle("Tesla Test Automation Report");
        extendReport.attachReporter(reporter);
        return extendReport;
    }

    public static String formateDate(String pattern){

        Date present = new Date();

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);

        return simpleDateFormat.format(present).toString();
    }

}

package org.QA.util;
import com.aventstack.extentreports.Status;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import static org.QA.util.ExtentTestManager.getTest;
import static org.QA.util.ExtentTestManager.startTest;


public class Listners implements ITestListener{


    private static String getTestMethodName(ITestResult result){
        return result.getMethod().getConstructorOrMethod().getName();

    }

    @Override
    public void onStart(ITestContext context) {
        Log.info("About to begin executing Test "+context.getName());

    }

    @Override
    public void onFinish(ITestContext context) {
        Log.info("I am on finished Method "+context.getName());
        ExtentManager.extendReport.flush();

    }


    @Override
    public void onTestStart(ITestResult result) {
          Object[] parameter=result.getParameters();
          try{
              if(parameter!=null && parameter.length >0){
                  startTest(parameter[0].toString());
                  getTest().log(Status.INFO,"Scenario Started"+result.getMethod().getMethodName()+">"+parameter[0].toString());
              }

          }
          catch(Exception e){
              System.out.println("not parameters found");
          }


    }

    @Override
    public void onTestSuccess(ITestResult result) {
        Object[] parameter=result.getParameters();
        try {
            if (parameter != null && parameter.length > 0) {
                Log.info( "Scenario Passed" + result.getMethod().getMethodName() + ">" + parameter[0].toString());
                getTest().log(Status.INFO,"Scenario Started"+result.getMethod().getMethodName()+">"+parameter[0].toString());

            }
        }
              catch(Exception e){
                System.out.println("not parameters found");
            }

        }

    @Override
    public void onTestFailure(ITestResult result) {
        Log.info(getTestMethodName(result)+"Scenario Failed");
       getTest().log(Status.FAIL,"Scenario Failed"+result.getThrowable());
    }

    @Override
    public void onTestSkipped(ITestResult result) {

        getTest().log(Status.SKIP,"Scenario Passed"+result.getThrowable());
        getTest().log(Status.INFO,"Scenario Skipped at "+result.getMethod().getMethodName());
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        Log.warn("Test failed but it is in defined success ratio");
    }





}

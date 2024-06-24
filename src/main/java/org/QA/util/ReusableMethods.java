package org.QA.util;

import org.QA.factory.DriverFactory;
import org.openqa.selenium.JavascriptException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;

public class ReusableMethods {


    WebDriver driver = DriverFactory.getDriver();

    public void clickOnWebElement(WebElement e, long waitTimeInSeconds){
        WebDriverWait wait = new WebDriverWait(driver, waitTimeInSeconds);
        WebElement element=wait.until(ExpectedConditions.elementToBeClickable(e));
        element.click();
    }

    public void javaScriptClick(WebElement element){
        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) DriverFactory.getDriver();
        javascriptExecutor.executeScript("arguments[0].click()",element);
    }

    public void moveToElement(WebElement element){
        Actions action = new Actions(DriverFactory.getDriver());
        action.moveToElement(element).build().perform();

    }

    public String getTextOfAnElement(WebElement element){
        return element.getText();
    }

    public void selectByIndex(WebElement element,int index){
        Select select = new Select(element);
        select.selectByIndex(index);
    }

    public void selectByVisibleText(WebElement element,String VisibleText){
        Select select = new Select(element);
        select.selectByVisibleText(VisibleText);
    }

    public void selectByValue(WebElement element,String value){
        Select select = new Select(element);
        select.selectByVisibleText(value);
    }

    public void doubleClick(WebElement element){
        new Actions(DriverFactory.getDriver()).doubleClick(element).build().perform();
    }





}

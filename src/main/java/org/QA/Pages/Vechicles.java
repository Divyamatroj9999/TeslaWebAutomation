package org.QA.Pages;

import org.QA.factory.DriverFactory;
import org.QA.util.ReusableMethods;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;

public class Vechicles {
    ReusableMethods reusableMethods = new ReusableMethods();

    public Vechicles() throws IOException {
        PageFactory.initElements(DriverFactory.getDriver(),this);
    }

    @FindBy(xpath = "")
    public WebElement vehiclesHeader;

    public void clickVechicle(){
        reusableMethods.clickOnWebElement(vehiclesHeader,10);
    }


}

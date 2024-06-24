package org.QA.Pages;

import org.QA.factory.DriverFactory;
import org.QA.util.ConfigReader;
import org.QA.util.ReusableMethods;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;

public class Home {

    ReusableMethods reusableMethods = new ReusableMethods();

    public Home() throws IOException {
        PageFactory.initElements(DriverFactory.getDriver(),this);
    }


    @FindBy(xpath = "//button[@id='dx-nav-item--vehicles']")
    public WebElement vehiclesHeader;

    public void launchApp() throws IOException {
        DriverFactory.getDriver().get(ConfigReader.init_prop().getProperty("url"));
    }

    public void clickVechicle(){
        reusableMethods.clickOnWebElement(vehiclesHeader,10);
    }
}

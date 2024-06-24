package org.QA.Pages;

import org.QA.factory.DriverFactory;
import org.QA.util.ReusableMethods;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Listeners;

import java.io.IOException;

@Listeners(org.QA.util.Listners.class)
public class Vechicles {
    ReusableMethods reusableMethods = new ReusableMethods();

    public Vechicles() throws IOException {
        PageFactory.initElements(DriverFactory.getDriver(),this);
    }


    @FindBy(xpath = "(//a[text()='Inventory'])[1]")
    public WebElement Inventory;


    public void clickInventory(){
        reusableMethods.clickOnWebElement(Inventory,10);
    }




}

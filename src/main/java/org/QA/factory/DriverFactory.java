package org.QA.factory;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.QA.util.ConfigReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.IOException;

public class DriverFactory {

    private static ThreadLocal<WebDriver> driver = new ThreadLocal();


     static String browserName = ConfigReader.init_prop().getProperty("browser");

    public static void init_browser() {


        switch (browserName.toLowerCase()) {
            case "chrome":
                WebDriverManager.chromedriver().setup();
                driver.set(new ChromeDriver());
                break;
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                driver.set(new ChromeDriver());
                break;
            case "edge":
                WebDriverManager.edgedriver().setup();
                driver.set(new ChromeDriver());
                break;
            default:
                throw new IllegalArgumentException("Browser not supported: " + browserName);
        }


    }


    public static WebDriver getDriver() {
        return driver.get();
    }

    public static void closeBrowser(){
        driver.get().quit();
        driver.remove();
    }

}



package QA.TestNgClasses;

import org.QA.Pages.Home;
import org.QA.Pages.Vechicles;
import org.QA.factory.DriverFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;

public class CheckInventory {
    static final Logger log= LogManager.getLogger(LaunchApp.class);
    @BeforeMethod
    public void setUp(){
        DriverFactory.init_browser();
    }

    @Test
    public void launchBrowser() throws IOException {
        Home home= new Home();
        Vechicles vechicles= new Vechicles();

        home.launchApp();
        home.clickVechicle();
        vechicles.clickInventory();
    }

    @AfterMethod
    public void afterTest(){
        DriverFactory.closeBrowser();
    }
}

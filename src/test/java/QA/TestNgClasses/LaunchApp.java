package QA.TestNgClasses;

import org.QA.Pages.Home;
import org.QA.factory.DriverFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.*;

import java.io.IOException;

@Listeners(org.QA.util.Listners.class)
public class LaunchApp {

    static final Logger log= LogManager.getLogger(LaunchApp.class);

    @BeforeMethod
    public void setUp(){
        DriverFactory.init_browser();
    }

    @Test
    public void launchBrowser() throws IOException {
        Home home= new Home();
        home.launchApp();
    }

    @Test
    public void launchBrowser2() throws IOException {
        Home home= new Home();
        home.launchApp();
    }

    @Test
    public void launchBrowser3() throws IOException {
        Home home= new Home();
        home.launchApp();
    }

    @AfterMethod
    public void afterTest(){
        DriverFactory.closeBrowser();
    }

   /* @DataProvider(name ="home")
    public Object[][] Home(ITestContext context){
       return object;
    }*/
}

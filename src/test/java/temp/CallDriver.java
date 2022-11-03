package temp;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import utils.Browsers;
import utils.Driver;


public class CallDriver {

    WebDriver driver;

    @Test
    public void testCallDriver(){
        //Driver.getDriver(Browsers.FIREFOX).get("https://google.com");
        //Driver.getDriver().get("https://yahoo.com");

        driver = Driver.getDriver(Browsers.FIREFOX);
        driver.get("https://google.com");
        driver.get("https://yahoo.com");

    }

}

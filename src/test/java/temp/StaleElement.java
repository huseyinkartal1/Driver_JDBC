package temp;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import pages.BaseTest;
import pages.LocatorInterface;

public class StaleElement extends BaseTest implements LocatorInterface {

    @Test
    public void staleElement(){
        driver.get(url);
        sendKeys(usernameInputLogin, "demo");
        driver.navigate().refresh();
        sendKeys(usernameInputLogin, "demo");
    }


    @Test
    public void staleElement2(){
        driver.get(url);
        WebElement userName = wait.until(ExpectedConditions.visibilityOfElementLocated(usernameInputLogin));
        userName.sendKeys("demo");
        driver.navigate().refresh();
        userName.sendKeys("demo");
    }


    @AfterTest
    public void afterTest(){
        driver.quit();
    }

}

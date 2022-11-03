package temp;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import pages.BaseTest;
import pages.LocatorInterface;
import static utils.MenuButtons.*;   //26 ve 27.satır
import utils.Waits;

public class ClickMenus extends BaseTest implements LocatorInterface {

    By locatorCustomers = By.xpath("//header//a[./span[text()='Customers'] or text()='Customers']");
    By locatorEmployees = By.xpath("//header//a[./span[text()='Employees'] or text()='Employees']");

    @Test
    public void test01(){
        driver.get(url);

        sendKeys(usernameInputLogin, "demo");
        sendKeys(passwordInputLogin, "demo");
        click(buttonSubmitLogin);
        waitForElement(buttonLogout, Waits.VISIBILITY);

        //click(locatorCustomers);
        //click(locatorEmployees);

        EMPLOYEES.click();
        CUSTOMERS.click();

        driver.quit();

    }

}

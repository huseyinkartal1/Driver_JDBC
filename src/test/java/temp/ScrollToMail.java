package temp;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.BaseTest;
import pages.LocatorInterface;
import utils.Waits;

import java.sql.*;
import java.util.List;

public class ScrollToMail extends BaseTest implements LocatorInterface {
    Connection conn;
    Statement statement;
    ResultSet resultSet;
    String email;

    @BeforeTest
    public void beforeTest() throws SQLException {

        conn = DriverManager.getConnection(
                "jdbc:mysql://142.93.110.12:3306/admindashboarddb",
                "gsuser",
                "Gsuser!123456");
        statement = conn.createStatement();
        statement.setQueryTimeout(30);
        resultSet = statement.executeQuery("SELECT email FROM customers WHERE id=123;");
        resultSet.next();
        email = resultSet.getString(1);
        conn.close();
        statement.close();
    }

    @AfterTest
    public void afterTest(){
        driver.quit();
    }

    @Test
    public void login(){
        driver.get(url);
        sendKeys(usernameInputLogin, "demo");
        sendKeys(passwordInputLogin, "demo");
        click(buttonSubmitLogin);
        waitForElement(buttonLogout, Waits.VISIBILITY);
    }

    @Test
    public void test2() {
        click(By.xpath("//header//a[./span[text()='Customers']]"));
        waitForElement(By.cssSelector("datatable-header"), Waits.VISIBILITY);
        while (true){
            scrollBy(700);
            By emailLocator = By.xpath("//span[text()='" + email + "']");
            List< WebElement> list = driver.findElements(emailLocator);
            if (list.size()>0 && list.get(0).isDisplayed())
                break;
        }
    }

    public void scrollBy(int val){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0," + val +")");
    }


}

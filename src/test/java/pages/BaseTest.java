package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.Driver;
import utils.MyElement;
import utils.Waits;

import java.time.Duration;

public class BaseTest {

    protected WebDriver driver;
    protected WebDriverWait wait;

    {
        driver = Driver.getDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    /**
     *
     * @param locator
     */
    public void click(By locator){
        wait.until(ExpectedConditions.elementToBeClickable(locator)).click();
    }

    public void clear(By locator){
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator)).clear();
    }

    public void sendKeys(By locator, String text){
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator)).sendKeys(text);
    }

    public void waitForElement(By locator, Waits wait){
        switch (wait){
            case CLICKABLE -> this.wait.until(ExpectedConditions.elementToBeClickable(locator));
            case VISIBILITY -> this.wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
            default -> this.wait.until(ExpectedConditions.presenceOfElementLocated(locator));
        }
    }

    public void hover(WebElement element){
        new Actions(driver).moveToElement(element).build().perform();
    }

    public void scrollIntoView(WebElement webElement){
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true)",webElement);
    }

    public By getXPathOfEmailFromPageWithId(int id){
        return By.xpath("//datatable-body-row[.//datatable-body-cell[.//*[text()='"+ id +"']]]//datatable-body-cell[4]");
    }

}

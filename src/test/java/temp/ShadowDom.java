package temp;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import pages.BaseTest;
import utils.Waits;

import java.util.List;


public class ShadowDom extends BaseTest {  // Shadow Root

    @Test
    public void test01(){
        driver.get("https://www.htmlelements.com/demos/input/shadow-dom/");

        waitForElement(By.cssSelector("div.demo-technical-demo"),Waits.EXISTS);

        WebElement iFrame = driver.findElement(By.cssSelector("iframe[class='demo-frame']"));
        driver.switchTo().frame(iFrame);

        // Shadow Root içindeki elementler için cssSelector, id, tagName kullanırız.
        WebElement textArea = driver.findElement(By.tagName("smart-ui-text-area"))
                .getShadowRoot()
                .findElement(By.cssSelector("textarea[smart-id='input']"));

        textArea.sendKeys("Alkan");
    }

    @Test
    public void testTask01(){
        driver.get("https://www.htmlelements.com/demos/menu/shadow-dom/");
        driver.switchTo().frame(0);

        Actions actions = new Actions(driver);

        List<WebElement> list  = driver
                .findElement(By.tagName("smart-ui-menu"))
                .getShadowRoot()
                .findElements(By.cssSelector("div[class='smart-menu-item-label-element']"));

        for (WebElement webElement : list) {
            actions
                    .moveToElement(webElement)
                    .pause(200)
                    .click()
                    .build()
                    .perform();
        }

    }

    @Test
    public void testTask01AhmetHoca() throws InterruptedException {
        driver.manage().window().maximize();
        driver.get("https://www.htmlelements.com/demos/menu/shadow-dom/");

                driver.switchTo().frame(0);

        List<WebElement> elements = driver.findElement(By.tagName("smart-ui-menu"))
                .getShadowRoot()
                .findElements(By.cssSelector("div[smart-id='mainContainer'] smart-menu-items-group"));

        for (WebElement element : elements) {
            //scrollIntoView(element);
            hover(element);
            element.click();
//            List<WebElement> subElements = element
//                    .findElements(By.xpath(".//div"));

            List<WebElement> subElements = element
                    .findElements(By.cssSelector("div.smart-menu-item-container > smart-menu-item"));

            for (WebElement subElement : subElements) {
                hover(subElement);
                Thread.sleep(300);
            }
            //element.click();
        }
    }


    @AfterTest
    public void tearDown(){
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        driver.quit();
    }
}

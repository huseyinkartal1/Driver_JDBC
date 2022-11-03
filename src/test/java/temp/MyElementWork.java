package temp;

import org.openqa.selenium.By;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import utils.Conditions;
import utils.Driver;

import static utils.MyElement.$;
import static utils.MyElement.open;

public class MyElementWork {

    @Test
    public void test01(){
        open("https://demowebshop.tricentis.com/");
        $(By.id("small-searchterms"))
                .shouldBe(Conditions.visible)
                .scrollIntoView()
                .sendKeys("computer")
                .pressEnter();

        String text = $(By.cssSelector("div.product-item"),3)
                .shouldBe(Conditions.visible)
                .scrollIntoView()
                .getText();
        System.out.println(text);
    }

    @AfterTest
    public void tearDown(){
        Driver.quitDriver();
    }


}

package utils;

import org.openqa.selenium.By;

public enum MenuButtons {
    CUSTOMERS(By.xpath("//header//a[./span[text()='Customers'] or text()='Customers']")),
    EMPLOYEES(By.xpath("//header//a[./span[text()='Employees'] or text()='Employees']"))
    ;
    private By locator;

    MenuButtons(By locator) {
        this.locator = locator;
    }

    public void click(){
        Driver.getDriver().findElement(locator).click();
    }

}
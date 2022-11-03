package pages;

import org.openqa.selenium.By;

public class LocatorClass {

    public static final String url = "http://142.93.110.12:9119/#/login";
    public static final By usernameInputLogin = By.cssSelector("input[name='username']");
    public static final By passwordInputLogin = By.cssSelector("input[name='password']");
    public static final By buttonSubmitLogin = By.xpath("//button[text()='LOG IN']");
    public static final By buttonLogout = By.cssSelector("a[href='#/logout']");

}

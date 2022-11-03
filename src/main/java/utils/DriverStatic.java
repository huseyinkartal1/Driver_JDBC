package utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverStatic {
    // Singleton

    private static WebDriver driver;

    public static WebDriver getDriver(){
        return getDriver(Browsers.CHROME);
    }

    public static WebDriver getDriver(Browsers browser){
        if (driver == null){
            switch (browser){
                case FIREFOX -> {
                    WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver();
                }
                case EDGE -> {
                    WebDriverManager.edgedriver().setup();
                    driver = new EdgeDriver();
                }
                default -> {
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
                }
            }
        }
        return driver;
    }

    public static void quitDriver(){
        if (driver != null){
            driver.quit();
        }
    }

}

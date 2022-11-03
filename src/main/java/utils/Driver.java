package utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Driver {

    private static ThreadLocal<WebDriver> drivers = new ThreadLocal<>();

    public static WebDriver getDriver(){
        return getDriver(Browsers.CHROME);
    }

    public static WebDriver getDriver(Browsers browser){
        if (drivers.get() == null){
            switch (browser){
                case FIREFOX -> {
                    WebDriverManager.firefoxdriver().setup();
                    drivers.set(new FirefoxDriver());
                }
                case EDGE -> {
                    WebDriverManager.edgedriver().setup();
                    drivers.set(new EdgeDriver());
                }
                default -> {
                    WebDriverManager.chromedriver().setup();
                    drivers.set(new ChromeDriver());
                }
            }
        }
        return drivers.get();
    }

    public static void quitDriver(){
        if (drivers.get() != null){
            drivers.get().close();
            drivers.set(null);
        }
    }


}

package runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import utils.Browsers;
import utils.Driver;

@CucumberOptions(
        features = {"src/test/java/features/Feature1.feature"},
        glue = {"stepdefs"},
        plugin = {"pretty","html:test-output/cucumber-reports/Cucumber.html"}

)


public class Runner01 extends AbstractTestNGCucumberTests {

    @BeforeTest
    @Parameters("browser")
    public void beforeTest(@Optional("CHROME") String browser){
        Driver.getDriver(Browsers.valueOf(browser));
    }

}

package stepdefs;

import io.cucumber.java.AfterAll;
import utils.Driver;

public class Hooks {

    @AfterAll
    public static void afterAll(){
        Driver.quitDriver();
    }

}

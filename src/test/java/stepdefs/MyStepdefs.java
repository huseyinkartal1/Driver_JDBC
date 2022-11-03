package stepdefs;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import pages.BaseTest;
import pages.LocatorInterface;
import utils.MenuButtons;
import utils.MyConnection;
import utils.Waits;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;

public class MyStepdefs extends BaseTest implements LocatorInterface{

    @Given("user on homepage")
    public void userOnHomepage() {
        driver.get(url);
    }

    @When("user login as follow")
    public void userLoginAsFollow(DataTable table) {
        Map<String, String> map = table.asMap();
        sendKeys(usernameInputLogin, map.get("username"));
        sendKeys(passwordInputLogin, map.get("password"));
        click(buttonSubmitLogin);
    }

    @Then("login should be successfull")
    public void loginShouldBeSuccessfull() {
        waitForElement(buttonLogout, Waits.VISIBILITY);
    }

    @Given("user on customers page")
    public void userOnCustomersPage() {
        MenuButtons.EMPLOYEES.click();
    }

    String email;

    @When("user search for email with id {int}")
    public void userSearchForEmailWithId(int customerId) throws SQLException {
        MyConnection connection = new MyConnection(
                "jdbc:mysql://142.93.110.12:3306/admindashboarddb",
                "gsuser",
                "Gsuser!123456");

        ResultSet resultSet = connection.getResultSet("SELECT email FROM employees WHERE id = " + customerId + ";");
        resultSet.next();
        email = resultSet.getString(1);

        connection.tearDown();

    }

    @Then("email should be listed in the page")
    public void emailShouldBeListedInThePage() {
        waitForElement(By.xpath("//*[text()='"+ email +"']"),Waits.EXISTS);

    }

    @When("user get email from page with id {int}")
    public void userGetEmailFromPageWithId(int customerId) {
        waitForElement(getXPathOfEmailFromPageWithId(customerId),Waits.EXISTS);

        email = driver.findElement(getXPathOfEmailFromPageWithId(customerId)).getText();

    }

    @Then("email should be exist in DB")
    public void emailShouldBeExistInDB() throws SQLException {
        MyConnection connection = new MyConnection(
                "jdbc:mysql://142.93.110.12:3306/admindashboarddb",
                "gsuser",
                "Gsuser!123456");

        ResultSet resultSet = connection.getResultSet("SELECT COUNT(*) FROM employees WHERE email = '"+ email + "';");
        resultSet.next();

        Assert.assertTrue(resultSet.getInt(1)>0);

        connection.tearDown();

    }

    @Given("user on employees page")
    public void userOnEmployeesPage() {
        MenuButtons.EMPLOYEES.click();
    }

    @Then("user equate {int} and {int}")
    public void userEquateAnd(int a, int b) {
        Assert.assertEquals(a,b);
    }
}

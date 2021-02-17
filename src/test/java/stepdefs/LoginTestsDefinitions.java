package stepdefs;

import io.cucumber.java.AfterStep;
import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pages.IndexPage;
import utilities.BaseTest;

public class LoginTestsDefinitions extends BaseTest {


    protected IndexPage indexPage;

    @Given("I'm using {word}")
    public void i_m_using(String browser){
        setBrowser(browser);
    }

    @And("I'm in login page")
    public void i_m_in_login_page() {
        setup();
    }

    @When("I enter the username {word} and password {word}")
    public void i_enter_the_username_and_password(String username, String password) {
        log.login(username,password);
        indexPage = new IndexPage(driver, 15);
    }

    @Then("I should be logged in")
    public void i_should_be_logged_in() {
        Assert.assertTrue(indexPage.indexPageLoaded());
    }

    @Then("I should not be logged in")
    public void i_should_not_be_logged_in() {
        Assert.assertTrue(log.isWrongLoginTextPresent());
    }

    @After
    public void wrapUp(){
        tearDown();
    }
}

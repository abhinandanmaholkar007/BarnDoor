package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pageObjects.LoginPage;
import utils.TestContextSetUp;

import java.io.IOException;

public class LoginStepDefinition {
    TestContextSetUp testContextSetUp;
    LoginPage loginPage;
    public LoginStepDefinition(TestContextSetUp testContextSetUp)
    {
        this.testContextSetUp=testContextSetUp;
        this.loginPage=testContextSetUp.pageObjectManager.getLoginPage();
    }


    @Given("the user is on the login page")
    public void the_user_is_on_the_login_page()  {
        try {
            testContextSetUp.testBase.WebDriverManager();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @When ("user login with valid credential userName as {string} and password {string}")
    public void user_login_with_valid_credential(String un, String pass)  {
        loginPage.login(un,pass);
    }
    @Then("verify dashboard URL {string}")
    public void verify_dashboard_URL(String expDashUrl)
    {
      String actualDashUrl=loginPage.verifyDashboard();
        System.out.println(actualDashUrl);
        Assert.assertEquals(actualDashUrl,expDashUrl);
    }




}

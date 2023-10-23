package stepdefinitions;

import io.cucumber.java.en.Then;
import pageObjects.AddNewPasture;
import utils.TestContextSetUp;

public class AddNewPastureStepDefinition {
    TestContextSetUp testContextSetUp;
    AddNewPasture addNewPasture;
    public AddNewPastureStepDefinition(TestContextSetUp testContextSetUp)
    {
        this.testContextSetUp=testContextSetUp;
        this.addNewPasture=testContextSetUp.pageObjectManager.getAddNewPasture();
    }

    @Then("add pasture {string} and extract confirmation message")
    public void add_pasture_and_extract_confirmation_message(String pastureName) throws InterruptedException {
        String confMsg=addNewPasture.clickOnPasture(pastureName);
        System.out.println(confMsg);
    }
}

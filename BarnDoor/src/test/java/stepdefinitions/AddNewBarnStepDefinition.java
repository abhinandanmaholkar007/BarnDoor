package stepdefinitions;

import io.cucumber.java.en.Then;
import pageObjects.AddNewBarn;
import utils.TestContextSetUp;

public class AddNewBarnStepDefinition {
    TestContextSetUp testContextSetUp;
    AddNewBarn addNewBarn;
    public AddNewBarnStepDefinition(TestContextSetUp testContextSetUp)
    {
        this.testContextSetUp=testContextSetUp;
        this.addNewBarn=testContextSetUp.pageObjectManager.getAddNewBarn();
    }

    @Then("enters the barn name {string} and Number of Stalls as {string}")
    public void User_click_on_the_Barn_and_horses_icon_and_Add_new_barn_details(String barnName,String stallsNumber) throws InterruptedException {
        addNewBarn.addBarnDetails(barnName,stallsNumber);
    }

    @Then("clicks on the save button and extract barn confirmation message")
    public void clicks_on_the_save_button()  {
        String confMsg=addNewBarn.addBarn();
        System.out.println(confMsg);
    }
}

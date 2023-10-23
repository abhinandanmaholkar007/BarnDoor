package stepdefinitions;

import io.cucumber.java.en.Then;
import pageObjects.AddNewHorse;
import utils.TestContextSetUp;

public class AddNewHorseStepDefinition {
    TestContextSetUp testContextSetUp;
    AddNewHorse addNewHorse;
    public AddNewHorseStepDefinition(TestContextSetUp testContextSetUp)
    {
        this.testContextSetUp=testContextSetUp;
        this.addNewHorse=testContextSetUp.pageObjectManager.getAddNewHorse();
    }

    @Then("Clicks on the barn and horse icon and add horse {string}")
    public void Clicks_on_the_barn_and_horse_icon_and_add_horse(String horseName) throws InterruptedException {
      addNewHorse.addHorse(horseName);
    }


}

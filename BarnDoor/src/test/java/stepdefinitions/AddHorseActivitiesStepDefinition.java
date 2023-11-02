package stepdefinitions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import pageObjects.AddHorseActivities;
import utils.TestContextSetUp;

public class AddHorseActivitiesStepDefinition {
    TestContextSetUp testContextSetUp;
    AddHorseActivities addHorseActivities;
    public AddHorseActivitiesStepDefinition(TestContextSetUp testContextSetUp)
    {
        this.testContextSetUp=testContextSetUp;
        this.addHorseActivities=testContextSetUp.pageObjectManager.getHorseActivities();
    }

    @Then("Clicks on the barn and horse icon and go to activity")
    public void Clicks_on_the_barn_and_horse_icon_and_go_to_activity()  {
        addHorseActivities.goToActivitiesScreen();
    }

    @Then("create shoeing activity by entering Shoeing Date as {string} and Repeat Shoeing Activity as {string}")
    public void create_different_activities(String ShoeingDate,String RepeatShoeingActivity)  {
       addHorseActivities.addShoeing(ShoeingDate,RepeatShoeingActivity);
    }


}

package stepdefinitions;
import io.cucumber.java.en.Then;
import pageObjects.SearchHorse;
import utils.TestContextSetUp;

public class SearchHorseStepDefinition {
    TestContextSetUp testContextSetUp;
    SearchHorse searchHorse;
    public SearchHorseStepDefinition(TestContextSetUp testContextSetUp)
    {
        this.testContextSetUp=testContextSetUp;
        this.searchHorse=testContextSetUp.pageObjectManager.getSearchHorse();
    }

    @Then("Clicks on the barn and horse icon and search horse {string}")
    public void Clicks_on_the_barn_and_horse_icon_and_search_horse(String searchedHorse) throws InterruptedException {
       searchHorse.searchHorseWithName(searchedHorse);
    }

    @Then("Searched horse should be populated")
    public void Searched_horse_should_be_populated()
    {

    }


}

package stepdefinitions;



import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.serenitybdd.screenplay.GivenWhenThen;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.questions.Remembered;
import org.hamcrest.Matchers;
import tasks.CountCharacters;
import tasks.GetCharacterData;
import tasks.GoOverNavigationPages;
import tasks.GoOverNonExistentPages;
import utils.Constants;
import utils.RickAndMortyPaths;

import java.util.Map;

public class ConsumeApisStepDefinitions {



    @Given("^I want to test rick and morty data$")
    public void iWantToTestRickAndMortyData() {
        OnStage.theActorCalled("user").attemptsTo(GetCharacterData.getCharacterData(Constants.BASE_URL, RickAndMortyPaths.CHARACTERS.getValue()));
    }

    @When("^I count displayed characters$")
    public void iCountCharactersDisplayed() {
        OnStage.theActorInTheSpotlight().attemptsTo(CountCharacters.countCharacters());
    }

    @When("^I go over the navigation pages$")
    public void iGoOverTheNavigationPages() {
        OnStage.theActorInTheSpotlight().attemptsTo(GoOverNavigationPages.goOverNavigationPages());
    }

    @When("^I go over a non-existent page$")
    public void igoOverANonExistentPage() {
        OnStage.theActorInTheSpotlight().attemptsTo(GoOverNonExistentPages.goOverNavigationPages());
    }

    @Then("^The value in the pagination is the same$")
    public void theValueInThePaginationIsTheSame() {
        OnStage.theActorInTheSpotlight().should(
                GivenWhenThen.seeThat(Remembered.valueOf(Constants.COUNT_CHARACTERS_VALIDATION), Matchers.is(true)),
                GivenWhenThen.seeThat(Remembered.valueOf(Constants.CODE_STATUS),Matchers.is(200)));
    }

    @Then("^The navigation shows valid values$")
    public void theNavigationShowsValidValues() {
        OnStage.theActorInTheSpotlight().should(GivenWhenThen.seeThat(Remembered.valueOf(Constants.NAVIGATION_VALIDATION), Matchers.is(true)));
    }
    @Then("^The result will be (.*) and (.*)$")
    public void theMessageForNoFound(String message, String code) {
        OnStage.theActorInTheSpotlight().should(
                GivenWhenThen.seeThat(Remembered.valueOf(Constants.ERROR_RESPONSE), Matchers.is(message)),
                        GivenWhenThen.seeThat(Remembered.valueOf(Constants.NON_EXISTENT_PAGE_CODE_STATUS), Matchers.is(code)));
    }

}

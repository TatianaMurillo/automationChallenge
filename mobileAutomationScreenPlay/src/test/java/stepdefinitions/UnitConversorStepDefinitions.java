package stepdefinitions;

import Interactions.GoToMenuOption;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.GivenWhenThen;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import questions.TheAreaConversionValidation;
import questions.TheLongitudeConversionValidation;
import questions.TheVelocityConversionValidation;


import tasks.ConvertAreas;
import tasks.ConvertLongitudes;
import tasks.ConvertVelocities;


import java.util.Map;

public class UnitConversorStepDefinitions {


    @Before
    public void setUp() {

        OnStage.setTheStage(new OnlineCast());
    }


    @Given("^I want to convert (.*)$")
    public void iWantToConvertLongitudes(String option) {

        OnStage.theActorCalled("user").attemptsTo(GoToMenuOption.goToMenuOption(option));

    }


    @When("^I introduce the values for longitudes$")
    public void iIntroduceTheValuesInTheApplication(Map<String,String> data) {
        OnStage.theActorInTheSpotlight().attemptsTo(ConvertLongitudes.convertLongitudes(data));
    }

    @When("^I introduce the values for Velocities$")
    public void iIntroduceTheVelocityValuesInTheApplication(Map<String,String> data) {
        OnStage.theActorInTheSpotlight().attemptsTo(ConvertVelocities.convertVelocities(data));
    }

    @When("^I introduce the values for Areas$")
    public void iIntroduceTheAreasValuesInTheApplication(Map<String,String> data) {
        OnStage.theActorInTheSpotlight().attemptsTo(ConvertAreas.convertAreas(data));
    }

    @Then("^I get the equivalent value for the target unit$")
    public void iGetTheEquivalentValueForTheTargetUnit() {
    OnStage.theActorInTheSpotlight().should(GivenWhenThen.seeThat(TheLongitudeConversionValidation.getResult()));
    }

    @Then("^I get the equivalent value for velocity$")
    public void iGetTheEquivalentValueForVelocity() {
        OnStage.theActorInTheSpotlight().should(GivenWhenThen.seeThat(TheVelocityConversionValidation.getResult()));
    }



    @Then("^I get the equivalent value for area$")
    public void iGetTheEquivalentValueForArea() {
        OnStage.theActorInTheSpotlight().should(GivenWhenThen.seeThat(TheAreaConversionValidation.getResult()));
    }
}

package definitions;


import io.appium.java_client.android.AndroidDriver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import steps.UnitConversorSteps;
import utils.ConfigureAppiumProperties;

import java.net.MalformedURLException;
import java.util.Map;

public class UnitConversorDefinitions {

    AndroidDriver driver;

     UnitConversorSteps steps;

    @Before
    public void initialSetUp() throws MalformedURLException{
        driver= ConfigureAppiumProperties.getDriver();
    }
    @Given("^I want to convert units$")
    public void iWantTConvertUnits() {
        steps=UnitConversorSteps.init(driver);
    }
    @When("^I introduce the values in the application$")
    public void iHaveTheValueInOriginUnit(Map<String,String> data) {
        steps.convertUnit(data);
    }
    @Then("^I get the equivalent value for the target unit$")
    public void iGetTheEquivalentValueInDestinyUnit() {
        steps.getConvertedValue();
    }


    @After
    public void endSetUp(){
        driver.quit();
    }
}

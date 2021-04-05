package runners;

import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import net.serenitybdd.cucumber.CucumberWithSerenity;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features="src/test/resources/features/unitConversor.feature",
        glue = "stepdefinitions",
        tags = {"@Test1"},
        snippets = SnippetType.CAMELCASE
)
public class UnitConversor {

}

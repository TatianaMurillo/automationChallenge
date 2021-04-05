package questions;


import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;
import userinterfaces.ConvertionPage;
import utils.Constants;


public class TheAreaConversionValidation implements Question<Boolean> {


    public TheAreaConversionValidation() {
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        String calculatedLongitude= actor.recall(Constants.CALCULATED_AREA);
        String value=  Text.of(ConvertionPage.TARGET_VALUE).viewedBy(actor).asString().replace(" ","");

        return calculatedLongitude.contains(value);

    }


    public static TheAreaConversionValidation getResult(){
        return new TheAreaConversionValidation();
    }


}
